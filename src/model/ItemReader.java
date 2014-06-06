/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ItemController;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import thread.ItemInformationThread;

/**
 *
 * @author PimGame
 */
public class ItemReader {

    //private MyThreadPoolExecutor mtpe;
    private ScheduledExecutorService stpe;
    private ItemController itemController;
    private ArrayList<CustomProxy> proxies;
    private HashMap<String, Integer> netSockets;
    private Object[] netSocketKeys;
    private ProxyGenerator proxyGen;
    private boolean busy;
    private ExecutorService es;

    public ItemReader(ItemController itemController) {
        // mtpe = new MyThreadPoolExecutor(10, 10, 60000, TimeUnit.MILLISECONDS, bq);
        stpe = Executors.newScheduledThreadPool(10);
        es = Executors.newFixedThreadPool(10);
        this.itemController = itemController;

        proxyGen = new ProxyGenerator();
        netSockets = proxyGen.extractProxiesFromAPI();
        netSocketKeys = netSockets.keySet().toArray();

        proxies = new ArrayList<>();

        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("58.137.145.242", 80)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("62.201.214.212", 3128)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("62.210.226.131", 8888)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("64.188.44.103", 7808))); //INVALID
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("66.35.68.145", 8089))); //INVALID
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("86.108.193.205", 80)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("107.182.16.221", 7808)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("122.129.73.203", 8080))); //INVALID
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("149.255.255.250", 80)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("178.17.170.89", 7808)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("185.15.43.51", 8080)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("192.227.139.227", 3127)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("195.242.197.131", 80)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("198.52.217.44", 3127)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("209.170.151.142", 7808)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("216.189.101.121", 7808)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("217.12.204.22", 3128)));
        proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress("219.68.214.198", 8888))); //INVALID

    }

    public void retrieveItem(int itemId) {
        Random rnd = new Random();
        int proxyNumber = rnd.nextInt(proxies.size());
        stpe.schedule(new ItemInformationThread(itemId, proxies.get(proxyNumber), itemController, this), 0, TimeUnit.MILLISECONDS);
    }

    public void retrieveAllItems() {
        for (int itemId = 1; itemId < 35000; itemId++) {

            int proxyNumber = itemId % (proxies.size());
            stpe.schedule(new ItemInformationThread(itemId, proxies.get(proxyNumber), itemController, this), 1000, TimeUnit.MILLISECONDS);
        }
    }

    public boolean isBusy() {
        return this.busy;
    }

}
