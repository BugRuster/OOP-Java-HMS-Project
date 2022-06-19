package com.meco.DB;

import java.sql.*;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.xml.namespace.QName;

import com.meco.MainPages.Admin.adminUtils;

public class DB {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // below two lines are used for connectivity
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hmsdb",
                    "root", "ashish123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static boolean addSignupData(String name, String email, String password, String confirm_password, int age,
            String login_as) {
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

    public static String[][] getUserData(int n) {
        String data[][] = new String[n][3];
        Statement stmt;
        ResultSet rs;
        String query = "SELECT * FROM userdata";

        try {
            stmt = DB.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String age = rs.getString("age");

                data[i][0] = name;
                data[i][1] = email;
                data[i][2] = age;
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static int getSizeOfUserData() {
        Statement stmt;
        ResultSet rs;
        String query = "SELECT * FROM userdata";
        int size = 0;

        try {
            stmt = DB.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                size++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return size;

    }

    public static boolean addRoomData(String name, String email, int age, String phoneNo, String address, int roomNo,
            String ac_nonAcRoom, String single_doubleBedRoom, String mealCombo, String checkInDate,
            String checkOutDate) {
        PreparedStatement stmt;

        String query = "INSERT INTO roomsData (name, email, age, phone_no, room_no, ac_nonacRoom, singel_doubleBed, meal_noMeal, check_in, check_out) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            stmt = getConnection().prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.setString(4, phoneNo);
            stmt.setInt(5, roomNo);
            stmt.setString(6, ac_nonAcRoom);
            stmt.setString(7, single_doubleBedRoom);
            stmt.setString(8, mealCombo);
            stmt.setString(9, checkInDate);
            stmt.setString(10, checkOutDate);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer room is successfully booked!", "Success", 2);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static boolean createRoomStatus() {
        PreparedStatement stmt;
        String query = "CREATE TABLE IF NOT EXISTS roomStatus (roomNumber INT, roomStatus INT);";
        try {
            stmt = DB.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your Table is created", "Success", 2);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static void addRoomStatus() {
        if (createRoomStatus()) {
            PreparedStatement stmt;
            Map<String, Integer> map = adminUtils.getBtnStates();
            Set<String> keys = map.keySet();

            for (String i : keys) {
                int roomNum = Integer.parseInt(i.substring(3));
                int roomStatus = map.get(i);
                String query = "INSERT INTO roomStatus (roomNumber, roomStatus) VALUES (?, ?)";
                try {
                    stmt = getConnection().prepareStatement(query);
                    stmt.setInt(1, roomNum);
                    stmt.setInt(2, roomStatus);
                    stmt.executeUpdate();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }

    public static String getRoomStatus(int roomNo) throws SQLException {
        String value = null;
        Statement stmt = null;
        String query = "SELECT roomStatus FROM roomStatus WHERE roomNumber = " + roomNo + ";";
        try {
            stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                value = rs.getString("roomStatus");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return value;
    }

    public static boolean updateRoomStatus(int roomNo, int roomStatus) {
        PreparedStatement stmt;
        String query = "UPDATE roomStatus SET roomStatus = ? WHERE roomNo = ?";
        try {
            stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, roomStatus);
            stmt.setString(2, "btn".concat(String.valueOf(roomNo)));
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
    }
}
