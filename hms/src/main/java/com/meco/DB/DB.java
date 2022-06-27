package com.meco.DB;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
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
        String data[][] = new String[n][5];
        Statement stmt;
        ResultSet rs;
        String query = "SELECT * FROM roomsData";

        try {
            stmt = DB.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("name");
                String phoneNo = rs.getString("phone_no");
                String roomNo = rs.getString("room_no");
                String checkInDate = rs.getString("check_in");
                String checkOutDate = rs.getString("check_out");
                data[i][0] = name;
                data[i][1] = phoneNo;
                data[i][2] = roomNo;
                data[i][3] = checkInDate;
                data[i][4] = checkOutDate;
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static String[][] getStaffData(int n) {
        String data[][] = new String[n][4];
        Statement stmt;
        ResultSet rs;
        String query = "SELECT * FROM staffDetails";
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("id");
                data[i][1] = rs.getString("name");
                data[i][2] = rs.getString("phone_no");
                data[i][3] = rs.getString("current_status");
                i++;
            }
        } catch (SQLException e) {System.out.println(e.getMessage());}
        return data;
    }

    public static Map<String, String> getAllData(int roomNumber ) {
        Map<String, String> data = new HashMap<String, String>();
        Statement stmt;
        ResultSet rs;
        String query = "SELECT * FROM roomsData where room_no = '" + roomNumber + "';";

        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                data.put("name", rs.getString("name"));
                data.put("email", rs.getString("email"));
                data.put("age", String.valueOf(rs.getInt("age")));
                data.put("phone_no", rs.getString("phone_no"));
                data.put("room_no", rs.getString("room_no"));
                data.put("ac_nonAcRoom", rs.getString("ac_nonacRoom"));
                data.put("single_doubleBed", rs.getString("single_doubleBed"));
                data.put("meal_noMeal", rs.getString("meal_noMeal"));
                data.put("check_in", rs.getString("check_in"));
                data.put("check_out", rs.getString("check_out"));
            }
        } catch (Exception e) {System.out.println(e.getMessage());}
        return data;
    }

    public static int getSizeOfTable(String tableName) {
        Statement stmt;
        ResultSet rs;
        String query = "SELECT * FROM " + tableName;
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

        String query = "INSERT INTO roomsData (name, email, age, phone_no, room_no, ac_nonacRoom, single_doubleBed, meal_noMeal, check_in, check_out) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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

    public static void addRoomStatus() {
        if (Tables.roomStatusTABLE()) {
            PreparedStatement stmt;
            Map<String, Integer> map = adminUtils.getBtnStates();
            Set<String> keys = map.keySet();

            for (String i : keys) {
                int roomNum = Integer.parseInt(i.substring(3));
                int roomStatus = map.get(i);
                String query = "INSERT INTO roomStatus (roomNumber, statusCode) VALUES (?, ?)";
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

    public static String getRoomStatus(int roomNo) {
        String value = null;
        Statement stmt = null;
        String query = "SELECT statusCode FROM roomStatus WHERE roomNumber = " + roomNo + ";";
        try {
            stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                value = rs.getString("statusCode");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    public static boolean updateRoomStatus(int roomNo, int roomStatus) {
        PreparedStatement stmt;
        String query = "UPDATE roomStatus SET statusCode = ? WHERE roomNumber = ?;";
        try {
            stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, roomStatus);
            stmt.setInt(2, roomNo);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static boolean deleteUser(int value) {
        PreparedStatement stmt;
        String query = "DELETE FROM roomsData WHERE room_no = ?";
        try {
            stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, value);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static String getCheckOutDateFromDB(String condition) {
        Statement stmt;
        String value = null;
        String query = "SELECT check_out FROM roomsData WHERE room_no = '" + condition + "';";
        try {
            stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                value = rs.getString("check_out");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } return value;
    }

    public static String getCheckInDateFromDB(String condition) {
        Statement stmt;
        String value = null;
        String query = "SELECT check_in FROM roomsData WHERE room_no = '" + condition + "';";
        try {
            stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                value = rs.getString("check_in");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } return value;
    }

    public static void main(String[] args) throws SQLException {
        boolean x = deleteUser(404);
        System.out.println(x);
        
    }
}
