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
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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
    private final BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(9001);
    private ItemController itemController;
    private ArrayList<Proxy> proxies;

    public ItemReader(ItemController itemController) {
        // mtpe = new MyThreadPoolExecutor(10, 10, 60000, TimeUnit.MILLISECONDS, bq);
        stpe = Executors.newScheduledThreadPool(15);
        this.itemController = itemController;

        proxies = new ArrayList<>();
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("217.12.204.22", 3128)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("178.17.170.89", 7808)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("149.255.255.250", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("195.242.197.131", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("86.108.193.205", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("58.137.145.242", 80)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("62.201.214.212", 3128)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("219.68.214.198", 8888)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("122.129.73.203", 8080)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("217.12.204.22", 3128)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("107.182.16.221", 7808)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("64.188.44.103", 7808)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("198.52.217.44", 3127)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("216.189.101.121", 7808)));
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("209.170.151.142", 7808)));

    }

    public void retrieveItem(int itemId) {
        Random rnd = new Random();
        int proxyNumber = rnd.nextInt(proxies.size());
        //mtpe.execute(new ItemInformationThread(itemId, proxies.get(proxyNumber), itemController));
        stpe.schedule(new ItemInformationThread(itemId, proxies.get(proxyNumber), itemController), 1000, TimeUnit.MILLISECONDS);
    }

    public void retrieveAllItems() {
        for (int itemId = 1; itemId < 16000; itemId++) {
            int proxyNumber = itemId % (proxies.size() - 1);

            //  mtpe.execute(new ItemInformationThread(itemId, proxies.get(proxyNumber), itemController));
            stpe.schedule(new ItemInformationThread(itemId, proxies.get(proxyNumber), itemController), 1000, TimeUnit.MILLISECONDS);
        }
    }

}
