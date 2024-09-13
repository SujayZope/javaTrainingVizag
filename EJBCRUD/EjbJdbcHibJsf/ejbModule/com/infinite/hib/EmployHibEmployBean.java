package com.infinite.hib;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EmployHibEmployBean
 */
@Stateless
@Remote(EmployHibEmployBeanRemote.class)
public class EmployHibEmployBean implements EmployHibEmployBeanRemote {

    /**
     * Default constructor. 
     */
    public EmployHibEmployBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Employ> showEmployDao() {
		// TODO Auto-generated method stub
		return new EmployDaoImpl().showEmployDao();
	}

	@Override
	public String searchEmployDao(int empno) {
		// TODO Auto-generated method stub
		return new EmployDaoImpl().searchEmployDao(empno);
	}

}
