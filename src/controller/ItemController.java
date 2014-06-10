/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import model.CustomProxy;
import model.ItemReader;
import model.ORM.ItemRow;
import model.ORM.ItemTable;
import thread.ShowAllItemsThread;

/**
 *
 * @author PimGame
 */
public class ItemController {

    private MainController mainController;
    private ArrayList<Proxy> proxies;
    private ItemTable items;
    private ItemReader itemReader;

    public ItemController() {
        items = ItemTable.getInstance();
        itemReader = new ItemReader(this);

        proxies = new ArrayList<>();
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("217.12.204.22", 3128)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("178.17.170.89", 7808)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("149.255.255.250", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("195.242.197.131", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("86.108.193.205", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("58.137.145.242", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("62.201.214.212", 3128)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("219.68.214.198", 8888)));
    }

    public void addItemToList(final ItemRow item) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                mainController.getMainFrame().getItemOverviewPanel().addItemToList(item);
            }
        };
        r.run();

    }

    public ItemRow getItem(int itemId) {
        // ItemRow fetchedItem = ItemTable.getInstance().fetch(itemId);
        ItemRow fetchedItem = ItemTable.getInstance().fetchAll().get(itemId);
        //  addItemToList(fetchedItem);
        return fetchedItem;
    }

    public void showAllItems() {
        ShowAllItemsThread sait = new ShowAllItemsThread(ItemTable.getInstance(), this);
        sait.run();
    }

    public void setProxiesForItemReader(ArrayList<CustomProxy> proxies) {
        itemReader.setProxies(proxies);
    }

    public void showBusy(boolean busy) {
        this.mainController.getMainFrame().getItemOverviewPanel().setBusy(busy);
    }

    public void reloadItem(int itemId) {
        itemReader.retrieveItem(itemId);
    }

    public void updateInTable(ItemRow itemRow) {
        ItemTable.getInstance().replace(itemRow.getItemId(), itemRow);
        updateInView(itemRow);
    }

    public void updateInView(ItemRow itemRow) {
        this.mainController.getMainFrame().getItemOverviewPanel().updateItemInList(itemRow);
    }

    public void reloadAllItems() {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                itemReader.retrieveAllItems();
            }

        };
        r.run();

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
