/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProxyLoader;
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

    public void getProxiesFromFile(String filePath) {
        ProxyLoader pl = new ProxyLoader();
        itemController.setProxiesForItemReader(pl.extractProxiesFromAPI(filePath));
    }

    public OfferController getOfferController() {
        return this.offerController;
    }

    public ItemController getItemController() {
        return this.itemController;
    }

    public MainFrame getMainFrame() {
        return this.mainFrame;
    }

    public void exit() {
        System.exit(0);
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
