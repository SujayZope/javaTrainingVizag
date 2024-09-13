package com.infinite.java;

import java.sql.SQLException;
import java.util.Scanner;


public class SearchStockMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stockId;
		System.out.println("Enter StockId  ");
		stockId = sc.next();
		StockDAO dao= new StockDaoImpl();
		try {
			Stock stock = dao.searchStock(stockId);
			if (stock!=null) {
				System.out.println(stock);
			} else {
				System.out.println("StockID Not Found...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
