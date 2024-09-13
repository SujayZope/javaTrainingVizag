package com.java;


import java.util.List;

public interface LibraryDao {

	List<Books> showBooksDao();
	
	String validateMe(LibUsers libusers);
	
	String addUserDao(LibUsers libusers);
	
	List<Books> searchBook(String searchType , String searchValue);
}
