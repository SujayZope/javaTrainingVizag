package com.java.Files;

import java.io.File;
import java.util.Scanner;

public class ScanFile {
	
	public static void main(String[] args) {
		File src= new File("D:/Java_Training/Day_3/Day_4/src/com/java/Files/FileEx1.java");
		try {
			Scanner sc = new Scanner(src);
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
