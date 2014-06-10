/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import javax.swing.JDialog;
import model.ORM.ItemRow;
import model.ORM.ItemTable;
import model.ORM.OfferRow;
import model.ORM.OfferTable;
import view.CreateOfferPanel;

/**
 *
 * @author PimGame
 */
public class OfferController {

    private MainController mainController;

    public OfferController() {

    }

    public void createNewOffer(ItemRow item, String buyPrice, String sellPrice) {
        OfferRow or = OfferTable.getInstance().createRow();
        or.setID(item.getID());
        or.setItemBuyPrice(buyPrice);
        or.setItemSellPrice(sellPrice);
        or.setOfferCompleted("false");
        or.save();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void showNewOfferPopup(ItemRow selectedItem) {
        JDialog dialog = new JDialog();
        CreateOfferPanel cop = new CreateOfferPanel();
        cop.setMainController(this.mainController);
        cop.setVisible(true);
        cop.fillComboBox();
        // cop.setInitialItem(ItemTable.getInstance().fetchAll().getItemById(selectedItem.getID()));
        cop.setInitialItem(selectedItem);
        dialog.setContentPane(cop);
        dialog.setSize(new Dimension(510, 465));
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setVisible(true);

//        CreateOfferFrame cof = new CreateOfferFrame();
//        System.out.println(selectedItem);
//        cof.setMainController(this.mainController);
//        cof.setVisible(true);
//        cof.fillComboBox();
//        cof.setInitialItem(selectedItem);
    }

}
