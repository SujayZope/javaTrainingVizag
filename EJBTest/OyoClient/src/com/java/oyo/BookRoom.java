package com.java.oyo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.xnio.IoFuture.Status;

public class BookRoom {
	public static void main(String[] args) {
		OyoCrudBeanRemote remote = doLookup();

		Booking book = new Booking();

		List<Room> roomList = remote.showRoom();
		for (Room room1 : roomList) {
			System.out.println(room1);
		}

		String dateFormat = "yyyy-MM-dd";

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Room ID");
		book.setRoomId(sc.next());
		System.out.println("Enter Customer Name");
		book.setCustomerName(sc.next());
		System.out.println("Enter City");
		book.setCity(sc.next());
		try {
			System.out.println("Enter Check in Date (yyyy-MM-dd)");

			book.setCheckinDate(new SimpleDateFormat(dateFormat).parse(sc.next()));

			System.out.println("Enter Check out Date (yyyy-MM-dd)");
			book.setCheckoutDate(new SimpleDateFormat(dateFormat).parse(sc.next()));

			System.out.println(remote.bookRoom(book));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static OyoCrudBeanRemote doLookup() {
		Context context = null;
		OyoCrudBeanRemote bean = null;
		try {
			// 1. Obtaining Context
			context = getInitialContext();
			// 2. Lookup and cast
			bean = (OyoCrudBeanRemote) context.lookup(LOOKUP_STRING);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static final String LOOKUP_STRING = "OyoCrudBean/remote";
	/*
	 * * location of JBoss JNDI Service provider the client will use. It should
	 * be * URL string.
	 */
	private static final String PROVIDER_URL = "jnp://localhost:1099";
	/*
	 * * specifying the list of package prefixes to use when loading in URL *
	 * context factories. colon separated
	 */
	private static final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";
	/*
	 * * Factory that creates initial context objects. fully qualified class
	 * name.
	 */
	private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
	private static Context initialContext;

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			// Properties extends HashTable
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
			prop.put(Context.PROVIDER_URL, PROVIDER_URL);
			initialContext = new InitialContext(prop);
		}
		return initialContext;
	}
}