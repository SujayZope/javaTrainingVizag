package com.java.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalcBean
 */
@Stateless
@Remote(CalcBeanRemote.class)
public class CalcBean implements CalcBeanRemote {

    /**
     * Default constructor. 
     */
    public CalcBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int sum(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int multi(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

}
