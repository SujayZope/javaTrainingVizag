

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.ejb.CalculationBeanRemote;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties p = new Properties();
		p.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		p.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		p.put("java.naming.provider.url", "localhost:1099");
			CalculationBeanRemote service;
		int firstNo = Integer.parseInt(request.getParameter("firstNo"));
		int secondNo = Integer.parseInt(request.getParameter("secondNo"));
			try {
				service = (CalculationBeanRemote) new InitialContext(p).lookup("CalculationBean/remote");
				PrintWriter out = response.getWriter();
				out.println("Sum is  "  +service.sum(firstNo, secondNo) + "<Br/>");
				out.println("Sub is  " +service.sub(firstNo, secondNo) + "<Br/>");
				out.println("Result is  " +service.mult(firstNo, secondNo) + "<br/>");
			} catch (NamingException e) {
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
