/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.RowFilter;
import model.ORM.ItemRow;

/**
 *
 * @author PimGame
 */
public class ItemRowFilter extends RowFilter {

    private String compare;

    public ItemRowFilter(String compare) {
        this.compare = compare;
    }

    @Override
    public boolean include(Entry entry) {
        ItemRow item = (ItemRow) entry.getValue(0);
        return item.getName().contains(compare);
    }

}
