/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author Pim
 */
public class retrieveItemThread implements Runnable{

    protected int itemId;
    
    /**
     * The thread which retrieves the information for an item. Required is an itemId.
     * @param itemId 
     */
    public retrieveItemThread(int itemId) {
        this.itemId = itemId;
    }
    
    @Override
    public void run() {
        
    }
    
    private String getAPIURL() {
        return "http://services.runescape.com/m=itemdb_rs/api/catalogue/detail.json?item=" + this.itemId;
    }
    
}
