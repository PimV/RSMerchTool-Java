/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author PimGame
 */
public class ProxyLoader {

    private static final String apiURL = "http://letushide.com/fpapi/?key=43690b9a77c41a8ca6c67d4e&cs=us,ca,nl,de,uk&as=http,https&as=hap";
    private Map<String, Integer> inetSockets;
    private Object[] inetSocketsKeys;
    private ArrayList<CustomProxy> proxies;
    private Random rnd;

    public ProxyLoader() {

    }

    public ArrayList<CustomProxy> extractProxiesFromAPI(String filePath) {
        if (proxies == null) {
            proxies = new ArrayList<>();
            try {
                FileReader reader = new FileReader(new File(filePath));
                BufferedReader br = new BufferedReader(reader);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] lineParts = line.split(":");
                    String host = lineParts[0];
                    int port = Integer.parseInt(lineParts[1]);
                    proxies.add(new CustomProxy(Proxy.Type.HTTP, new InetSocketAddress(host, port)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(proxies.size());
        return proxies;

    }

}
