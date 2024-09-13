package com.java.Files;

import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {
		
		File fl= new File("D:/Java_Training/Day_3/Day_4/src/com/java/Files/FileEx1.java");
		System.out.println("File Name  " +fl.getName());
		System.out.println("File Name  " +fl.getPath());
		System.out.println("Parent  "+fl.getParent());
	}

}
