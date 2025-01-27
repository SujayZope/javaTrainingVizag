package com.java.ejb;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class OyoDaoImpl implements OyoDao {

	public String generateRoomID() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Room.class);
		cr.setProjection(Projections.max("RoomID"));
		String str = (String) cr.uniqueResult();
		if(str==null){
			return "R001";
		}
		String sub = str.substring(1);
		int rid = Integer.parseInt(sub);
		rid++;
		return String.format("R%03d", rid);
	}

	@Override
	public String addRoomDao(Room room) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		room.setRoomID(generateRoomID());
		Transaction t = session.beginTransaction();
		session.save(room);
		t.commit();
		System.out.println("Record Inserted...");
		return "Data inserted successfully...";
	}
	
	@Override
	public List<Room> showRoomDao() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr= session.createCriteria(Room.class);
		List<Room> roomList = cr.list();
		return roomList;
	}
	
	public String GenerateBookID(){
  	  
        SessionFactory sf=SessionHelper.getConnection();
   		Session session =sf.openSession();
   		Criteria cr=session.createCriteria(Booking.class);
   		
   		 List<Booking> bList=cr.list();
   		
   		if(bList.size()==0){
   			String strfound="B001";
   			return strfound;
   		}else{
   			String strfound=bList.get(bList.size()-1).getBookId();
   			
   			String sub=strfound.substring(1);
   			
   			int temp=Integer.parseInt(sub);
   			
   			temp=temp+1;
   			
   			strfound=String.format("B%03d", temp);
   			
   			return strfound;
   			
   		}
        }
	
	@Override
	public String bookRoom(Booking booking) {
        Date date=new Date(); 
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        java.sql.Date startDate = new java.sql.Date(booking.getChkInDate().getTime());
        java.sql.Date endDate = new java.sql.Date(booking.getChkOutDate().getTime());
        
        
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans=session.beginTransaction();
		
		booking.setBookId(GenerateBookID());
		booking.setBookDate(sqlDate);
		booking.setChkInDate(startDate);
		booking.setChkOutDate(endDate);
		session.save(booking);
		
		 Criteria cr = session.createCriteria(Room.class);
		 cr.add(Restrictions.eq("roomId", booking.getRoomID()));
		 Room room = (Room) cr.uniqueResult();
		 System.out.println(room);
		 room.setStatus(RStatus.BOOKED);
		 
		 session.update(room);
		
		 trans.commit();

	
	     
		return "Room Booked...";
	}

	@Override
	public List<Booking> showBooking() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Booking.class);
		List<Booking> bookList = cr.list();
        return bookList;
	}

	@Override
	public String billingOfRoom(Billing bill) {
		

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans=session.beginTransaction();
		Criteria cr = session.createCriteria(Booking.class);
		cr.add(Restrictions.eq("bookId", bill.getBookID()));
		 Booking book = (Booking) cr.uniqueResult();
		 
		  int noOfDays;
		  long ms =  book.getChkOutDate().getTime()-book.getChkInDate().getTime();
	      System.out.println(ms);
	      noOfDays = (int)( (ms)/(1000 * 60 * 60 * 24));
	      int count=++noOfDays;
		bill.setRoomID(book.getRoomID());
		bill.setNoOfDays(count);

		Criteria cr1 = session.createCriteria(Room.class);
		cr1.add(Restrictions.eq("roomId", bill.getRoomID()));
		 Room room = (Room) cr1.uniqueResult();
		 bill.setBillAmt(count*room.getCostPerDay());
		 
		session.save(bill);
		
		room.setStatus(RStatus.AVAILABLE);
		session.update(room);
		trans.commit();
		return "Billing Done..";
		
	}

}
