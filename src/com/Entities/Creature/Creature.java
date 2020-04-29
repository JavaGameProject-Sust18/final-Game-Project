package com.Entities.Creature;

import com.Entities.Entity;
import com.Main.Game;
import com.Main.Handler;
import com.Tile.Tile;

import java.awt.*;

public abstract class Creature extends Entity {
    public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_CREATE_WIDTH=64,DEFAULT_CREATE_HEIGHT=64;
    protected float speed;
    public float xmove,ymove;
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler,x,y,width,height);
        speed=DEFAULT_SPEED;
        xmove=0;
        ymove=0;

    }
    public void move(){
        if(!checkEntityCollisions(xmove,0f))
            moveX();
        if(!checkEntityCollisions(0f,ymove))
            moveY();
    }
    public void moveX(){
        if(xmove >0){
            int tx=(int) (x+xmove+bounds.x+bounds.width)/ Tile.TW;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TH) &&
             !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TH)){
                x+=xmove;
            }else {
                x=tx*Tile.TW-bounds.x-bounds.width-1;
            }
        }else if(xmove <0){
            int tx=(int) (x+xmove+bounds.x)/ Tile.TW;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TH) &&
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TH)){
                x+=xmove;
            }else{
                x=tx*Tile.TW+Tile.TW-bounds.x;
            }
        }
    }
    public void moveY(){
        if(ymove <0){
            int ty=(int) (y+ymove+bounds.y)/ Tile.TH;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TW,ty) &&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TW,ty)){
                y+=ymove;
            }else{
                y=ty*Tile.TH+Tile.TH-bounds.y;
            }
        }else if(ymove> 0){
            int ty=(int) (y+ymove+bounds.y+bounds.height)/ Tile.TH;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TW,ty) &&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TW,ty)){
                y+=ymove;
            }else{
                y=ty*Tile.TH-bounds.y-bounds.height-1;
            }
        }
    }
    protected boolean collisionWithTile(int x,int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    public float getXmove() {
        return xmove;
    }

    public void setXmove(float xmove) {
        this.xmove = xmove;
    }

    public float getYmove() {
        return ymove;
    }

    public void setYmove(float ymove) {
        this.ymove = ymove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
