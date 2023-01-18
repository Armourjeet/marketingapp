package com.marketingapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marketingapp.model.DAOService;
import com.marketingapp.model.DAOServiceImpl;
 
@WebServlet("/new")
public class CreateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateRegistration() {
        super();
         
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/create_registration.jsp");
		   rd.forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		try {
			
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!= null){
		   
		  String name = request.getParameter("name");
          String city = request.getParameter("city");
          String email = request.getParameter("email");
          String mobile = request.getParameter("mobile");
          
          DAOService service = new DAOServiceImpl();
          service.connectDB();
          
          service.saveRegistration(name, city, email, mobile);
          
          request.setAttribute("msg","Record has been saved successfuly!!");
          
  		  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/create_registration.jsp");
  		   rd.forward(request, response);	
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login_reg.jsp");
	    	rd.forward(request, response);
		}
		
       }catch(Exception e) {
		e.printStackTrace();
		}
	}
}
