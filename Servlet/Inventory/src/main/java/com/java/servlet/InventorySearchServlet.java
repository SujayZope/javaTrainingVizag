package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InventorySearchServlet
 */
public class InventorySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventorySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String stockId=request.getParameter("stockid");
		StockDAO dao=new StockDaoImpl();
		
		try {
			Stock stock=dao.searchStock(stockId);
			if(stockId!=null){
				out.println("Stock Id         =   " +stock.getStockID()+"<br/>");
				out.println("Item Name        =   " +stock.getItemName()+"<br/>");
				out.println("Price            =   " +stock.getPrice()+"<br/>");
				out.println("Quantity Avail   =   " +stock.getQuantityAvail()+"<br/>");
				
			}else{
				out.println("Record Not found....");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
