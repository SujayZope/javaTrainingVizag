package com.java.oyo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface OyoCrudBeanRemote {

	 String addRoom(Room room);
	 
	 List<Room> showRoom();
	 
	 String bookRoom(Booking booking);
	 
	 List<Booking> showBooking();
	 
	 String billingOfRoom(Billing bill);
	 
}
