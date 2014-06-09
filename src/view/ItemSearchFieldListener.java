/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.jdesktop.swingx.JXList;

/**
 *
 * @author PimGame
 */
public class ItemSearchFieldListener implements DocumentListener {

    private JXList list;
    private ItemRowFilter irf;
    private ItemOverviewPanel itemOverviewPanel;

    public ItemSearchFieldListener(ItemOverviewPanel itemOverviewPanel) {
        this.list = list;
        this.itemOverviewPanel = itemOverviewPanel;
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        updateFilter(de.getDocument());
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        updateFilter(de.getDocument());
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected void updateFilter(Document doc) {
        String text;
        try {
            text = doc.getText(0, doc.getLength());
            itemOverviewPanel.replaceSearchFilter(text.length() > 0 ? new ItemRowFilter(text) : null);
            //   list.setRowFilter(text.length() > 0 ? irf = new ItemRowFilter(text) : null);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

    }

    public ItemRowFilter getFilter() {
        return irf;
    }

}
