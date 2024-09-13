package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface CalcBeanRemote {
	
	int sum(int x, int y);
	int sub(int x, int y);
	int multi(int x, int y);

}
