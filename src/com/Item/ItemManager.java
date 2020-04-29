package com.Item;

import com.Graphics.Assets;
import com.Main.Handler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {
    private Handler handler;
    public  int p=0,w=0;
    public  int j=0;
    private ArrayList<Item> items;
    public ItemManager(Handler handler){
        this.handler=handler;
        items=new ArrayList<Item>();
    }
    public void tick(){
        Iterator<Item> it=items.iterator();
        while(it.hasNext()){
            Item i=it.next();
            if(i.getId()==12){
                j=1;
            }
            if(i.getId()<12)
               i.tick();
            else if(i.getId()>=12 && j==1)
                i.tick();
            if (i.isPickedUp()) {
                System.out.println("Picked up");
                System.out.println(i.getId());
                p+=i.getProfit()[i.getId()];
                w+=i.getWeight()[i.getId()];
                it.remove();
            }


        }
    }
    public void render(Graphics g){
        for(Item i:items){
            i.render(g);
        }
    }
    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public  int getJ() {
        return j;
    }

    public int getP() {
        return p;
    }

    public int getW() {
        return w;
    }
}
