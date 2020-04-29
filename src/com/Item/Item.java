package com.Item;

import com.Graphics.Assets;
import com.Graphics.ImageLoader;
import com.Graphics.Spritesheet;
import com.Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;

public class Item {
    public static Item[] items=new Item[256];
    public  int[] profit=new int[20];
    public  int[] weight=new int[20];
    public static Item woodItem=new Item(Assets.TWood,"Wood",0,50,50);
    public static Item rockItem=new Item(Assets.SRock,"Rock",1,50,50);
    public static Item dimension=new Item(Assets.dimension,"Rock",2,50,50);
    public static Item stone=new Item(Assets.coin,"Stone",3,50,50);
    public static Item stone1=new Item(Assets.coin_1,"Stone1",4,50,50);
    public static Item v1=new Item(Assets.value1,"value1",5,50,50);
    public static Item v2=new Item(Assets.value2,"value2",6,50,50);
    public static Item v3=new Item(Assets.value3,"value3",7,50,50);
    public static Item v4=new Item(Assets.value4,"value4",8,50,50);
    public static Item v5=new Item(Assets.value5,"value5",9,50,50);
    public static Item v6=new Item(Assets.value6,"value6",10,50,50);
    public static Item stone2=new Item(Assets.coin_2,"Stone2",11,50,50);
    public static Item bag=new Item(Assets.bag,"Bag-(max-16kg)",12,50,50);
    public static Item c1=new Item(Assets.c1,"Coin-1",13,100,100);
    public static Item c2=new Item(Assets.c2,"Coin-2",14,100,100);
    public static Item c3=new Item(Assets.c3,"Coin-3",15,100,100);
    public static Item c4=new Item(Assets.c4,"Coin-4",16,100,100);
    public static Item c5=new Item(Assets.c5,"Coin-5",17,100,100);
    public static Item c6=new Item(Assets.c6,"Coin-6",18,100,100);
    public static Item c7=new Item(Assets.c7,"Coin-7",19,100,100);

    public  int ItemWidth, ItemHeight;
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;
    protected int x, y, count;
    public Rectangle bounds;
    protected boolean pickedUp=false,bagpickup=false;

    public Item(BufferedImage texture, String name, int id,int itemWidth,int itemHeight) {
        this.texture = texture;
        this.name = name;
        this.id = id;
        this.ItemWidth=itemWidth;
        this.ItemHeight=itemHeight;
        profit[13]=10;
        weight[13]=2;
        profit[14]=5;
        weight[14]=3;
        profit[15]=15;
        weight[15]=5;
        profit[16]=7;
        weight[16]=7;
        profit[17]=6;
        weight[17]=1;
        profit[18]=18;
        weight[18]=4;
        profit[19]=3;
        weight[19]=1;
        count = 1;
        bounds=new Rectangle(10,10,ItemWidth,ItemHeight);
        items[id]=this;
    }

    public void tick() {
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)) {
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(this);
        }
    }

    public void render(Graphics g){
        if(handler==null)
            return;
        render(g,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()));
    }

    private void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, ItemWidth, ItemHeight, null);
    }
    public Item createNew(int x,int y){
        Item i=new Item(texture,name,id,ItemWidth,ItemHeight);
        i.setPosition(x,y);
        return i;
    }
    public Item createNew(int count){
        Item i=new Item(texture,name,id,ItemWidth,ItemHeight);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }

    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
        bounds.x=x;
        bounds.y=y;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public  int[] getProfit() {
        return profit;
    }

    public  int[] getWeight() {
        return weight;
    }
}
