package com.java.ejb;

import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddRoom {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Room room = new Room();
		System.out.println("Enter Type of room  ");
		room.setType(sc.next());
//		System.out.println("Enter Status of room  ");
//		room.setStatus(Status.valueOf(sc.next()));
		room.setStatus(RStatus.AVAILABLE);
		System.out.println("Enter per day Cost  ");
		room.setCostPerDay(sc.nextInt());
		
		OyoBeanRemote service = null;
		    try {
				service = (OyoBeanRemote)
						new InitialContext().lookup("OyoBean/remote");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println(service.addRoomDao(room));
	}
}
