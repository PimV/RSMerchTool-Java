/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.DatabaseConstants;

/**
 *
 * @author PimGame
 */
public class DatabaseController {

    private static boolean connectionOpen;
    private static Connection con = null;

    public DatabaseController() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found.");
        }
    }

    public static boolean openConnection() {
        try {
            if (con == null) {
                String jdbcString = "jdbc:mysql://";
                jdbcString += DatabaseConstants.HOST + "/"
                        + DatabaseConstants.DATABASE;
                con = DriverManager.getConnection(
                        jdbcString,
                        DatabaseConstants.USERNAME,
                        DatabaseConstants.PASSWORD
                );
                connectionOpen = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connectionOpen = false;
        }
        return connectionOpen;
    }

    public static boolean closeConnection() {
        try {
            con.close();
            connectionOpen = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connectionOpen;
    }
    
    public static Connection getConnection() {
        return con;
    }

}
