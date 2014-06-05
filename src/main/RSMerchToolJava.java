/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.MainController;
import model.ORM.ItemTable;
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

        mainController.setMainFrame(mainFrame);
        mainFrame.setController(mainController);

        mainController.getItemController().getAllItems();

//        mainController.getItemControllerasdfasdfasdfasdfasdfasdf().getItem(2);
//        mainController.getItemController().getItem(6);
//        mainController.getItemController().getItem(42);
//        mainController.getItemController().getItem(43);
       // mainController.getItemController().reloadItem(2);
        // mainController.getItemController().reloadItem(6);
        // mainController.getItemController().reloadItem(42);
        // mainController.getItemController().reloadItem(43);
        //System.out.println(" ------------ Completed loading ------------ ");
        // System.exit(0);
        //Testing ItemTable
        //ItemTable it = new ItemTable();
        //it.fetchAll();
    }

}
