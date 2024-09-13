package com.java.Files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectOutEx {
	public static void main(String[] args) {
		FileOutputStream fout;
		
		try {
			fout = new FileOutputStream("D:/Files/data.txt");
			ObjectOutputStream obj= new ObjectOutputStream(fout);
			obj.writeObject(new String("Date is..."));
			obj.writeObject(new Date());
			fout.close();
			System.out.println("****  Object Stored in File  ****");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
