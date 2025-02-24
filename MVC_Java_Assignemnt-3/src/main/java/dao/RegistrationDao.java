package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Registration;

public class RegistrationDao   {

	Registration employeeregistration = new Registration();
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/mvc_java";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public boolean registerEmployee(Registration employeeRegistration) throws ClassNotFoundException {

        String query = "INSERT INTO employees (company, payroll, fullname, jobtitle, room, building, location, sector, requestertel) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?,?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {

            // Setting the parameters in the query
            ps.setString(1, employeeRegistration.getCompany());
            ps.setString(2, employeeRegistration.getHashedPayroll());
            ps.setString(3, employeeRegistration.getFullname());
            ps.setString(4, employeeRegistration.getJobtitle());
           
            ps.setString(5, employeeRegistration.getRoom());
            ps.setString(6, employeeRegistration.getBuilding());
            ps.setString(7, employeeRegistration.getLocation());
            ps.setString(8, employeeRegistration.getSector());
            ps.setString(9, employeeRegistration.getHashedRequestertel());
           
            System.out.println(ps);
            // Execute the query
            
            int rowsInserted = ps.executeUpdate();

            // If the row is inserted successfully, return true
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of failure
        }
    }
}
