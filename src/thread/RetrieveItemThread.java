/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import model.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Pim
 */
public class RetrieveItemThread implements Runnable {

    protected int itemId;

    /**
     * The thread which retrieves the information for an item. Required is an
     * itemId.
     *
     * @param itemId
     */
    public RetrieveItemThread(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public void run() {
        try {

            URL url = new URL(getAPIURL());

            InputStream is = url.openStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String json = (String) readAll(br);

            JSONObject rootObject = (JSONObject) new JSONParser().parse(json);
            JSONObject itemObject = (JSONObject) new JSONParser().parse(rootObject.get("item").toString());
            JSONObject currentObject = (JSONObject) new JSONParser().parse(itemObject.get("current").toString());
            JSONObject todayObject = (JSONObject) new JSONParser().parse(itemObject.get("today").toString());
            JSONObject day30Object = (JSONObject) new JSONParser().parse(itemObject.get("day30").toString());
            JSONObject day90Object = (JSONObject) new JSONParser().parse(itemObject.get("day90").toString());
            JSONObject day180Object = (JSONObject) new JSONParser().parse(itemObject.get("day180").toString());

            //Extract itemObject
            String name = itemObject.get("name").toString();
            String description = itemObject.get("description").toString();
            String membersString = itemObject.get("members").toString();
            boolean members = false;
            if (membersString.equals("true")) {
                members = true;
            }

            //Extract currentObject
            String currentTrend = currentObject.get("trend").toString();
            String priceString = currentObject.get("price").toString();
            int price = Integer.parseInt(priceString);

            //Extract todayObject
            String todayTrend = todayObject.get("trend").toString();
            String todayPriceString = todayObject.get("price").toString();
            int todayPrice = Integer.parseInt(todayPriceString);

            //Extract day30Object
            String day30Trend = day30Object.get("trend").toString();
            String day30Change = day30Object.get("change").toString();

            //Extract day90Object
            String day90Trend = day90Object.get("trend").toString();
            String day90Change = day90Object.get("change").toString();

            //Extract day180Object
            String day180Trend = day180Object.get("trend").toString();
            String day180Change = day180Object.get("change").toString();

            //Create a new Item
            Item i = new Item();

            //Set values for this new Item
            i.setName(name);
            i.setDescription(description);
            i.setPrice(price);
            i.setCurrentTrend(currentTrend);
            i.setTodayPrice(todayPrice);
            i.setTodayTrend(todayTrend);
            i.setDay30Trend(day30Trend);
            i.setDay30Change(day30Change);
            i.setDay90Trend(day90Trend);
            i.setDay90Change(day90Change);
            i.setDay180Trend(day180Trend);
            i.setDay180Change(day180Change);
            i.setMembers(members);

        } catch (Exception e) {
            System.err.println("Error retrieving item with itemId: " + this.itemId);
            e.printStackTrace();
        }
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;

        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }

    private String getAPIURL() {
        return "http://services.runescape.com/m=itemdb_rs/api/catalogue/detail.json?item=" + this.itemId;
    }

}
