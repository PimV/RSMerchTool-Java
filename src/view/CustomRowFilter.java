/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.RowFilter;

/**
 *
 * @author PimGame
 */
public abstract class CustomRowFilter extends RowFilter<Object, Object> {

    public String getType() {
        return "CustomFilter";
    }

    @Override
    public boolean include(Entry entry) {
        return true;
    }

}
