package com.java.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {
	
	public static void main(String[] args) {
		try {
			FileInputStream fin= new FileInputStream("D:/Java_Training/Day_3/Day_4/src/com/java/Files/FileEx1.java");

			int ch;
			while((ch=fin.read())!=-1){
				System.out.print((char)ch);
			}
			
			fin.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
