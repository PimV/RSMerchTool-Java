/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ORM;

import controller.DatabaseController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

/**
 *
 * @author PimGame
 */
public class DbRow<T> {

    private HashMap<String, String> data;
    protected DbTable<T> table;
    private boolean isChanged;
    private int id;

    public DbRow() {
        data = new HashMap<>();
        id = -1;
    }

    public void setTable(DbTable table) {
        this.table = table;
    }

    public void set(String key, String value) {
        this.data.put(key, value);
        isChanged = true;
    }

    public String get(String key) {
        if (this.data.containsKey(key)) {
            return this.data.get(key);
        }
        return null;
    }

    public void save() {
        if (id == -1) {
            //Create new row
            String query = "INSERT INTO " + DbTable.DATABASE_NAME + "."
                    + table.getName() + " ";

            // Loop through columns
            query += "(";

            for (String columnName : this.table.getColumns()) {
                query += columnName + ", ";
            }
            query = query.substring(0, query.length() - 2);
            query += ")";

            // Loop through values
            query += " VALUES ";
            query += "(";
            for (String columnName : this.table.getColumns()) {
                query += "?, ";
            }
            query = query.substring(0, query.length() - 2);
            query += ")";

            try {
                DatabaseController.openConnection();
                PreparedStatement stmt = DatabaseController.
                        getConnection().
                        prepareStatement(query);

                int i = 1;
                for (String columnName : this.table.getColumns()) {
                    if (get(columnName, "").equals("null")) {
                        stmt.setNull(i, Types.NULL);
                    } else {
                        stmt.setString(i, get(columnName, ""));
                    }
                    i++;
                }
                stmt.execute();
                stmt.closeOnCompletion();

                ResultSet keys = stmt.executeQuery("SELECT LAST_INSERT_ID()");
                if (keys.next()) {
                    this.setID(keys.getInt(1));
                }
                keys.close();

                stmt.closeOnCompletion();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (isChanged) {
            String query = "UPDATE " + DbTable.DATABASE_NAME + "."
                    + this.table.getName() + " SET ";
            for (String columnName : this.table.getColumns()) {
                query += columnName + "=?, ";
            }
            query = query.substring(0, query.length() - 2);

            query += " WHERE " + this.table.getIdField() + "=? LIMIT 1";

            try {
                DatabaseController.openConnection();
                PreparedStatement stmt = DatabaseController.
                        getConnection().
                        prepareStatement(query);

                int i = 1;
                for (String columnName : this.table.getColumns()) {
                    if (get(columnName, "").equals("null")) {
                        stmt.setNull(i, Types.NULL);
                    } else {
                        stmt.setString(i, get(columnName, ""));
                    }
                    i++;
                }
                stmt.setString(i, get(this.table.getIdField(), ""));

                stmt.execute();
                stmt.closeOnCompletion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertNewWithID() {
        //Create new row
        String query = "INSERT INTO " + DbTable.DATABASE_NAME + "."
                + table.getName() + " ";

        // Loop through columns
        query += "(";
        query += this.table.getIdField() + ", ";
        for (String columnName : this.table.getColumns()) {
            query += columnName + ", ";
        }
        query = query.substring(0, query.length() - 2);
        query += ")";

        // Loop through values
        query += " VALUES ";
        query += "(";
        query += this.getID() + ", ";
        for (String columnName : this.table.getColumns()) {
            query += "?, ";
        }
        query = query.substring(0, query.length() - 2);
        query += ")";

        try {
            DatabaseController.openConnection();
            PreparedStatement stmt = DatabaseController.
                    getConnection().
                    prepareStatement(query);

            int i = 1;
            for (String columnName : this.table.getColumns()) {
                if (get(columnName, "").equals("null")) {
                    stmt.setNull(i, Types.NULL);
                } else {
                    stmt.setString(i, get(columnName, ""));
                }
                i++;
            }
            stmt.execute();
            stmt.closeOnCompletion();

            ResultSet keys = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (keys.next()) {
                this.setID(keys.getInt(1));
            }
            keys.close();

            stmt.closeOnCompletion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String get(String key, String defaultValue) {
        String value = get(key);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public void setID(int id) {
        set(this.table.getIdField(), id + "");
        this.id = id;
    }

    public int getID() {
        return Integer.valueOf(get(this.table.getIdField()));
    }

}
