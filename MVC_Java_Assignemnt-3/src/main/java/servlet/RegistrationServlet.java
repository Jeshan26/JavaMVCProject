package servlet;

import java.io.IOException;

import dao.Md5Hashing;
import dao.RegistrationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Registration;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	   private RegistrationDao employeeDao  = new RegistrationDao();
	   private Registration employeeRegistration  = new Registration();

	  

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	    	
	    	Md5Hashing m1 = new Md5Hashing(); // creates an object of the hashing class!. 

	    	
	        // Get the data from the form
	        String company = request.getParameter("company");
	        int payroll = Integer.parseInt(request.getParameter("payroll"));
	        String fullname = request.getParameter("fullname");
	        String jobtitle = request.getParameter("jobtitle");
	        String room = request.getParameter("room");
	        String building = request.getParameter("building");
	        String location = request.getParameter("location");
	        String sector = request.getParameter("sector");
	        int requestertel = Integer.parseInt(request.getParameter("requestertel"));
	        
	        
	        
//          Hashing room
	        String hashedroom = m1.getMd5(room);
//	        Hashing payroll 
	        String hashedpayroll = m1.getMd5(String.valueOf(payroll));
//	        Hashing telephone num . We have to convert int to string because md takes string only
	        String hashedrequestertel = m1.getMd5(String.valueOf(requestertel));
	        
	        
//	       Setting the emploeeregistration object with setters
	        employeeRegistration.setCompany(company);
	        employeeRegistration.settHashedPayroll(hashedpayroll);
	        employeeRegistration.setFullname(fullname);
	        employeeRegistration.setJobtitle(jobtitle);
	        employeeRegistration.setRoom(hashedroom);
	        employeeRegistration.setBuilding(building);
	        employeeRegistration.setLocation(location);
	        employeeRegistration.setSector(sector);
	        employeeRegistration.setHashedRequestertel(hashedrequestertel);
	        

	        
	        
	   
	        
	        
	       
	    

	        // Call the method to register the employee
	        try {
	            boolean isRegistered = employeeDao.registerEmployee(employeeRegistration);
                
	            if (isRegistered) {
//	            	response.getWriter().println("Employee registration successful!");
	                response.sendRedirect("EmployeeRegistrationSuccess.jsp");
	            } else {
	                response.getWriter().println("Failed to register employee. Please try again.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("An error occurred during the registration process.");
	        }
	    }
	}

