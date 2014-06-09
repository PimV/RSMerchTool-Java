/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

/**
 *
 * @author PimGame
 */
public class ItemOverviewPanel extends javax.swing.JPanel {

    /**
     * Creates new form ItemOverviewPanel
     */
    public ItemOverviewPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listPanel = new javax.swing.JPanel();
        itemSearchField = new javax.swing.JTextField();
        itemScrollPane = new javax.swing.JScrollPane();
        itemList = new org.jdesktop.swingx.JXList();
        itemNumberLabel = new javax.swing.JLabel();
        itemNumberValue = new javax.swing.JLabel();
        graphicPanel = new javax.swing.JPanel();
        itemPanel = new javax.swing.JPanel();
        itemNameLabel = new javax.swing.JLabel();
        itemNameValue = new javax.swing.JLabel();
        itemDescriptionLabel = new javax.swing.JLabel();
        itemDescriptionValue = new javax.swing.JLabel();
        itemCategoryLabel = new javax.swing.JLabel();
        itemCategoryValue = new javax.swing.JLabel();
        itemMembersValue = new javax.swing.JLabel();
        itemMembersLabel = new javax.swing.JLabel();
        itemLastUpdatedLabel = new javax.swing.JLabel();
        itemLastUpdatedValue = new javax.swing.JLabel();
        itemAccuratePriceValue = new javax.swing.JLabel();
        itemAccuratePriceLabel = new javax.swing.JLabel();
        itemImage = new org.jdesktop.swingx.JXImageView();
        busyPanel = new javax.swing.JPanel();
        busyLabel = new org.jdesktop.swingx.JXBusyLabel();
        refreshItemButton = new org.jdesktop.swingx.JXButton();
        createOfferButton = new org.jdesktop.swingx.JXButton();
        favoriteItemButton = new org.jdesktop.swingx.JXButton();

        itemList.setModel(new DefaultListModel<ItemRow>());
        itemList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                itemListValueChanged(evt);
            }
        });
        itemScrollPane.setViewportView(itemList);

        itemNumberLabel.setText("Number of items in list:");

        itemNumberValue.setText("-");

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemSearchField)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(itemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(listPanelLayout.createSequentialGroup()
                .addComponent(itemNumberLabel)
                .addGap(18, 18, 18)
                .addComponent(itemNumberValue)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNumberLabel)
                    .addComponent(itemNumberValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        graphicPanel.setBackground(new java.awt.Color(255, 255, 255));
        graphicPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout graphicPanelLayout = new javax.swing.GroupLayout(graphicPanel);
        graphicPanel.setLayout(graphicPanelLayout);
        graphicPanelLayout.setHorizontalGroup(
            graphicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graphicPanelLayout.setVerticalGroup(
            graphicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        itemPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        itemNameLabel.setText("Item:");

        itemDescriptionLabel.setText("Description:");

        itemCategoryLabel.setText("Category:");

        itemMembersLabel.setText("Members:");

        itemLastUpdatedLabel.setText("Last Updated:");

        itemAccuratePriceLabel.setText("Price (gp):");

        itemImage.setBackground(new java.awt.Color(204, 204, 204));
        itemImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        itemImage.setInheritAlpha(false);
        itemImage.setEditable(false);
        itemImage.setEnabled(false);

        javax.swing.GroupLayout itemImageLayout = new javax.swing.GroupLayout(itemImage);
        itemImage.setLayout(itemImageLayout);
        itemImageLayout.setHorizontalGroup(
            itemImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        itemImageLayout.setVerticalGroup(
            itemImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout busyPanelLayout = new javax.swing.GroupLayout(busyPanel);
        busyPanel.setLayout(busyPanelLayout);
        busyPanelLayout.setHorizontalGroup(
            busyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(busyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(busyPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(busyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );
        busyPanelLayout.setVerticalGroup(
            busyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
            .addGroup(busyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(busyPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(busyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );

        refreshItemButton.setText("Refresh item");
        refreshItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshItemButtonActionPerformed(evt);
            }
        });

        createOfferButton.setText("Create offer");
        createOfferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOfferButtonActionPerformed(evt);
            }
        });

        favoriteItemButton.setText("Favorite");
        favoriteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemPanelLayout = new javax.swing.GroupLayout(itemPanel);
        itemPanel.setLayout(itemPanelLayout);
        itemPanelLayout.setHorizontalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(itemPanelLayout.createSequentialGroup()
                                .addComponent(itemDescriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemDescriptionValue))
                            .addGroup(itemPanelLayout.createSequentialGroup()
                                .addComponent(itemNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemNameValue))
                            .addGroup(itemPanelLayout.createSequentialGroup()
                                .addComponent(itemCategoryLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemCategoryValue))
                            .addGroup(itemPanelLayout.createSequentialGroup()
                                .addComponent(itemMembersLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemMembersValue))
                            .addGroup(itemPanelLayout.createSequentialGroup()
                                .addComponent(itemAccuratePriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemAccuratePriceValue)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(busyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addComponent(itemLastUpdatedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemLastUpdatedValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(favoriteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createOfferButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        itemPanelLayout.setVerticalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemNameLabel)
                            .addComponent(itemNameValue))
                        .addGap(7, 7, 7)
                        .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemDescriptionLabel)
                            .addComponent(itemDescriptionValue))
                        .addGap(8, 8, 8)
                        .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemCategoryLabel)
                            .addComponent(itemCategoryValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemMembersLabel)
                            .addComponent(itemMembersValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemAccuratePriceLabel)
                            .addComponent(itemAccuratePriceValue)))
                    .addComponent(itemImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(busyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(itemLastUpdatedLabel)
                        .addComponent(itemLastUpdatedValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createOfferButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(favoriteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(itemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void itemListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_itemListValueChanged
        if (!evt.getValueIsAdjusting()) {
            if (itemList.getSelectedIndex() != -1) {
                ItemRow selectedItemTemp = (ItemRow) itemList.getSelectedValue();
                if (selectedItem == null || selectedItemTemp.getID() != selectedItem.getID()) {
                    selectedItem = selectedItemTemp;
                    int itemId = selectedItem.getID();
                    this.controller.getItemController().reloadItem(itemId);
                }
            }
        }
    }//GEN-LAST:event_itemListValueChanged

    private void refreshItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshItemButtonActionPerformed
        if (selectedItem != null) {
            int itemId = selectedItem.getID();

            this.controller.getItemController().reloadItem(itemId);
            //showSingleItem(selectedItem);
        }
    }//GEN-LAST:event_refreshItemButtonActionPerformed

    private void createOfferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createOfferButtonActionPerformed
        this.controller.getOfferController().createNewOffer();
    }//GEN-LAST:event_createOfferButtonActionPerformed

    private void favoriteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteItemButtonActionPerformed
        System.out.println("Favoriting is not implemented yet.");
    }//GEN-LAST:event_favoriteItemButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXBusyLabel busyLabel;
    private javax.swing.JPanel busyPanel;
    private org.jdesktop.swingx.JXButton createOfferButton;
    private org.jdesktop.swingx.JXButton favoriteItemButton;
    private javax.swing.JPanel graphicPanel;
    private javax.swing.JLabel itemAccuratePriceLabel;
    private javax.swing.JLabel itemAccuratePriceValue;
    private javax.swing.JLabel itemCategoryLabel;
    private javax.swing.JLabel itemCategoryValue;
    private javax.swing.JLabel itemDescriptionLabel;
    private javax.swing.JLabel itemDescriptionValue;
    private org.jdesktop.swingx.JXImageView itemImage;
    private javax.swing.JLabel itemLastUpdatedLabel;
    private javax.swing.JLabel itemLastUpdatedValue;
    private org.jdesktop.swingx.JXList itemList;
    private javax.swing.JLabel itemMembersLabel;
    private javax.swing.JLabel itemMembersValue;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JLabel itemNameValue;
    private javax.swing.JLabel itemNumberLabel;
    private javax.swing.JLabel itemNumberValue;
    private javax.swing.JPanel itemPanel;
    private javax.swing.JScrollPane itemScrollPane;
    private javax.swing.JTextField itemSearchField;
    private javax.swing.JPanel listPanel;
    private org.jdesktop.swingx.JXButton refreshItemButton;
    // End of variables declaration//GEN-END:variables
}
