/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
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

    public static void executeQuery(String query, ArrayList<String> params) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            int i = 1;
            for (String param : params) {
                if (param.equals("") || param.isEmpty()) {
                    stmt.setNull(i, Types.NULL);
                } else {
                    stmt.setString(i, param);
                }
                i++;
            }

            stmt.execute();
            stmt.closeOnCompletion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeGetQuery(String query, ArrayList<String> params) {
        try {
            if (connectionOpen == false) {
                openConnection();
            }
            PreparedStatement stmt = getConnection().prepareStatement(query);
            int i = 1;
            for (String param : params) {
                if (param.equals("") || param.isEmpty()) {
                    stmt.setNull(i, Types.NULL);
                } else {
                    stmt.setString(i, param);
                }
                i++;
            }

            ResultSet result = stmt.executeQuery();
            stmt.closeOnCompletion();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
