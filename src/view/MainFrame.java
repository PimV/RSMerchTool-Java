/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Category;
import model.ORM.ItemRow;

/**
 *
 * @author PimGame
 */
public class MainFrame extends javax.swing.JFrame {

    private MainController controller;
    private ItemRow selectedItem;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        UIManager.put("CheckBoxMenuItemUI",
                "view.StayOpenCheckBoxMenuItemUI");
        initComponents();
        this.addCategoryMenuItems();
        this.setLocationRelativeTo(null);
        //this.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanel = new javax.swing.JTabbedPane();
        itemOverviewPanel = new view.ItemOverviewPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadProxyMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        itemMenu = new javax.swing.JMenu();
        showAllItemsMenuItem = new javax.swing.JMenuItem();
        reloadAllItemsMenuItem = new javax.swing.JMenuItem();
        itemFilterMenu = new javax.swing.JMenu();
        toggleMemberItems = new javax.swing.JCheckBoxMenuItem();
        categoryMenu1 = new javax.swing.JMenu();
        categoryMenu2 = new javax.swing.JMenu();
        offerMenu = new javax.swing.JMenu();
        showAllOffersMenuItem = new javax.swing.JMenuItem();
        newOfferMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPanel.addTab("Item Overview", itemOverviewPanel);

        fileMenu.setText("File");

        loadProxyMenuItem.setText("Load proxies...");
        loadProxyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadProxyMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadProxyMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        itemMenu.setText("Items");

        showAllItemsMenuItem.setText("Show all items");
        showAllItemsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllItemsMenuItemActionPerformed(evt);
            }
        });
        itemMenu.add(showAllItemsMenuItem);

        reloadAllItemsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        reloadAllItemsMenuItem.setText("Reload all items...");
        reloadAllItemsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadAllItemsMenuItemActionPerformed(evt);
            }
        });
        itemMenu.add(reloadAllItemsMenuItem);

        itemFilterMenu.setText(" Filters");

        toggleMemberItems.setText("Hide member items");
        toggleMemberItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleMemberItemsActionPerformed(evt);
            }
        });
        itemFilterMenu.add(toggleMemberItems);

        categoryMenu1.setText("Categories (1 - 19)");
        itemFilterMenu.add(categoryMenu1);

        categoryMenu2.setText("Categories (20 - 37)");
        itemFilterMenu.add(categoryMenu2);

        itemMenu.add(itemFilterMenu);

        mainMenuBar.add(itemMenu);

        offerMenu.setText("Offers");

        showAllOffersMenuItem.setText("Show all offers");
        showAllOffersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllOffersMenuItemActionPerformed(evt);
            }
        });
        offerMenu.add(showAllOffersMenuItem);

        newOfferMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newOfferMenuItem.setText("Create new offer...");
        newOfferMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOfferMenuItemActionPerformed(evt);
            }
        });
        offerMenu.add(newOfferMenuItem);

        mainMenuBar.add(offerMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.controller.exit();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void reloadAllItemsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadAllItemsMenuItemActionPerformed
        Object[] options = {
            "Yes, reload all!",
            "No, thanks"};
        int n = JOptionPane.showOptionDialog(this,
                "Are you sure you want to reload ALL items? This can take"
                + "up to five hours!",
                "Caution! Are you sure?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                null);
        if (n == JOptionPane.OK_OPTION) {
            this.controller.getItemController().reloadAllItems();
        }

    }//GEN-LAST:event_reloadAllItemsMenuItemActionPerformed

    private void newOfferMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOfferMenuItemActionPerformed

        this.controller.getOfferController().showNewOfferPopup(itemOverviewPanel.getSelectedItem());
        disableFrame();

    }//GEN-LAST:event_newOfferMenuItemActionPerformed

    private void showAllItemsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllItemsMenuItemActionPerformed
        itemOverviewPanel.clearList();
        this.controller.getItemController().showAllItems();
    }//GEN-LAST:event_showAllItemsMenuItemActionPerformed

    private void toggleMemberItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleMemberItemsActionPerformed
        itemOverviewPanel.toggleMembers(toggleMemberItems.isSelected());
    }//GEN-LAST:event_toggleMemberItemsActionPerformed

    private void loadProxyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadProxyMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Proxy Text File", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.controller.getProxiesFromFile(chooser.getSelectedFile().toPath().toString());
        }
    }//GEN-LAST:event_loadProxyMenuItemActionPerformed

    private void showAllOffersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllOffersMenuItemActionPerformed
        //this.controller.getOfferController().goToOffers();
    }//GEN-LAST:event_showAllOffersMenuItemActionPerformed

    private void toggleCategoryActionsPerformed(java.awt.event.ActionEvent evt) {
        itemOverviewPanel.filterCategory((CategoryCheckBoxMenuItem) evt.getSource());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public void setControllers(MainController controller) {
        this.controller = controller;
        itemOverviewPanel.setMainController(controller);
    }

    public void addCategoryMenuItems() {
        for (Category c : Category.values()) {
            CategoryCheckBoxMenuItem categoryMenuItem;
            if (c.getCategoryNumber() < 20) {
                categoryMenuItem = new CategoryCheckBoxMenuItem(c);
                categoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        toggleCategoryActionsPerformed(evt);
                    }
                });
                categoryMenu1.add(categoryMenuItem);
            } else {
                categoryMenuItem = new CategoryCheckBoxMenuItem(c);
                categoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        toggleCategoryActionsPerformed(evt);
                    }
                });
                categoryMenu2.add(categoryMenuItem);
            }
        }
    }

    public void disableFrame() {
        this.setEnabled(false);
    }

    public void enableFrame() {
        this.setEnabled(true);
    }

    public ItemOverviewPanel getItemOverviewPanel() {
        return this.itemOverviewPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu categoryMenu1;
    private javax.swing.JMenu categoryMenu2;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu itemFilterMenu;
    private javax.swing.JMenu itemMenu;
    private view.ItemOverviewPanel itemOverviewPanel;
    private javax.swing.JMenuItem loadProxyMenuItem;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem newOfferMenuItem;
    private javax.swing.JMenu offerMenu;
    private javax.swing.JMenuItem reloadAllItemsMenuItem;
    private javax.swing.JMenuItem showAllItemsMenuItem;
    private javax.swing.JMenuItem showAllOffersMenuItem;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JCheckBoxMenuItem toggleMemberItems;
    // End of variables declaration//GEN-END:variables

}
