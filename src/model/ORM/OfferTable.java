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
public class OfferTable extends DbTable<OfferRow> {

    private OfferRowset list;
    private static OfferTable instance;

    public OfferTable() {
        super("offer");
        ArrayList<String> columns = new ArrayList<>();
        setIdField("id");
        columns.add("user_id");
        columns.add("item_id");
        columns.add("item_buy_price");
        columns.add("item_sell_price");
        columns.add("profit");
        columns.add("offer_completed");
        columns.add("deleted");
        setColumns(columns);
    }

    public static synchronized OfferTable getInstance() {
        if (OfferTable.instance == null) {
            OfferTable.instance = new OfferTable();
        }
        return OfferTable.instance;
    }

    @Override
    public OfferRowset fetchAll() {
        if (list == null) {
            list = new OfferRowset();
            try {
                String query = "SELECT * FROM " + this.getName() + " WHERE deleted = '0'";
                ArrayList<String> params = new ArrayList<>();
                ResultSet res = DatabaseController.executeGetQuery(query, params);
                while (res.next()) {
                    OfferRow or = createRow();

                    for (String columnName : this.getColumns()) {
                        or.set(columnName, res.getString(columnName));
                    }
                    or.setID(Integer.parseInt(res.getString(this.getIdField())));
                    list.add(or);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public OfferRow fetch(int id) {
        OfferRow or = null;

        try {
            String query = "SELECT * FROM " + this.getName()
                    + " WHERE " + this.getIdField() + " = " + id;
            ArrayList<String> params = new ArrayList<>();
            ResultSet res = DatabaseController.executeGetQuery(query, params);
            if (res.next()) {
                or = createRow();
                for (String columnName : this.getColumns()) {
                    or.set(columnName, res.getString(columnName));

                }

            }
        } catch (SQLException e) {
            System.err.println("Error in fetch with item id: " + id);
            System.err.println(e);
        }
        return or;
    }

    public OfferRow createRow() {
        OfferRow offerRow = new OfferRow();
        offerRow.setTable(this);
        return offerRow;
    }

}
