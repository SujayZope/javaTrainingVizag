package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface OyoBeanRemote {
	String addRoomDao(Room room);

	List<Room> showRoomDao();

	String bookRoom(Booking booking);

	List<Booking> showBooking();

	String billingOfRoom(Billing bill);
}
