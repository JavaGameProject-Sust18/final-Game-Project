package com.Entities.Static;

import com.Graphics.Animation;
import com.Graphics.Assets;
import com.Item.Item;
import com.Main.Handler;
import com.Tile.Tile;
import java.awt.*;

public class Coin extends StaticEntity{
    public Coin(Handler handler, float x, float y) {
        super(handler, x, y, 47, 40);
        bounds.x=5;
        bounds.y=10;
        bounds.width=22;
        bounds.height=22;
    }

    @Override
    public void tick() {
        //anim.tick();
    }
    @Override
    public void passThrough() {
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x,(int)y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.coin,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }
}

