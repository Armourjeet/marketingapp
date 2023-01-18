package com.marketingapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marketingapp.model.DAOService;
import com.marketingapp.model.DAOServiceImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
   
    public DeleteController() {
        super();
         
    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null){
		   session.setMaxInactiveInterval(15);
		
		String email = request.getParameter("email");
		System.out.println(email);
		
	DAOService service = new DAOServiceImpl();
	service.connectDB();
		
    service.deleteRegistration(email);
    
	 ResultSet result = service.getAllRegistrations();
	 request.setAttribute("result", result);
	 
     request.setAttribute("msg","Record has been deleted successfuly!!");
	 
	 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/showlist.jsp");
	   rd.forward(request, response);
		
	}else {
    	RequestDispatcher rd = request.getRequestDispatcher("login_reg.jsp");
    	rd.forward(request, response);	
	}
		}catch(Exception e) {
		e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

}