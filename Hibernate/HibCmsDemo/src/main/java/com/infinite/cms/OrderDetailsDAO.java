package com.infinite.cms;

import java.util.List;

public interface OrderDetailsDAO {

	String placeOrder(int custId, int venId, int menuId, String walSource,int qty, String ordComments);
	List<Orders> customerPedingOrdersDao(int custId);
}
