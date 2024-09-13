package com.infinite.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StockDaoImpl implements StockDAO {

	Connection connection;
	PreparedStatement pst;
	
	
	public String generateStockID() throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
        String cmd="select * from stock order by stockid desc";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String strfound=rs.getString("stockid");
        String sub=strfound.substring(1);
        int temp=Integer.parseInt(sub);
        temp=temp+1;
        strfound=String.format("S%03d", temp);
        return strfound;

	}
	
	@Override
	public String createStock(Stock stock) throws ClassNotFoundException, SQLException {
		String stockId = generateStockID();
		stock.setStockID(stockId);
		String cmd = "insert into stock(stockid, ItemName,Price,QuantityAvail) values(?,?,?,?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setString(1, stockId);
		pst.setString(2, stock.getItemName());
		pst.setDouble(3, stock.getPrice());
		pst.setInt(4, stock.getQuantityAvail());
		pst.executeUpdate();
		return "Stock Added...";
	}

	@Override
	public Stock searchStock(String stockId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from stock where stockid=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, stockId);
		ResultSet rs = pst.executeQuery();
		Stock stock = null;
		if (rs.next()) {
			stock = new Stock();
			stock.setStockID(rs.getString("stockId"));
			stock.setItemName(rs.getString("itemName"));
			stock.setPrice(rs.getDouble("price"));
			stock.setQuantityAvail(rs.getInt("quantityAvail"));
			
		}
		return stock;
	}

	@Override
	public List<Stock> showStockDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from stock";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Stock> stockList= new ArrayList<Stock>();
		Stock stock = null;
		while(rs.next()){
			stock=new Stock();
			stock.setStockID(rs.getString("stockId"));
			stock.setItemName(rs.getString("ItemName"));
			stock.setPrice(rs.getDouble("Price"));
			stock.setQuantityAvail(rs.getInt("QuantityAvail"));
			stockList.add(stock);
		}
		return stockList;
	}
	
	public String generateOrderId() throws ClassNotFoundException, SQLException{

        connection = ConnectionHelper.getConnection();

        String cmd="select * from orders order by orderid desc";

        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();

        if(rs.next()){

        String str=rs.getString("orderid");
        int num=Integer.parseInt(str);
        num=num+1;
        str = String.format("%03d", num);
        return str;
        }

        int num=001;
        String str2=String.format("%03d", num);
        return str2;




    }

	@Override
	public String placeOrder(Orders ord) throws ClassNotFoundException, SQLException {
		Stock st=searchStock(ord.getStockId());

        if(st!=null){
            if(st.getQuantityAvail()>ord.getQtyORD()){
            String orderIdg=generateStockID();
            ord.setOrderId(orderIdg);


            String cmd="insert into orders(orderid,stockid,qtyord,price) values(?,?,?,?)";
            connection = ConnectionHelper.getConnection();
            pst = connection.prepareStatement(cmd);

            pst.setString(1, orderIdg);
            pst.setString(2, ord.getStockId());
            pst.setInt(3,ord.getQtyORD());
            pst.setDouble(4,st.getPrice());

            pst.executeUpdate();

            cmd="update stock set QuantityAvail=? where stockid=?";
            pst = connection.prepareStatement(cmd);
            pst.setInt(1,st.getQuantityAvail()-ord.getQtyORD());
            pst.setString(2,ord.getStockId());

            pst.executeUpdate();

            double total=ord.getQtyORD()*st.getPrice();

            cmd="insert into amount(gamt) values(?)";
            pst = connection.prepareStatement(cmd);
            pst.setDouble(1,total);

            pst.executeUpdate();

            }else{
                return "not enough quantity ,available=" +st.getQuantityAvail();
            }

            return "order placed succefully";




        }
        return "stock does not exist";

    }

	}
	

