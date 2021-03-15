
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/htm");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		String dName = context.getInitParameter("DriverName");
		String dLink = context.getInitParameter("DatabaseLink");
		System.out.println("dName: "+dName);
		System.out.println("dLink: "+dLink);
		
		
		String name = request.getParameter("userName");
		String password = request.getParameter("userPass");

		UserDetails newUser = new UserDetails(name, password);
		int status = UserDatabase.save(newUser);

		if (status > 0) {
			
			RequestDispatcher rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
			//response.sendRedirect("https://www.youtube.com/watch?v=EiuKnHNFwRU"); 
		} else {
			
			out.println("Registration failed");
		}

		// MysqlCon ob = new MysqlCon();
		// ob.callDataBase(name,password);
	}

}
