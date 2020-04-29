package com.World;

import com.Entities.Creature.Player;
import com.Entities.Creature.Police;
import com.Entities.EntityManager;
import com.Entities.Static.Coin;
import com.Entities.Static.Dimension;
import com.Entities.Static.Rock;
import com.Entities.Static.Tree;
import com.Item.ItemManager;
import com.Main.Game;
import com.Main.Handler;
import com.Tile.Tile;
import com.Utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width,height,spawnX,spawnY;
    private int[][] tiles;
    private EntityManager entityManager;
    private ItemManager itemManager;
    public World(Handler handler, String path){
        this.handler=handler;
        entityManager=new EntityManager(handler,new Player(handler,100,100),new Police(handler,200,700),new Police(handler,180,700));
        itemManager=new ItemManager(handler);
        entityManager.addEntity(new Tree(handler,220,360));
        entityManager.addEntity(new Rock(handler,740,940));
        //entityManager.addEntity(new Tree(handler,470,360));
        entityManager.addEntity(new Tree(handler,700,750));
        entityManager.addEntity(new Tree(handler,765,750));
        entityManager.addEntity(new Tree(handler,730,750));
        //entityManager.addEntity(new Coin(handler,600,120));
        entityManager.addEntity(new Tree(handler,650,750));
        entityManager.addEntity(new Tree(handler,800,750));
        entityManager.addEntity(new Tree(handler,800,800));
        entityManager.addEntity(new Tree(handler,800,850));
        entityManager.addEntity(new Tree(handler,650,800));
        entityManager.addEntity(new Tree(handler,800,870));
        entityManager.addEntity(new Rock(handler,760,940));
        entityManager.addEntity(new Dimension(handler,740,800));


        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    public void tick(){
        itemManager.tick();
        entityManager.tick();
    }
    public void render(Graphics g){
        int xStart=(int)Math.max(0,handler.getGameCemera().getxOffset() / Tile.TW);
        int xEnd=(int)Math.min(width,(handler.getGameCemera().getxOffset() + handler.getWidth())/ Tile.TW +1);
        int yStart=(int)Math.max(0,handler.getGameCemera().getyOffset() / Tile.TH);;
        int yEnd=(int)Math.min(height,(handler.getGameCemera().getyOffset() + handler.getHeight())/ Tile.TH+1);
        for(int y=yStart;y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++){
                getTile(x,y).render(g,(int)(x*Tile.TH-handler.getGameCemera().getxOffset()),(int)(y*Tile.TW-handler.getGameCemera().getyOffset()));
            }
        }
        itemManager.render(g);
        entityManager.render(g);

    }
    public Tile getTile(int x,int y){
        if(x<0 || y<0 || x>=width || y>=height)
            return Tile.grassTile;
        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null) return Tile.treeTile;
        return t;
    }
    private void loadWorld(String path){
        String file= Utils.loadFileAsString(path);
        String[] tokens=file.split("\\s+");
        width=Utils.parseInt(tokens[0]);
        height=Utils.parseInt(tokens[1]);
        spawnX=Utils.parseInt(tokens[2]);
        spawnY=Utils.parseInt(tokens[3]);
        tiles=new int[width][height];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
            }
        }


    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

}
