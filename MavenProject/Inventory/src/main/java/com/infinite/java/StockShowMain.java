package com.infinite.java;

import java.sql.SQLException;
import java.util.List;

public class StockShowMain {

	public static void main(String[] args) {
		StockDAO dao= new StockDaoImpl();
		List<Stock> stockList;
		try {
			stockList = dao.showStockDao();
			for(Stock stock : stockList){
				System.out.println(stock);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
