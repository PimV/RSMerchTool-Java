/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ORM;

import controller.DatabaseController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PimGame
 */
@SuppressWarnings("unchecked")
public class ItemTable extends DbTable<ItemRow> {

    private ItemRowset list;

    public ItemTable() {
        super("item");
        ArrayList<String> columns = new ArrayList<>();
        setIdField("id");
        columns.add("name");
        columns.add("description");
        columns.add("current_price");
        columns.add("category");
        columns.add("members");
        columns.add("today_trend");
        columns.add("today_price_change");
        columns.add("30day_trend");
        columns.add("30day_change");
        columns.add("90day_trend");
        columns.add("90day_change");
        columns.add("180day_trend");
        columns.add("180day_change");
        columns.add("last_updated");
        setColumns(columns);
    }

    public ItemRowset fetchAll() {
        if (list == null) {
            list = new ItemRowset();
            try {
                String query = "SELECT * FROM " + this.getName();
                ArrayList<String> params = new ArrayList<>();
                ResultSet res = DatabaseController.executeGetQuery(query, params);
                while (res.next()) {
                    ItemRow ir = createRow();

                    for (String columnName : this.getColumns()) {
                        ir.set(columnName, res.getString(columnName));
                        System.out.println(columnName + ": " + res.getString(columnName));
                    }
                    list.add(ir);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public ItemRow fetch(int id) {
        ItemRow ir = null;

        try {
            String query = "SELECT * FROM " + this.getName()
                    + " WHERE " + this.getIdField() + " = " + id;
            ArrayList<String> params = new ArrayList<>();
            ResultSet res = DatabaseController.executeGetQuery(query, params);
            while (res.next()) {
                ir = createRow();

                for (String columnName : this.getColumns()) {
                    ir.set(columnName, res.getString(columnName));
                    System.out.println(columnName + ": " + res.getString(columnName));
                }
                return ir;
            }
        } catch (SQLException e) {
            System.err.println("Error in fetch with item id: " + id);
            System.err.println(e);
        }
        return ir;
    }

    public void addItem(ItemRow item) {
        this.list.add(item);
    }

    public ItemRow createRow() {
        ItemRow ir = new ItemRow();
        ir.setTable(this);
        return ir;
    }

}
