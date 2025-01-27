package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowRoom {

	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		
		OyoBeanRemote service = null;
		
		service = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
		
		List<Room> roomList = service.showRoomDao();
		
		for (Room room : roomList) {
			System.out.println(room);
		}
	}

}
