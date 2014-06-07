/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JCheckBoxMenuItem;
import model.Category;

/**
 *
 * @author PimGame
 */
public class CategoryCheckBoxMenuItem extends JCheckBoxMenuItem {
    
    private Category category;
    
    public CategoryCheckBoxMenuItem(Category category) {
        this.category = category;
        this.setText(this.category.getNiceName());
    }
    
    public Category getCategory() {
        return this.category;
    }
    
}
