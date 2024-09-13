package com.java.oyo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Session Bean implementation class OyoCrudBean
 */
@Stateless
@Remote(OyoCrudBeanRemote.class)
public class OyoCrudBean implements OyoCrudBeanRemote {

    /**
     * Default constructor. 
     */
    public OyoCrudBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String GenerateID(){
  	  
        SessionFactory sf=SessionHelper.getConnection();
   		Session session =sf.openSession();
   		Criteria cr=session.createCriteria(Room.class);
   		
   		 List<Room> rList=cr.list();
   		
   		if(rList.size()==0){
   			String strfound="R001";
   			return strfound;
   		}else{
   			String strfound=rList.get(rList.size()-1).getRoomId();
   			
   			String sub=strfound.substring(1);
   			
   			int temp=Integer.parseInt(sub);
   			
   			temp=temp+1;
   			
   			strfound=String.format("R%03d", temp);
   			
   			return strfound;
   			
   		}
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
	public String addRoom(Room room) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans=session.beginTransaction();
		room.setRoomId(GenerateID());
		room.setStatus(Status.AVAILABLE);
		session.save(room);
		
		trans.commit();
		return "Room Addded...";
	}

	@Override
	public List<Room> showRoom() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Room.class);
		cr.add(Restrictions.eq("status", Status.AVAILABLE));
		List<Room> insuranceList = cr.list();
        return insuranceList;
	}

	@Override
	public String bookRoom(Booking booking) {
        Date date=new Date(); 
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        java.sql.Date startDate = new java.sql.Date(booking.getCheckinDate().getTime());
        java.sql.Date endDate = new java.sql.Date(booking.getCheckoutDate().getTime());
        
        
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans=session.beginTransaction();
		
		booking.setBookId(GenerateBookID());
		booking.setBookDate(sqlDate);
		booking.setCheckinDate(startDate);
		booking.setCheckinDate(endDate);
		session.save(booking);
		
		 Criteria cr = session.createCriteria(Room.class);
		 cr.add(Restrictions.eq("roomId", booking.getRoomId()));
		 Room room = (Room) cr.uniqueResult();
		 System.out.println(room);
		 room.setStatus(Status.BOOKED);
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
		cr.add(Restrictions.eq("bookId", bill.getBookId()));
		 Booking book = (Booking) cr.uniqueResult();
		 
		  int noOfDays;
		  long ms =  book.getCheckoutDate().getTime()-book.getCheckinDate().getTime();
	      System.out.println(ms);
	      noOfDays = (int)( (ms)/(1000 * 60 * 60 * 24));
	      int count=++noOfDays;
		bill.setRoomId(book.getRoomId());
		bill.setNoOfDays(count);

		Criteria cr1 = session.createCriteria(Room.class);
		cr1.add(Restrictions.eq("roomId", bill.getRoomId()));
		 Room room = (Room) cr1.uniqueResult();
		 bill.setBillAmt(count*room.getCostPerDay());
		 
		session.save(bill);
		
		room.setStatus(Status.AVAILABLE);
		session.update(room);
		trans.commit();
		return "Billing Done..";
		
	}

}
