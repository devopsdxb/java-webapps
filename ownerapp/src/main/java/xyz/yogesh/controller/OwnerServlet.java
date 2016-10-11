package xyz.yogesh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.yogesh.domain.Owner;
import xyz.yogesh.service.OwnerService;

@WebServlet("/test")
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OwnerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OwnerService service = new OwnerService();
		List<Owner> ownerList;
		String[] ids = request.getParameterValues("selectID");
		
		List<Owner> allOwners = service.findAll();
		
		if(ids == null) {
			ownerList = allOwners;
		}
		else {
			ownerList = service.find(ids);
		}
		
		request.setAttribute("allOwners", allOwners);
		request.setAttribute("ownerList", ownerList);
		RequestDispatcher rd = request.getRequestDispatcher("/owner.jsp");
		rd.forward(request, response);
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
