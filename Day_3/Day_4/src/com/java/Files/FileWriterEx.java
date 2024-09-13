package com.java.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
	
	public static void main(String[] args) {
		File src= new File("D:/Java_Training/Day_3/Day_4/src/com/java/Files/FileEx1.java");
		File tar=new File("D:/Files/Copy.txt");
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(tar);
			int ch;
			while((ch=fr.read())!=-1){
				fw.write((char)ch);
			}
			fr.close();
			fw.close();
			
			System.out.println("File Copied....");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
