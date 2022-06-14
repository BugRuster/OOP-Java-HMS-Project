package com.meco.DB;
import java.sql.*;

import javax.swing.JOptionPane;


public class DB {
    public static Connection getConnection() { 
        Connection conn = null;
        try {
            // below two lines are used for connectivity
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hmsdb",
                    "root", "ashish123");
        } catch (Exception e) {System.out.println(e);}
        return conn;
    }

    public static boolean addSignupData(String name, String email, String password, String confirm_password, int age, String login_as) {
        PreparedStatement stmt;

        String query = "INSERT INTO userdata (name, email, password, confirm_password, age, login_as) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            stmt = getConnection().prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, confirm_password);
            stmt.setInt(5, age);
            stmt.setString(6, login_as);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your ID is created", "Success", 2);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
