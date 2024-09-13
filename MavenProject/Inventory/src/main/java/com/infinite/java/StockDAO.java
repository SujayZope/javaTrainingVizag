package com.infinite.java;

import java.sql.SQLException;
import java.util.List;

public interface StockDAO {

	String createStock(Stock stock) throws ClassNotFoundException, SQLException;
	Stock searchStock(String stockId) throws ClassNotFoundException, SQLException;
	List<Stock> showStockDao() throws ClassNotFoundException, SQLException;
	String placeOrder(Orders orders) throws ClassNotFoundException, SQLException;
}
