package com.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles=new Tile[256];
    public static Tile grassTile=new GrassTile(0);
    public static Tile rockTile=new RockTile(1);
    public static Tile treeTile=new TreeTile(2);
    public static Tile rock1Tile=new Rock1Tile(3);
    public static Tile blackTile=new DarkTile(4);
    public static Tile dartTile=new DartTile(5);
    public static int TW=64,TH=64;
    protected BufferedImage texture;
    protected final int id;
    public Tile(BufferedImage texture,int id) {
        this.id=id;
        this.texture=texture;
        tiles[id]=this;
    }
    public void tick(){

    }
    public void render(Graphics g,int x,int y){
        g.drawImage(texture,x,y,TW,TH,null);

    }
    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }
}
