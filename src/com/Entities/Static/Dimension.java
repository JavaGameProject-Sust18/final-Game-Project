package com.Entities.Static;

import com.Graphics.Assets;
import com.Inventory.Inventory;
import com.Main.Check;
import com.Main.Handler;
import com.States.*;
import com.Tile.Tile;
import com.Tower.GameHold;
import com.Tower.Tower;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Dimension extends StaticEntity{
    public static   int i=0,j=0;
    public float x,y;
    public Dimension(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TW+68, Tile.TH+105);
        this.x=x;
        this.y=y;
        bounds.x=10;
        bounds.y=60;
        bounds.width=width/2+60;
        bounds.height=height/2+10;
    }

    @Override
    public void tick() {

    }
    @Override
    public void passThrough() {
        if(i==1 && j==0) {
            if (handler.getWorld().getEntityManager().getPlayer().getInventory().getLength() == 5) {
                State.setState(new GameState_2(handler));
                i+=1;
                j+=1;
            } else {
                JOptionPane.showMessageDialog(null,"You have failed");
                System.exit(0);
            }
        }
        else if(i==2 && j==1){
            State.setState(new KnapsackState(handler));
            i++;
            j+=1;
        }
        else if(i==3 && j==2){
            if(handler.getWorld().getItemManager().getP()==57 && handler.getWorld().getItemManager().getW()==16){
                System.out.println("You Can Pass Through");
            }
            else if(handler.getWorld().getItemManager().getW()>16){
                System.out.println("Over Weight !");
            }
            else if(handler.getWorld().getItemManager().getW()<16){
                System.out.println("Less Weight and profit is not maximized..");
            }
            i++;
        }
        else if(i==0 && j==0) {
            State.setState(handler.getGame().problemstate);
            i += 1;
        }
        System.out.println(i);


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.dimension,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public static void setI(int i) {
        Dimension.i = i;
    }
}
