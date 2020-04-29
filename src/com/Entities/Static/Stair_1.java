package com.Entities.Static;

import com.Graphics.Assets;
import com.Main.Handler;
import com.Tile.Tile;

import javax.swing.*;
import java.awt.*;

public class Stair_1 extends StaticEntity {
    public Stair_1(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TW+5 , Tile.TH+5 );
        bounds.x=10;
        bounds.y=20;
        bounds.width=width-6;
        bounds.height=height-6;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.stair2,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
        g.setColor(Color.red);
        g.fillRect((int)(x+bounds.x-handler.getGameCemera().getxOffset()),(int)(y+bounds.y-handler.getGameCemera().getyOffset()),bounds.width,bounds.height);



    }

    @Override
    public void passThrough() {
        JOptionPane.showMessageDialog(null,"You are infront of Stair-1");
        System.exit(0);

    }
}

