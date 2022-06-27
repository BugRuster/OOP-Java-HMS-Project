package com.meco.DB;

import java.sql.*;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;



/**
 * Tables
 */
public class Tables {
    public static boolean roomStatusTABLE() {
        PreparedStatement stmt;
        String query = "CREATE TABLE IF NOT EXISTS roomStatus (" +
            "roomNumber INT PRIMARY KEY, " +
            "statusCode INT NOT NULL);";
        try {
            stmt = DB.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("roomStatus table created successfully");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean roomsDataTABLE() {
        PreparedStatement stmt;
        String query = "CREATE TABLE IF NOT EXISTS roomsData (" +
                        "name VARCHAR(255), " +
                        "email VARCHAR(255), " +
                        "age INT, " + 
                        "phone_no VARCHAR(255), " +
                        "room_no INT, " +
                        "ac_nonacRoom VARCHAR(255), " +
                        "single_doubleBed VARCHAR(255), " +
                        "meal_noMeal VARCHAR(255), " +
                        "check_in VARCHAR(255), " +
                        "check_out VARCHAR(255));";
        try {
            stmt = DB.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("roomsData table created successfully");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } return false;
    }

    public static boolean userDataTABLE() {
        PreparedStatement stmt;
        String query = "CREATE TABLE IF NOT EXISTS userData (" +
                        "name VARCHAR(255), " +
                        "email VARCHAR(255) PRIMARY KEY, " +
                        "password VARCHAR(255), " +
                        "confirm_password VARCHAR(255), " +
                        "age INT, " +
                        "login_as VARCHAR(255));";
        try {
            stmt = DB.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("userData table created successfully");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean staffDetailsTABLE() {
        PreparedStatement stmt;
        String query = "CREATE TABLE IF NOT EXISTS staffDetails (" +
                        "id INTEGER PRIMARY KEY, " +
                        "name VARCHAR(255) NOT NULL, " +
                        "phone_no VARCHAR(255) NOT NULL, " +
                        "current_status VARCHAR(255));";
        try {
            stmt = DB.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("staffDetails table is created successfully");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean complainsTABLE() {
        PreparedStatement stmt;
        String query = "CREATE TABLE IF NOT EXISTS adminComplains(" +
                        "room_no INT PRIMARY KEY, " +
                        "complain VARCHAR(255) NOT NULL);";
        try {
            stmt = DB.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("adminComplains table created successfully");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        
    }
}