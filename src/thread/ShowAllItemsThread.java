/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ItemController;
import model.ORM.ItemRow;
import model.ORM.ItemRowset;
import model.ORM.ItemTable;

/**
 *
 * @author PimGame
 */
public class ShowAllItemsThread implements Runnable {

    private ItemTable table;
    private final ItemController itemController;

    public ShowAllItemsThread(ItemTable table, ItemController itemController) {
        this.table = table;
        this.itemController = itemController;
    }

    @Override
    public void run() {
        try {
            ItemRowset result = this.table.fetchAll();
            for (ItemRow itemRow : result) {

                itemController.addItemToList(itemRow);
            }

        } catch (Exception e) {

        }
    }

}
