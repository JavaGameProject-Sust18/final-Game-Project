package com.Entities.Static;

import com.Graphics.Assets;
import com.Main.Handler;
import com.States.State;
import com.Tile.Tile;

import java.awt.*;

public class Stone extends StaticEntity {
    public Stone(Handler handler, float x, float y, int id) {
        super(handler, x, y, Tile.TW , Tile.TH );
        bounds.x = 10;
        bounds.y = 20;
        bounds.width = width / 2 + 60;
        bounds.height = height / 2 + 10;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.coin_2,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }

    @Override
    public void passThrough() {
        System.out.println("picked up");
    }
}
