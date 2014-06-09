/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.MainController;
import model.ProxyGenerator;
import view.MainFrame;

/**
 *
 * @author Pim
 */
public class RSMerchToolJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        MainFrame mainFrame = new MainFrame();
        MainController mainController = new MainController();
        mainFrame.setControllers(mainController);
        mainController.setMainFrame(mainFrame);

        mainController.getItemController().showAllItems();
        //  mainController.getItemController().showAllItems();
        // mainController.getItemController().reloadItem(2);
    }

}
