package com.infinite.hib;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EmployHibEmployBeanRemote {
	List<Employ> showEmployDao();
	String searchEmployDao(int empno);
}
