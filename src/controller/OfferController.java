/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ORM.ItemRow;
import model.ORM.OfferRow;
import model.ORM.OfferTable;
import view.CreateOfferFrame;

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
        CreateOfferFrame cof = new CreateOfferFrame();
        System.out.println(selectedItem);
        cof.setMainController(this.mainController);
        cof.fillComboBox();
        cof.setInitialItem(selectedItem);
        cof.setVisible(true);
    }

}
