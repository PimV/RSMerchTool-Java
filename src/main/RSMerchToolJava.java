/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import thread.RetrieveItemThread;

/**
 *
 * @author Pim
 */
public class RSMerchToolJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RetrieveItemThread rit = new RetrieveItemThread(4798);
        rit.run();
    }
    
}
