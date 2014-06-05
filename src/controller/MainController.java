/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.MainFrame;

/**
 *
 * @author PimGame
 */
public class MainController {

    private MainFrame mainFrame;
    private final ItemController itemController;
    private final OfferController offerController;

    public MainController() {
        this.itemController = new ItemController();
        this.itemController.setMainController(this);
        
        this.offerController = new OfferController();
        this.offerController.setMainController(this);
    }

    public OfferController getOfferController() {
        return this.offerController;
    }
    
    public ItemController getItemController() {
        return this.itemController;
    }
    
    public void exit() {
        System.exit(0);
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
