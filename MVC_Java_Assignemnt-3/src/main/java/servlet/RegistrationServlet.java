package servlet;

import java.io.IOException;

import dao.RegistrationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	   private RegistrationDao employeeDao  = new RegistrationDao();

	  

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Get the data from the form
	        String company = request.getParameter("company");
	        String payroll = request.getParameter("payroll");
	        String fullname = request.getParameter("fullname");
	        String jobtitle = request.getParameter("jobtitle");
	        String room = request.getParameter("room");
	        String building = request.getParameter("building");
	        String location = request.getParameter("location");
	        String sector = request.getParameter("sector");
	        String requestertel = request.getParameter("requestertel");

	        // Call the method to register the employee
	        try {
	            boolean isRegistered = employeeDao.registerEmployee(company, payroll, fullname, jobtitle , room, building, location, sector, requestertel);

	            if (isRegistered) {
	                response.getWriter().println("Employee registration successful!");
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

