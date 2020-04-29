package com.Inventory;

import com.Graphics.Assets;
import com.Graphics.Text;
import com.Item.Item;
import com.Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {
    private Handler handler;
    private boolean active=false;
    private ArrayList<Item> inventoryItems;
    private int invX=64,invY=48,invWidth=512,invHeight=348,
    invListCenterX=invX+171,invListCenterY=invY+invHeight/2+5,invListSpacing = 30;;

    private int invImageX = 451, invImageY = 76,
            invImageWidth = 64, invImageHeight = 64;

    private int invCountX = 484, invCountY = 164;

    private int selectedItem = 0;
    public Inventory(Handler handler) {
        this.handler=handler;
        inventoryItems=new ArrayList<Item>();
        //addItems(Item.rockItem.createNew(0));
        //addItems(Item.woodItem.createNew(0));
    }
    public void tick(){
        if(handler.getKeyManeger().justPressed[KeyEvent.VK_E])
            active = !active;
        if(!active) return;
        if(handler.getKeyManeger().justPressed[KeyEvent.VK_W])
            selectedItem--;
        if(handler.getKeyManeger().justPressed[KeyEvent.VK_D])
            selectedItem++;

        if(selectedItem < 0)
            selectedItem = inventoryItems.size() - 1;
        else if(selectedItem >= inventoryItems.size())
            selectedItem = 0;


    }
    public void render(Graphics g){
        if(!active) return;
        g.drawImage(Assets.inventoryScreen,invX,invY,invWidth,invHeight,null);
        int len=inventoryItems.size();
        if(len==0) return;
        for(int i = -5;i < 6;i++){
            if(selectedItem + i < 0 || selectedItem + i >= len)
                continue;
            if(i == 0){
                Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
            }else{
                Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
            }
        }

        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
        Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);

    }
    public void addItems(Item item){
        for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
        inventoryItems.add(item);

    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public int getLength(){
        return inventoryItems.size();
    }

}
