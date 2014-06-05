/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ItemController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import model.Category;
import model.ORM.ItemRow;
import model.ORM.ItemTable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Pim
 */
public class ItemInformationThread implements Runnable {

    protected int itemId;
    protected Proxy proxy;
    protected ItemController itemController;

    /**
     * The thread which retrieves the information for an item. Required is an
     * itemId.
     *
     * @param itemId
     */
    public ItemInformationThread(int itemId, Proxy p, ItemController ic) {
        this.itemId = itemId;
        this.proxy = p;
        this.itemController = ic;
    }

    @Override
    public void run() {
        try {
            // Item i = new Item();
            ItemTable it = new ItemTable();
            ItemRow i = it.createRow();
            retrieveItemInformation(i);
            retrieveAccuratePriceInformation(i);
            itemController.addItemToList(i);

        } catch (Exception e) {
            if (!(e instanceof FileNotFoundException)) {
                System.err.println("Error retrieving item with itemId: " + this.itemId);
                e.printStackTrace();
            }
        }
    }

    private ItemRow retrieveItemInformation(ItemRow i) throws Exception {
        URL itemInformation = new URL(getItemInformationURL());
        URLConnection conn = itemInformation.openConnection(this.proxy);

        InputStream is = conn.getInputStream();
//InputStream is = itemInformation.openStream();

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
        String categoryString = itemObject.get("type").toString();
        //categoryString = categoryString.replace(' ', '_');
        //categoryString = categoryString.toUpperCase();
        Category category = Category.getByNiceName(categoryString);

        //Extract currentObject
        String currentTrend = currentObject.get("trend").toString();
        String priceString = currentObject.get("price").toString();
        int price = -1;
        try {
            price = Integer.parseInt(priceString);
        } catch (Exception e) {
            price = -11;
        }

        //Extract todayObject
        String todayTrend = todayObject.get("trend").toString();
        String todayPriceChange = todayObject.get("price").toString();
        //int todayPriceChange = Integer.parseInt(todayPriceString);

        //Extract day30Object
        String day30Trend = day30Object.get("trend").toString();
        String day30Change = day30Object.get("change").toString();

        //Extract day90Object
        String day90Trend = day90Object.get("trend").toString();
        String day90Change = day90Object.get("change").toString();

        //Extract day180Object
        String day180Trend = day180Object.get("trend").toString();
        String day180Change = day180Object.get("change").toString();

        //Set values for this new Item
        i.setID(this.itemId);
        i.setName(name);
        i.setDescription(description);
        i.setTodayPriceChange(todayPriceChange);
        i.setTodayTrend(todayTrend);
        i.setDay30Trend(day30Trend);
        i.setDay30Change(day30Change);
        i.setDay90Trend(day90Trend);
        i.setDay90Change(day90Change);
        i.setDay180Trend(day180Trend);
        i.setDay180Change(day180Change);
        i.setMembers(members);
        i.setCategory(category);
        i.setLastUpdated();
        i.insertNewWithID();
        return i;
    }

    private ItemRow retrieveAccuratePriceInformation(ItemRow i) {
        return i;
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;

        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }

    private String getItemInformationURL() {
        return "http://services.runescape.com/m=itemdb_rs/api/catalogue/detail.json?item=" + this.itemId;
    }

    private String getAccurateItemPriceURL() {
        return "http://services.runescape.com/m=itemdb_rs/api/graph/" + itemId + ".json";
    }

}
