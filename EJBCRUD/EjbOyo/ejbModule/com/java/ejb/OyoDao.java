package com.java.ejb;

import java.util.List;

public interface OyoDao {

	String addRoomDao(Room room);

	List<Room> showRoomDao();

	String bookRoom(Booking booking);

	List<Booking> showBooking();

	String billingOfRoom(Billing bill);

}
