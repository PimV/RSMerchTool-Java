/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import javax.swing.table.DefaultTableModel;
import model.ORM.ItemRow;

/**
 *
 * @author PimGame
 */
public class OfferHistoryPanel extends javax.swing.JPanel {

    private MainController mainController;

    /**
     * Creates new form OfferHistoryPanel
     */
    public OfferHistoryPanel() {
        initComponents();
        initializeTable();

        //addMultipleRowsToTable(new Object[]{new Object[]{"hoi"}, new Object[]{"nee"}});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        historyPane = new javax.swing.JScrollPane();
        historyTable = new org.jdesktop.swingx.JXTable();

        historyPane.setViewportView(historyTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historyPane, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addComponent(historyPane, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public Object[] parseItem(ItemRow itemRow) {
        Object[] parsedItem = new Object[historyTable.getModel().getColumnCount()];
        parsedItem[0] = itemRow.getItemId();
        parsedItem[1] = itemRow.getName();
        parsedItem[1] = itemRow.getName();
        parsedItem[1] = itemRow.getName();

        return parsedItem;
    }

    public void addRowToTable(Object[] values) {
        DefaultTableModel dtm = (DefaultTableModel) historyTable.getModel();
        dtm.addRow(values);
        historyTable.setModel(dtm);
    }

    public void addMultipleRowsToTable(Object[] values) {
        DefaultTableModel dtm = (DefaultTableModel) historyTable.getModel();
        for (int i = 0; i < values.length; i++) {
            dtm.addRow((Object[]) values[i]);
        }
        historyTable.setModel(dtm);
    }

    private void initializeTable() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Item");
        dtm.addColumn("Buy Price");
        dtm.addColumn("Sell Price");
        dtm.addColumn("Profit");
        historyTable.setModel(dtm);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane historyPane;
    private org.jdesktop.swingx.JXTable historyTable;
    // End of variables declaration//GEN-END:variables
}
