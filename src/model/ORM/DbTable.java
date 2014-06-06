/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ORM;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PimGame
 */
public abstract class DbTable<T> {

    //Table Name
    private String name;
    public static final String DATABASE_NAME = "";
    private ArrayList<String> columns;
    private String idField;

    public DbTable(String name) {
        this.name = name;
        this.columns = new ArrayList<>();
    }

    protected void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    protected void setIdField(String idField) {
        this.idField = idField;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getColumns() {
        return this.columns;
    }

    public String getIdField() {
        return this.idField;
    }

    public void remove(int id) {
        String query = "DELETE FROM " + DbTable.DATABASE_NAME + "."
                + this.getName() + " WHERE " + this.getIdField() + "=? LIMIT 1";

        try {
            //PreparedStatement remove
            throw new SQLException("HO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract DbRowset fetchAll();

    public abstract DbRow fetch(int id);

}
