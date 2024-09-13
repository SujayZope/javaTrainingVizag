package com.java.lms;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface LibraryDAO {
	
	List<Books> searchBooks();
	String authenticate(Login login);
	String validateMe(Login login);
	String addUser(Login login);
	String addBookDetailsDao(Books books);
	String updateBookDetailsDao(Books bNew);
	String deleteBookDetailsDao(int id);
	String searchBookDetailsDao(int id);
	
}