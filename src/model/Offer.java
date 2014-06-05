/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author PimGame
 */
public class Offer {
    
    private Item item;
    private int buyPrice;
    private int sellPrice;
    private boolean completed;
    
    
    public Offer(Item item) {
        this.item = item;
    }
    
    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }
    
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    public int getBuyPrice() {
        return this.buyPrice;
    }
    
    public int getSellPrice() {
        return this.sellPrice;
    }
    
    public boolean getCompleted() {
        return this.completed;
    }
    
    public int calculateMargin() {
        return this.sellPrice - this.buyPrice;
    }
    
}
