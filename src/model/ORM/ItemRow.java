/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ORM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.Category;

/**
 *
 * @author PimGame
 */
public class ItemRow extends DbRow {

    private int itemId;
    private String name;
    private String description;
    private int currentPrice;
    private String currentTrend;
    private String todayTrend;
    private String todayPriceChange;
    private boolean members;
    private String day30Trend;
    private String day30Change;
    private String day90Change;
    private String day90Trend;
    private String day180Trend;
    private String day180Change;
    private Category category;
    private String lastUpdated;

    public ItemRow() {

    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
        setID(itemId);
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
        set("current_price", currentPrice + "");

    }

    public void setName(String name) {
        this.name = name;
        set("name", name);
    }

    public void setDescription(String description) {
        this.description = description;
        set("description", description);
    }

    public void setTodayTrend(String todayTrend) {
        this.todayTrend = todayTrend;
        set("today_trend", todayTrend);
    }

    public void setTodayPriceChange(String todayPriceChange) {
        this.todayPriceChange = todayPriceChange;
        set("today_price_change", todayPriceChange + "");
    }

    public void setMembers(boolean members) {
        this.members = members;
        if (members == true) {
            set("members", 1 + "");
        } else {
            set("members", 0 + "");
        }
    }

    public void setDay30Trend(String day30Trend) {
        this.day30Trend = day30Trend;
        set("30day_trend", day30Trend);
    }

    public void setDay30Change(String day30Change) {
        this.day30Change = day30Change;
        set("30day_change", day30Change);
    }

    public void setDay90Trend(String day90Trend) {
        this.day90Trend = day90Trend;
        set("90day_trend", day90Trend);
    }

    public void setDay90Change(String day90Change) {
        this.day90Change = day90Change;
        set("90day_change", day90Change);
    }

    public void setDay180Trend(String day180Trend) {
        this.day180Trend = day180Trend;
        set("180day_trend", day180Trend);
    }

    public void setDay180Change(String day180Change) {
        this.day180Change = day180Change;
        set("180day_change", day180Change);
    }

    public void setCategory(Category category) {
        this.category = category;
        set("category", category.getCategoryNumber() + "");
    }

    public void setLastUpdated() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        this.lastUpdated = reportDate;
        set("last_updated", getLastUpdated());
    }

    public int getItemId() {
        return getID();
        //return this.itemId;
    }

    public String getName() {
        return get("name");
        //return this.name;
    }

    public String getDescription() {
        return get("description");
        //return this.description;
    }

    public String getPrice() {
        return get("current_price");
        //return this.currentPrice;
    }

    public String getTodayTrend() {
        return get("today_trend");
        // return this.todayTrend;
    }

    public String getTodayPriceChange() {
        return get("today_price_change");
        // return this.todayPriceChange;
    }

    public boolean isMembers() {
        return this.members;
    }

    public String getDay30Trend() {
        return get("30day_trend");
        //return this.day30Trend;
    }

    public String getDay30Change() {
        return get("30day_change");
        //return this.day30Change;
    }

    public String getDay90Trend() {
        return get("90day_trend");
        //return this.day90Trend;
    }

    public String getDay90Change() {
        return get("90day_change");
        //return this.day90Change;
    }

    public String getDay180Trend() {
        return get("180day_trend");
        //return this.day180Trend;
    }

    public String getDay180Change() {
        return get("180day_change");
        //return this.day180Change;
    }

    public Category getCategory() {
        return Category.getByNumber(Integer.parseInt(get("category")));
        //return this.category;
    }

    public String getLastUpdated() {
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        return currentTime;
    }

    @Override
    public String toString() {
       // String information = "";
        // information += "Name: " + this.name + "\n";
        // information += "Current Price: " + this.currentPrice + "\n";
        // information += "180 Day Trend: " + this.day180Trend + "\n";
        // information += "Category: " + this.category.toString() + "\n";
        // return information;
        return getName();
    }

}
