package com.Entities.Static;

import com.Graphics.Assets;
import com.Main.Handler;
import com.States.GameState_2;
import com.States.State;
import com.Tile.Tile;

import java.awt.*;
import java.io.*;

public class UpStair extends StaticEntity{
    public String s;
    public int id;
    public static int a=200,b=100;
    public UpStair(Handler handler, float x, float y,int id) {
        super(handler, x, y, Tile.TW+10 , Tile.TH+10);
        s=readFile();
        this.id=id;
        bounds.x = 10;
        bounds.y = 20;
        bounds.width = width / 2 + 60;
        bounds.height = height / 2 + 10;
    }
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.upstair,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);

    }

    @Override
    public void passThrough() {
            State.setState(new GameState_2(handler));
            if(id==2){
                GameState_2.getPlayer().setX(a);
                GameState_2.getPlayer().setY(b);
            }
            if(id==1) {
                if (s.equals("1")) {
                    GameState_2.getPlayer().setX(200);
                    GameState_2.getPlayer().setY(600);
                    a=200;b=600;
                }
                if (s.equals("2")) {
                    GameState_2.getPlayer().setX(300);
                    GameState_2.getPlayer().setY(900);
                    a=300;b=900;
                }
                if (s.equals("3")) {
                    GameState_2.getPlayer().setX(200);
                    GameState_2.getPlayer().setY(100);
                    a=200;b=100;
                }
                if (s.equals("4")) {
                    GameState_2.getPlayer().setX(900);
                    GameState_2.getPlayer().setY(600);
                    a=900;b=600;
                }
                if (s.equals("5")) {
                    GameState_2.getPlayer().setX(200);
                    GameState_2.getPlayer().setY(200);
                    a=200;b=200;
                }
                if (s.equals("6")) {
                    GameState_2.getPlayer().setX(900);
                    GameState_2.getPlayer().setY(900);
                    a=900;b=900;
                }
                if (s.equals("7")) {
                    GameState_2.getPlayer().setX(900);
                    GameState_2.getPlayer().setY(600);
                    a=900;b=600;
                }
                if (s.equals("8")) {
                    GameState_2.getPlayer().setX(200);
                    GameState_2.getPlayer().setY(600);
                    a=200;b=600;
                }
                if (s.equals("9")) {
                    GameState_2.getPlayer().setX(900);
                    GameState_2.getPlayer().setY(900);
                    a=900;b=900;
                }
                if (s.equals("10")) {
                    GameState_2.getPlayer().setX(900);
                    GameState_2.getPlayer().setY(600);
                    a=900;b=600;
                }
                if (s.equals("11")) {
                    GameState_2.getPlayer().setX(900);
                    GameState_2.getPlayer().setY(270);
                    a=900;b=245;
                }
                if (s.equals("12")) {
                    GameState_2.getPlayer().setX(300);
                    GameState_2.getPlayer().setY(600);
                    a=300;b=600;
                }
            }


    }
    public String  readFile(){
        File file = new File("E:\\Game-01\\res\\world\\example.txt");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                return st;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
