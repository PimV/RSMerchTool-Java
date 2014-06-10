/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ORM;

/**
 *
 * @author PimGame
 */
public class ItemRowset extends DbRowset<ItemRow> {

    public synchronized ItemRow getItemById(int id) {
        ItemRow item = null;
        for (ItemRow ir : this) {
            if (ir.getID() == id) {
                item = ir;
                break;
            }
        }

        if (item != null) {
            System.out.println("Accurate Price in get: " + item.getAccuratePriceString());
        } else {
            System.err.println("Item not found!");
        }

        return item;
    }

}
