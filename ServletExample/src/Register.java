
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
		String name = request.getParameter("userName");
		String password = request.getParameter("userPass");

		UserDetails newUser = new UserDetails(name, password);
		int status = UserDatabase.save(newUser);

		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			response.sendRedirect("Login.html"); 
			// request.getRequestDispatcher("index.html").include(request,
			// response);
		} else {
			
			out.println("Sorry! unable to save record");
		}

		// MysqlCon ob = new MysqlCon();
		// ob.callDataBase(name,password);
	}

}
