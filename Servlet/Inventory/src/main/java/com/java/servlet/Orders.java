package com.java.servlet;

public class Orders {
	
	private String OrderId;
	private String StockId;
	private double Price;
	private int qtyORD;
	
	
	public Orders() {
			}


	public Orders(String orderId, String stockId, double price, int qtyORD) {
		super();
		OrderId = orderId;
		StockId = stockId;
		Price = price;
		this.qtyORD = qtyORD;
	}


	public String getOrderId() {
		return OrderId;
	}


	public void setOrderId(String orderId) {
		OrderId = orderId;
	}


	public String getStockId() {
		return StockId;
	}


	public void setStockId(String stockId) {
		StockId = stockId;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public int getQtyORD() {
		return qtyORD;
	}


	public void setQtyORD(int qtyORD) {
		this.qtyORD = qtyORD;
	}


	@Override
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", StockId=" + StockId + ", Price=" + Price + ", qtyORD=" + qtyORD + "]";
	}
	
	

}
