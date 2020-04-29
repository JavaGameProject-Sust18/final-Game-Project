package com.Entities;

import com.Entities.Static.Dimension;
import com.Graphics.Assets;
import com.Main.Game;
import com.Main.Handler;

import javax.swing.*;
import java.awt.*;

public abstract class Entity {
    protected Handler handler;
    public  float x,y;
    public int width,height;
    protected Rectangle bounds;
    protected int health;
    protected boolean activate=true;
    public static final int DEFAULT_HEALTH=3;
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        health=DEFAULT_HEALTH;
        bounds=new Rectangle(0,0,width,height);
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void passThrough();
    public void touch(boolean amt){
        /*health-=amt;
        if(health<=0){
            activate=false;
            die();
        }*/
        if(amt) passThrough();
    }
    public boolean checkEntityCollisions(float xOffset,float yOffset){
        for(Entity e:handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;

            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset))) {
                return true;
            }

        }
        return false;
    }
    public Rectangle getCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    }

    public float getX() {
        return x;
    }

    public  void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public  void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}
