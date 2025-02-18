package servlet;


import java.io.IOException;

import dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signupServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
    private LoginDao registerDao = new LoginDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            boolean isRegistered = registerDao.registerUser(username, password);

            if (isRegistered) {
                response.sendRedirect("Login.jsp?message=Signup successful! Please login.");
            } else {
                response.getWriter().println("Username already taken or registration failed. Please try again.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred. Please try again later.");
        }
    }
}
