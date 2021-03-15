
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/htm");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		String log = config.getInitParameter("logindata");
		System.out.println("login data: "+log);
		
		
		
		String name = request.getParameter("userName");
		String password = request.getParameter("userPass");
		
		if (UserDatabase.loginValidate(name, password)) {
			out.print("Welcome " + name);
			
		          
		} else {
			//request.getRequestDispatcher("login.html").include(request, response);
			//RequestDispatcher rd = request.getRequestDispatcher("LoginFailed.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginFailed.jsp");
			rd.forward(request, response);
			 
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
