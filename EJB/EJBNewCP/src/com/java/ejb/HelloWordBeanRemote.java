package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWordBeanRemote {

	String sayHello();
}
