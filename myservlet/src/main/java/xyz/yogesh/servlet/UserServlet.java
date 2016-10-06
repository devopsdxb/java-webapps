package xyz.yogesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/test")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netfilms-db", "root", "root");
			Statement stmt = conn.createStatement();
			
			String sql = "select email from user";
			ResultSet result = stmt.executeQuery(sql);
		
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String[] emails = request.getParameterValues("selectEmail");
			
	        out.println("<!DOCTYPE html>");
	        out.println("<html><head>");
	        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	        out.println("<title>Users</title>");
	        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
	        out.println("</head>");
	        
	        out.println("<body>");
	        out.println("<h1>List of Users</h1>");
	
	        out.println("<div style=\"float: left; width: 25%;\">");
	        out.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"/myservlet/user\">");
	        out.println("<select multiple name=\"selectEmail\">");
	        
	        while(result.next()) {
	        	out.println("<option value=\"" + result.getString("email") + "\">" + result.getString("email") + "</option>");
	        }
	        out.println("</select>");
	        out.println("<br><input type=\"submit\" name=\"Submit\" value=\"Submit\"/>");
	        out.println("</form>");
	        out.println("</div>");
	        
	        out.println("<div style=\"float: left; width: 75%;\">");
			out.println("<table border=\"1\">");
			
			if(emails==null) {
				sql = "select * from user";
				result = stmt.executeQuery(sql);
				
				while(result.next()) {
					out.println("<tr><td>");
					out.println("Name: " + result.getString("name") + "<br>");
					out.println("Email: " + result.getString("email") + "<br>");
					out.println("User Type: " + result.getString("usertype") + "<br>");
					out.println("</td></tr>");
				}
			}
			else {
				for(String email : emails) {
					sql = "select * from user where email=\"" + email + "\"";
					result = stmt.executeQuery(sql);
					result.next();
					out.println("<tr><td>");
					out.println("Name: " + result.getString("name") + "<br>");
					out.println("Email: " + result.getString("email") + "<br>");
					out.println("User Type: " + result.getString("usertype") + "<br>");
					out.println("</td></tr>");
				}
			}
			out.println("</table>");
	        out.println("</div>");
	        
	        out.println("</body>");
	        
	        out.println("</html>");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
