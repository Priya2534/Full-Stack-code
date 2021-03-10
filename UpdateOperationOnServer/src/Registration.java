import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Registration")

public class Registration extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String fname = request.getParameter("fname");
		String birthdate = request.getParameter("birthdate");
		String emailid = request.getParameter("emailid");
		String mobileno = request.getParameter("mobileno");
		String password = request.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/registration";
		String uname= "root";
		String pass = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			String insertquery = "insert into userdata(fname,birthdate,emailid,mobileno,password) values (?,?,?,?,?) ";
			PreparedStatement st = con.prepareStatement(insertquery);
			st.setString(1, fname);
			st.setString(2, birthdate);
			st.setString(3, emailid);
			st.setString(4, mobileno);
			st.setString(5, password);
			st.execute();
			con.close();
			response.getWriter().print("Your registration is now completed yo can login.");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
		
		
	}

}
