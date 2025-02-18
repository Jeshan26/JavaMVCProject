package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDao   {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/mvc_java";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public boolean registerEmployee(String company, String payroll, String fullname, String jobtitle,
                                     String room, String building, String location, String sector, String requestertel) throws ClassNotFoundException {

        String query = "INSERT INTO employees (company, payroll, fullname, jobtitle, room, building, location, sector, requestertel) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?,?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {

            // Setting the parameters in the query
            ps.setString(1, company);
            ps.setString(2, payroll);
            ps.setString(3, fullname);
            ps.setString(4, jobtitle);
           
            ps.setString(5, room);
            ps.setString(6, building);
            ps.setString(7, location);
            ps.setString(8, sector);
            ps.setString(9, requestertel);

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
