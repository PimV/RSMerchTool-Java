/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ORM.ItemRow;
import model.ORM.ItemTable;
import thread.ItemInformationThread;

/**
 *
 * @author PimGame
 */
public class ItemController {

    private MainController mainController;
    private ArrayList<Proxy> proxies;
    private ItemTable items;

    public ItemController() {
        items = new ItemTable();

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

    public ItemRow getItem(int itemId) {
        return items.fetch(itemId);
    }

    public void reloadItem(int itemId) {
        Random rnd = new Random();
        int proxyNumber = rnd.nextInt(7);
        Proxy p = proxies.get(proxyNumber);
        ItemInformationThread iit = new ItemInformationThread(itemId, p);
        iit.run();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reloadAllItems() {
        try {
            for (int i = 1067; i <= 1093; i++) {
                int proxyNumber = i % 8;
                Proxy p = proxies.get(proxyNumber);
                ItemInformationThread iit = new ItemInformationThread(i, p);
                iit.run();
                Thread.sleep(300);
            }
            throw new Exception("reloadAllItems() has not been implemented yet!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
