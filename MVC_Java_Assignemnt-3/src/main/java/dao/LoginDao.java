package dao;


import java.sql.*;

public class LoginDao {

    public boolean isValidUser(String username, String password) throws ClassNotFoundException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_java", "root", "root");
             PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();  // .next will move the cursor to the first row of resultset. so if there will be user it will return true unless false
            }
        } catch (SQLException e) {
        	
        // do add methods to call -- 3 methods	
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean registerUser(String username, String password) throws ClassNotFoundException {
     
        
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_java", "root", "root");
             PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            // Execute the insert query
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;  // Returns true if user is successfully inserted
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Registration failed
        }
    }



}
