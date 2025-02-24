package servlet;

import java.io.IOException;

import dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private LoginDao logindao = new LoginDao();
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  
		 
		  
		  
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        try {
	            if (logindao.isValidUser(username, password)) {
	                // Redirect to the employee registration page
	                response.sendRedirect("Registration.jsp?message=Successfully Signed in."+password);
	            } else {
	                // Invalid credentials, show error message
	                response.getWriter().println("Invalid username or password.");
	            }
	        } catch (ClassNotFoundException e) {
	            // Handle the exception where the database class isn't found
	            response.getWriter().println("Error: Database class not found. Please check the driver.");
	            e.printStackTrace();  // Log the exception for debugging purposes
	        }
	    }
	}