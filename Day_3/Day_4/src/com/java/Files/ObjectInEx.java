package com.java.Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectInEx {
	
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("D:/Files/data.txt");
			ObjectInputStream obj= new ObjectInputStream(fin);
			String str = (String)obj.readObject();
			Date dt = (Date)obj.readObject();
			System.out.println(str + dt);
			obj.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
