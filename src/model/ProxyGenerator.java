/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author PimGame
 */
public class ProxyGenerator {

    private static final String apiURL = "http://letushide.com/fpapi/?key=43690b9a77c41a8ca6c67d4e&cs=us,ca,nl,de,uk&as=http,https&as=hap";
    private HashMap<String, Integer> inetSockets;
    private Object[] inetSocketsKeys;
    private Random rnd;

    public ProxyGenerator() {
        extractProxiesFromAPI();
        inetSocketsKeys = inetSockets.keySet().toArray();
        rnd = new Random();

    }

    public Proxy getRandomProxy() {
        String host = (String) inetSocketsKeys[rnd.nextInt(inetSocketsKeys.length)];
        int port = inetSockets.get(host);
        Proxy p = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
        return p;
    }

    public HashMap<String, Integer> extractProxiesFromAPI() {
        if (inetSockets == null) {
            inetSockets = new HashMap<>();
            try {
                URL itemInformation = new URL(apiURL);
                URLConnection conn = itemInformation.openConnection();

                InputStream is = conn.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String json = (String) readAll(br);

                JSONObject rootObject = (JSONObject) new JSONParser().parse(json);
                JSONArray data = (JSONArray) rootObject.get("data");
                Iterator<JSONObject> iterator = data.iterator();
                while (iterator.hasNext()) {

                    JSONObject dataObject = iterator.next();
                    String host = dataObject.get("host").toString();
                    int port = Integer.parseInt(dataObject.get("port").toString());
                    inetSockets.put(host, port);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return inetSockets;

    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;

        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }

}
