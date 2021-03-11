

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/htm");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("userName");
		String password = request.getParameter("userPass");
		
		if (UserDatabase.loginValidate(name, password)) {
			//RequestDispatcher rd = request.getRequestDispatcher("servlet2");
			//rd.forward(request, response);
			out.print("Welcome "+name);  
		} else {
			out.print("Sorry username or password error");
			//RequestDispatcher rd = request.getRequestDispatcher("index.html");
			//rd.include(request, response);
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
