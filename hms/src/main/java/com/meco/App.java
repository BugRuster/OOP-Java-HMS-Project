package com.meco;

import java.sql.*;

public class App {
    
    public static void main(String arg[]) {
        Connection connection = null;
        String username = "ashish";
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hmsdb",
                    "root", "ashish123");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from userdata;");

            String title;
            while (resultSet.next()) {
                title = resultSet.getString("name").trim();
                if (username.equals(title)) {
                    System.out.println(username + " " + title);
                } else {
                    System.out.println(username + " " + title + "not equal");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
