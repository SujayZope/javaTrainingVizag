package com.java.stock;

import java.text.ParseException;

import java.util.List;

import infinite.HealthPharmacy.Stock;

public interface StockDAO {

	List<Stock> showStock();

	//String addStock(Stock stock);

	String updateStock(Stock stock);

	String deleteStock(Stock stock);

	List<Stock> searchPharmName(String value);

//	List<Stock> getitemNames(String itemName);
	
	List<Stock> getPharmacyNames(); 
	
	Stock searchStock(int itemId);
	
	public int searchpharmaIdByName(String pharmaName);

	String addStock(Stock stock, int pharmaid);

	List<String> getitemNames();
	
//	public int searchPharmIdbyName(String itemName);

	String findPharmacyName(int pharmaId  );
	List<String> getPharmacyName();

}
