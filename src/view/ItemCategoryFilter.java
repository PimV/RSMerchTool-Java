/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.RowFilter;
import model.Category;
import model.ORM.ItemRow;

/**
 *
 * @author PimGame
 */
public class ItemCategoryFilter extends RowFilter {

    private Category category;
    private boolean show;

    public ItemCategoryFilter(CategoryCheckBoxMenuItem menuItem) {
        this.category = menuItem.getCategory();
        this.show = menuItem.isSelected();
    }

    @Override
    public boolean include(RowFilter.Entry entry) {
        ItemRow item = (ItemRow) entry.getValue(0);
        if (show && item.getCategory() == this.category) {
            return true;
        } else if (!show && item.getCategory() == this.category) {
            return false;
        } else if (!show && item.getCategory() != this.category) {
            return false;
        } else if (show && item.getCategory() != this.category) {
            return false;
        }
        return false;

        // return item.isMembers();
    }

    public Category getCategory() {
        return this.category;
    }

}
