package com.Entities.Static;

import com.Graphics.Assets;
import com.Item.Item;
import com.Main.Handler;
import com.States.GameState_2;
import com.States.State;
import com.States.UndergroundGamestate;
import com.Tile.Tile;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Stair extends StaticEntity {
    public  int c;
    public Stair(Handler handler, float x, float y,int id) {
        super(handler, x, y, Tile.TW+10 , Tile.TH+10 );
        this.c=id;
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
        g.drawImage(Assets.stair1,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);

    }

    @Override
    public void passThrough() {
        addToFile(c);
        State.setState(new UndergroundGamestate(handler));

    }

    public void addToFile(int c){
        BufferedWriter output = null;
        try {
            File file = new File("E:\\Game-01\\res\\world\\example.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(""+c);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
