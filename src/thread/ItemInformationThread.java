/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ItemController;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import model.Category;
import model.CustomProxy;
import model.ItemReader;
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
    protected CustomProxy proxy;
    protected ItemController itemController;
    protected ItemReader itemReader;

    /**
     * The thread which retrieves the information for an item. Required is an
     * itemId.
     *
     * @param itemId
     * @param p
     * @param ic
     * @param ir
     */
    public ItemInformationThread(int itemId, CustomProxy p, ItemController ic, ItemReader ir) {
        this.itemId = itemId;
        this.proxy = p;
        this.itemController = ic;
        this.itemReader = ir;
    }

    @Override
    public void run() {
        try {
            itemController.showBusy(true);
            ItemTable it = new ItemTable();
            ItemRow i = it.createRow();
            retrieveItemInformation(i);
            retrieveAccuratePriceInformation(i);
            i.insertNewWithID();

            System.out.println("Item retrieved: " + i);
            //itemController.addItemToList(i);
            itemController.updateInTable(i);
            itemController.showBusy(false);

        } catch (Exception e) {

            this.proxy.freeSlot();
            if (e instanceof FileNotFoundException) {
            } else {
                // System.err.println("Error retrieving item with itemId: " + this.itemId + ". -- RETRYING");
                // System.err.println(this.proxy.address());
                e.printStackTrace();
                itemController.reloadItem(itemId);
            }

        }
    }

    private ItemRow retrieveItemInformation(ItemRow i) throws Exception {
        long start = System.currentTimeMillis();
        URL itemInformation = new URL(getItemInformationURL());
        URLConnection conn;
        if (this.proxy != null) {
            conn = itemInformation.openConnection(this.proxy);

        } else {
            conn = itemInformation.openConnection();
        }

        conn.setConnectTimeout(2500);

        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String json = (String) readAll(br);
        long end = System.currentTimeMillis();
        System.out.println("Length: " + (end - start));

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
        Category category = Category.getByNiceName(categoryString);
        String imageURL = itemObject.get("icon_large").toString();

        //Extract currentObject
        String currentTrend = currentObject.get("trend").toString();
        String currentPrice = currentObject.get("price").toString();

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

        //Todays date for last updated
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//
//        Date today = Calendar.getInstance().getTime();
//        String reportDate = df.format(today);
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);

        //Set values for this new Item
        i.setID(this.itemId);
        i.setName(name);
        i.setDescription(description);
        i.setCurrentTrend(currentTrend);
        i.setCurrentPrice(currentPrice);
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
        i.setLastUpdated(currentTime);
        downloadImage(imageURL, i);

        return i;
    }

    private ItemRow retrieveAccuratePriceInformation(ItemRow i) throws Exception {
        long start = System.currentTimeMillis();
        URL itemInformation = new URL(getAccurateItemPriceURL());
        URLConnection conn;
        if (this.proxy != null) {
            conn = itemInformation.openConnection(this.proxy);
        } else {
            conn = itemInformation.openConnection();
        }

        conn.setConnectTimeout(5000);
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String json = (String) readAll(br);
        long end = System.currentTimeMillis();
        System.out.println("Length: " + (end - start));

        JSONObject rootObject = (JSONObject) new JSONParser().parse(json);
        JSONObject dailyObject = (JSONObject) new JSONParser().parse(rootObject.get("daily").toString());

        Object[] keys = dailyObject.keySet().toArray();
        Object[] values = dailyObject.entrySet().toArray();

        TreeMap<String, String> daily = new TreeMap<>();
        for (int x = 0; x < keys.length; x++) {
            daily.put(keys[x].toString(), values[x].toString());
        }

        SortedSet<String> sortedKeys = new TreeSet<String>(daily.keySet());
        String value = "";
        for (String key : sortedKeys) {
            value = daily.get(key).split("=")[1];
        }
        int accuratePrice = Integer.parseInt(value);
        i.setAccuratePrice(accuratePrice);

        return i;
    }

    private void downloadImage(String urlString, ItemRow item) throws Exception {
        URL url = new URL(urlString);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos
                = new FileOutputStream(
                        "C://RSMerchTool//RSMerchTool-Java//images//" + item.getItemId() + ".jpg"
                );
        fos.write(response);
        fos.close();
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
