package com.infinite.java;

public class Stock {

	private String stockID;
	private String itemName;
	private double price;
	private int quantityAvail;
	
	
	public Stock() {
	
	}


	public Stock(String stockID, String itemName, double price, int quantityAvail) {
		super();
		this.stockID = stockID;
		this.itemName = itemName;
		this.price = price;
		this.quantityAvail = quantityAvail;
	}


	public String getStockID() {
		return stockID;
	}


	public void setStockID(String stockID) {
		this.stockID = stockID;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantityAvail() {
		return quantityAvail;
	}


	public void setQuantityAvail(int quantityAvail) {
		this.quantityAvail = quantityAvail;
	}


	@Override
	public String toString() {
		return "Stock [stockID=" + stockID + ", itemName=" + itemName + ", price=" + price + ", quantityAvail="
				+ quantityAvail + "]";
	}
	
	
	
}
