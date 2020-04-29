package com.Entities.Creature;

import com.Entities.Entity;
import com.Entities.EntityManager;
import com.Graphics.Animation;
import com.Graphics.Assets;
import com.Inventory.Inventory;
import com.Main.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Police extends Creature {
    private Animation animDown,animUp,animLeft,animRight;
    private Inventory inventory;
    private float Speed;
    public Police(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATE_WIDTH,Creature.DEFAULT_CREATE_HEIGHT);
        Speed=1.0f;
        bounds.x=22;
        bounds.y=32;
        bounds.width=20;
        bounds.height=32;
        animDown=new Animation(500, Assets.police_down);
        animUp=new Animation(500,Assets.police_up);
        animLeft=new Animation(500,Assets.police_left);
        animRight=new Animation(500,Assets.police_right);
        inventory=new Inventory(handler);
    }

    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        getInput();
        move();
        checkCollisions();
        inventory.tick();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(),(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }

    @Override
    public void passThrough() {

    }
    private void getInput(){
        xmove=0;
        ymove=0;
        if(inventory.isActive()) return;
        if(handler.getWorld().getEntityManager().getPlayer().getY()>handler.getWorld().getEntityManager().getPolice().getY())
            ymove+=Speed;
        if(handler.getWorld().getEntityManager().getPlayer().getY()<handler.getWorld().getEntityManager().getPolice().getY())
            ymove-=Speed;
        if(handler.getWorld().getEntityManager().getPlayer().getX()<handler.getWorld().getEntityManager().getPolice().getX())
            xmove-=Speed;
       if(handler.getWorld().getEntityManager().getPlayer().getX()>handler.getWorld().getEntityManager().getPolice().getX())
            xmove+=Speed;
       if(handler.getWorld().getEntityManager().getPlayer().getY()==handler.getWorld().getEntityManager().getPolice().getY()) {
           if (handler.getWorld().getEntityManager().getPlayer().getX() == handler.getWorld().getEntityManager().getPolice().getX()) {
               xmove = ymove = 0;
           }
       }


    }

    public void checkCollisions(){
        Rectangle cb=getCollisionBounds(0,0);
        Rectangle ar=new Rectangle();
        int arSize=40;
        ar.width=arSize;
        ar.height=height;
        if(handler.getWorld().getEntityManager().getPlayer().getY()>handler.getWorld().getEntityManager().getPolice().getY()){
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y-arSize;
        }
        if(handler.getWorld().getEntityManager().getPlayer().getY()<handler.getWorld().getEntityManager().getPolice().getY()){
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y+cb.height;
        }
        if(handler.getWorld().getEntityManager().getPlayer().getX()<handler.getWorld().getEntityManager().getPolice().getX()){
            ar.x=cb.x-arSize;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        if(handler.getWorld().getEntityManager().getPlayer().getX()>handler.getWorld().getEntityManager().getPolice().getX()){
            ar.x=cb.x+cb.width/2;
            ar.y=cb.y+cb.height/2-arSize/2;
        }else
            return;
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0).intersects(ar)){
            JOptionPane.showMessageDialog(null,"Police Catches You . You have to surrender\nPlease surrender");
            System.exit(0);
        }
    }
    private BufferedImage getCurrentAnimation(){
        if(xmove <0){
            return animLeft.getCurrentFrame();
        }
        else if(xmove >0){
            return animRight.getCurrentFrame();
        }
        else if(ymove <0){
            return animDown.getCurrentFrame();
        }
        else return animUp.getCurrentFrame();
    }

}
