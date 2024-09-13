package com.java.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FilereadEx {
	
	public static void main(String[] args) {
		File fl =new File("D:/Java_Training/Day_3/Day_4/src/com/java/Files/FileEx1.java");
		
		try {
			FileReader fr= new FileReader(fl);
			int ch;
			while ((ch=fr.read())!=-1){
				System.out.print((char)ch);
			}
			fr.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
