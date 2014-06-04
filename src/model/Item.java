/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pim
 */
public class Item {

    private int itemId;
    private String name;
    private String description;
    private int price;
    private String currentTrend;
    private String todayTrend;
    private int todayPriceChange;
    private boolean members;
    private String day30Trend;
    private String day30Change;
    private String day90Change;
    private String day90Trend;
    private String day180Trend;
    private String day180Change;
    private Category category;

    public Item() {

    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrentTrend(String currentTrend) {
        this.currentTrend = currentTrend;
    }

    public void setTodayTrend(String todayTrend) {
        this.todayTrend = todayTrend;
    }

    public void setTodayPriceChange(int todayPriceChange) {
        this.todayPriceChange = todayPriceChange;
    }

    public void setMembers(boolean members) {
        this.members = members;
    }

    public void setDay30Trend(String day30Trend) {
        this.day30Trend = day30Trend;
    }

    public void setDay30Change(String day30Change) {
        this.day30Change = day30Change;
    }

    public void setDay90Trend(String day90Trend) {
        this.day90Trend = day90Trend;
    }

    public void setDay90Change(String day90Change) {
        this.day90Change = day90Change;
    }

    public void setDay180Trend(String day180Trend) {
        this.day180Trend = day180Trend;
    }

    public void setDay180Change(String day180Change) {
        this.day180Change = day180Change;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }

    public String getCurrentTrend() {
        return this.currentTrend;
    }

    public String getTodayTrend() {
        return this.todayTrend;
    }

    public int getTodayPriceChange() {
        return this.todayPriceChange;
    }

    public boolean isMembers() {
        return this.members;
    }

    public String getDay30Trend() {
        return this.day30Trend;
    }

    public String getDay30Change() {
        return this.day30Change;
    }

    public String getDay90Trend() {
        return this.day90Trend;
    }

    public String getDay90Change() {
        return this.day90Change;
    }

    public String getDay180Trend() {
        return this.day180Trend;
    }

    public String getDay180Change() {
        return this.day180Change;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        String information = "";
        information += "Name: " + this.name + "\n";
        information += "Current Price: " + this.price + "\n";
        information += "180 Day Trend: " + this.day180Trend + "\n";
        information += "Category: " + this.category.toString() + "\n";
        return information;
    }

}
