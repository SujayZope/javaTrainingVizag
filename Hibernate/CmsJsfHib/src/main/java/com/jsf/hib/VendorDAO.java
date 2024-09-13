package com.jsf.hib;

public interface VendorDAO {
	
	String addVendorDao(Vendor vendor);
	String validateMe(Vendor vendor);
	Vendor searchByVendorUser(String userName);

}
