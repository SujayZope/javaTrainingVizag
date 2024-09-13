package com.java.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OyoBean
 */
@Stateless
@Remote(OyoBeanRemote.class)
public class OyoBean implements OyoBeanRemote {

    /**
     * Default constructor. 
     */
    public OyoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addRoomDao(Room room) {
		// TODO Auto-generated method stub
		return new OyoDaoImpl().addRoomDao(room);
	}

	@Override
	public List<Room> showRoomDao() {
		// TODO Auto-generated method stub
		return new OyoDaoImpl().showRoomDao();
	}

	@Override
	public String bookRoom(Booking booking) {
		// TODO Auto-generated method stub
		return new OyoDaoImpl().bookRoom(booking);
	}

	@Override
	public List<Booking> showBooking() {
		// TODO Auto-generated method stub
		return new OyoDaoImpl().showBooking();
	}

	@Override
	public String billingOfRoom(Billing bill) {
		// TODO Auto-generated method stub
		return new OyoDaoImpl().billingOfRoom(bill);
	}

}
