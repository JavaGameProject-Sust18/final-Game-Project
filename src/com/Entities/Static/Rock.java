package com.Entities.Static;
import com.Graphics.Assets;
import com.Item.Item;
import com.Main.Handler;
import com.Tile.Tile;

import java.awt.*;

public class Rock extends StaticEntity{
    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TW, Tile.TH+12);
        bounds.x=3;
        bounds.y=(int)(height/2f);
        bounds.width=width-6;
        bounds.height=(int)(height-height/2f);
    }

    @Override
    public void tick() {

    }
    @Override
    public void passThrough() {
        handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int)x,(int)y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.stone,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }
}
