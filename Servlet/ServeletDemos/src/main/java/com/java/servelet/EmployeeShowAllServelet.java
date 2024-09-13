package com.java.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class EmployeeShowAllServelet
 */
public class EmployeeShowAllServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeShowAllServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EmployeeDAO dao = new EmployeeDaoImpl();
		
		java.util.List<Employee> emplist;
		try {
			emplist = dao.showEmployeeDao();
			for (Employee emp : emplist) {
				out.println("Employee No " +emp.getEmpno()+"<br/>");
				out.println("Employee Name  " +emp.getName()+"<br/>");
				out.println("Employee Department " +emp.getDept()+"<br/>");
				out.println("Employee Designation " +emp.getDesig()+"<br/>");
				out.println("Employee Basic " +emp.getBasic()+"<br/>");
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
