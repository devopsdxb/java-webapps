package xyz.yogesh.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.yogesh.domain.User;
import xyz.yogesh.service.UserService;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String redirect;

    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session=request.getSession();  
        session.invalidate();
		
		UserService service = new UserService();
		User user=null;
		
        String email=request.getParameter("email");  
        String password=request.getParameter("password");
        
        System.out.println(email + password);
		
        if(email!=null) {
        	user = service.authenticate(email, password);
        	request.setAttribute("loginMessage", "Login failed. Please try again.");
        }
        else {
        	redirect = "/login.jsp";
        }
		
		if(user == null) {
			redirect = "/login.jsp";
		}
		else {
			redirect = "/owner";
			request.getSession().setAttribute("email", user.getEmail());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
