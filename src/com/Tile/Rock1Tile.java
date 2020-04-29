package com.Tile;


import com.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Rock1Tile extends Tile {
    public Rock1Tile(int id) {
        super(Assets.rock1, id);
    }
    @Override
    public boolean isSolid(){
      return true;
    }
}