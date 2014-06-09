/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ORM;

/**
 *
 * @author PimGame
 */
public class OfferRow extends DbRow {

    public OfferRow() {

    }

    public void setUserId(String userId) {
        set("user_id", userId);
    }

    public void setItemId(String itemId) {
        set("item_id", itemId);
    }

    public void setItemBuyPrice(String itemBuyPrice) {
        set("item_buy_price", itemBuyPrice);
    }

    public void setItemSellPrice(String itemSellPrice) {
        set("item_sell_price", itemSellPrice);
    }

    public void setProfit(String profit) {
        set("profit", profit);
    }

    public void setOfferCompleted(String offerCompleted) {
        set("offer_completed", offerCompleted);
    }

    public void setDeleted(String deleted) {
        set("deleted", deleted);
    }

    public String getUserId() {
        return get("user_id");
    }

    public String getItemId() {
        return get("item_id");
    }
    
    public ItemRow getItem() {
        return ItemTable.getInstance().fetch(Integer.parseInt(getItemId()));
    }

    public String getItemBuyPrice() {
        return get("item_buy_price");
    }

    public String getItemSellPrice() {
        return get("item_sell_price");
    }

    public String getProfit() {
        return get("profit");
    }

    public String getOfferCompleted() {
        return get("offer_completed");
    }

    public String getDeleted() {
        return get("deleted");
    }

}
