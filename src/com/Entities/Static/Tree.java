package com.Entities.Static;

import com.Graphics.Assets;
import com.Item.Item;
import com.Main.Handler;
import com.Tile.Tile;
import java.awt.*;

public class Tree extends StaticEntity{
    public Rectangle r;
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TW+50, Tile.TH*2);
        bounds.x=Tile.TW/2;
        bounds.y=(int)(Tile.TH);
        bounds.width=width-width/2;
        bounds.height=(int)(height-height/1.5f);
    }

    @Override
    public void tick() {


    }
    @Override
    public void passThrough() {
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x,(int)y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }

}
