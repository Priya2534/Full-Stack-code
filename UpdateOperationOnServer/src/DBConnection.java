import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");

		String url = "jdbc:mysql://localhost:3306/registration";
		String dbuname = "root";
		String dbpass = "root";
		
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");// driver
			con = DriverManager.getConnection(url, dbuname, dbpass);
			PreparedStatement st =con.prepareStatement("select * from userdata where fname = ? and password = ?");
		    st.setString(1, uname);
		    st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				response.sendRedirect("Welcome.jsp");
				//response.getWriter().print("Welcome: "+ rs.getString(1));
				//response.getWriter().print("Login successful");
				
			}
			else {
				
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
			response.getWriter().print("Please enter correct username and password .");
			}

			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}

	}
	
}


























