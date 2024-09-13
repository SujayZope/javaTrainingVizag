package com.java.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadEmployee {
	
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("D:/Files/Employee.txt");
			ObjectInputStream obj=new ObjectInputStream(fin);
			Employee employee = (Employee)obj.readObject();
			obj.close();
			fin.close();
			System.out.println(employee);
		} catch (FileNotFoundException e) {
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
