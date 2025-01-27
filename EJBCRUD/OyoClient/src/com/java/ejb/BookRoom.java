package com.java.ejb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BookRoom {
	public static void main(String[] args) {
		Booking b = new Booking();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Room Id");
		b.setRoomID(sc.next());
		System.out.println("Enter the Cust Name");
		b.setCustName(sc.next());
		System.out.println("Enter the City");
		b.setCity(sc.next());
		System.out.println("Enter the chkIn date");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate;
		try {
			startDate = df.parse(sc.next());
			b.setChkInDate(startDate);
			System.out.println("Enter the chkOut date");
			Date edate = df.parse(sc.next());
			b.setChkOutDate(edate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub        

		OyoBeanRemote service = null;
		try {
			service = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(service.bookRoom(b));

	}
}