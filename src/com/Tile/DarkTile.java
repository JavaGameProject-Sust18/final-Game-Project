package com.Tile;

import com.Graphics.Assets;
import com.Tile.Tile;

import java.awt.image.BufferedImage;

public class DarkTile extends Tile {
    public DarkTile(int id) {
        super(Assets.black, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}