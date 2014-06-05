/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author PimGame
 */
public class ItemController {

    private MainController mainController;

    public ItemController() {

    }
    
    public void reloadItem(int itemId) {
        
    }

    public void reloadAllItems() {
        try {
            throw new Exception("reloadAllItems() has not been implemented yet!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
