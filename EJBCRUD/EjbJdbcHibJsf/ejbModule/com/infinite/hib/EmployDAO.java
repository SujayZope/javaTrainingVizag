package com.infinite.hib;

import java.util.List;

public interface EmployDAO {

	List<Employ> showEmployDao();
	String searchEmployDao(int empno);
}