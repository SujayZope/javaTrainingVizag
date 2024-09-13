package com.java.serial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteEmployee {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("D:/Files/Employee.txt");
			ObjectOutputStream obj=new ObjectOutputStream(fout);
			Employee employee = new Employee(1,"Yogesh", 1031062);
			obj.writeObject(employee);
			obj.close();
			fout.close();
			System.out.println("Employee Object Stored...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
