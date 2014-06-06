/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.Proxy;
import java.net.SocketAddress;

/**
 *
 * @author PimGame
 */
public class CustomProxy extends Proxy {

    private boolean hasFreeSlot;
    private int freeSlots;

    public CustomProxy(Type type, SocketAddress sa) {
        super(type, sa);
        hasFreeSlot = true;
        freeSlots = 1;
    }

    public void useSlot() {
        if (hasFreeSlot()) {
            freeSlots--;
        }
        if (freeSlots <= 0) {
            hasFreeSlot = false;
        }
        System.out.println("Proxy has: " + freeSlots + " free slots.");
    }

    public boolean hasFreeSlot() {
        return this.hasFreeSlot;
    }

    public void freeSlot() {
        freeSlots++;
        if (freeSlots > 1) {
            freeSlots = 1;
        }
        System.out.println("Proxy has: " + freeSlots + " free slots.");
    }

}
