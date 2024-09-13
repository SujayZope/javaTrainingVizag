package com.java.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	
	public static void main(String[] args) {
		try {
			FileInputStream fin= new FileInputStream("D:/Java_Training/Day_3/Day_4/src/com/java/Files/FileEx1.java");
			FileOutputStream fout=new FileOutputStream("D:/Files/Filecopy.txt");
			int ch;
			while((ch=fin.read())!=-1){
				fout.write((char)ch);
			}
			System.out.println("*** File Copied ***");
			fout.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
