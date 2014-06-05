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
    
    
    public Offer(Item item) {
        this.item = item;
    }
    
    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }
    
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    public int calculateMargin() {
        return this.sellPrice - this.buyPrice;
    }
    
}
