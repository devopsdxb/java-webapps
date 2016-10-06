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

@WebServlet("/test")
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OwnerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic", "root", "root");
			Statement stmt = conn.createStatement();
			
			String sql = "select * from owners";
			ResultSet result = stmt.executeQuery(sql);
		
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String[] ids = request.getParameterValues("selectID");
			
	        out.println("<!DOCTYPE html>");
	        out.println("<html><head>");
	        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	        out.println("<title>Owners</title>");
	        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
	        out.println("</head>");
	        
	        out.println("<body>");
	        out.println("<h3 align=\"center\">List of Owners</h3>");
	
	        out.println("<div style=\"float: left; width: 15%; padding-left:25px;\">");
	        out.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"/myservlet/owner\">");
	        out.println("<select multiple name=\"selectID\" size = \"15\" class=\"form-control\">");
	        
	        while(result.next()) {
	        	out.println("<option value=\"" + result.getString("id") + "\">" + result.getString("first_name") + " " + result.getString("last_name") + "</option>");
	        }
	        out.println("</select>");
	        out.println("<br><input type=\"submit\" name=\"Submit\" value=\"Submit\" class=\"btn btn-default\"/>");
	        out.println("</form>");
	        out.println("</div>");

	        out.println("<div style=\"float: left; padding-left:75px;\">");
			out.println("<table class=\"table table-bordered table-striped table-hover\">");
			out.println("<tr><th style=\"text-align:center;\">Owners</td></tr>");
			
			if(ids==null) {
				sql = "select * from owners";
				result = stmt.executeQuery(sql);
				
				while(result.next()) {
					printOwnerRow(out, result);
				}
			}
			else {
				for(String id : ids) {
					sql = "select * from owners where id=\"" + id + "\"";
					result = stmt.executeQuery(sql);
					result.next();
					printOwnerRow(out, result);
				}
			}
			out.println("</table>");
	        out.println("</div>");
	        
	        out.println("</body>");
	        
	        out.println("<script type=\"text/javascript\">");
	        out.println("window.onmousedown = function (e) {");
	        out.println("var el = e.target;");
	        out.println("if (el.tagName.toLowerCase() == 'option' && el.parentNode.hasAttribute('multiple')) {");
	        out.println("e.preventDefault();");
	        out.println("if (el.hasAttribute('selected')) el.removeAttribute('selected');");
	        out.println("else el.setAttribute('selected', '');");
	        out.println("var select = el.parentNode.cloneNode(true);");
	        out.println("el.parentNode.parentNode.replaceChild(select, el.parentNode); } }");
	        out.println("");
	        out.println("</script>");
	        
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
	
	private void printOwnerRow(PrintWriter out, ResultSet result) throws SQLException {
		out.println("<tr><td>");
		out.println("ID: " + result.getString("id") + "<br>");
		out.println("Name: " + result.getString("first_name") + " " + result.getString("last_name") + "<br>");
		out.println("Address: " + result.getString("address") + "<br>");
		out.println("City: " + result.getString("city") + "<br>");
		out.println("Telephone: " + result.getString("telephone") + "<br>");
		out.println("</td></tr>");
	}

}
