package com.States;

import com.Graphics.Assets;
import com.Main.Handler;
import com.Tile.ui.ClickListener;
import com.Tile.ui.UiImageButton;
import com.Tile.ui.UiManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MenuState extends State{
    private UiManager uiManager;
    public Rectangle r,a;
    public boolean hovering=false,h1=false;
    public MenuState(Handler handler) {
        super(handler);
        r=new Rectangle(400,450,200,70);
        a=new Rectangle(400,550,200,70);

    }

    @Override
    public void tick() {
        if(handler.getMouseManager().getP1()==null || handler.getMouseManager().getP()==null) return;
        if(r.contains(handler.getMouseManager().getP1())){
            State.setState(handler.getGame().gamestate);
            handler.getMouseManager().setUiManager(handler.getMouseManager().getUiManager());
        }
        if(a.contains(handler.getMouseManager().getP1())){
            System.exit(0);
        }


        if(r.contains(handler.getMouseManager().getP()))
            hovering=true;
        else hovering=false;
        if(a.contains(handler.getMouseManager().getP()))
            h1=true;
        else h1=false;



    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.maze,0,0,1100,900,null);
        if(hovering)
            g.drawImage(Assets.button[1],400,450,200,70,null);
        else
            g.drawImage(Assets.button[0],400,450,200,70,null);
        if(h1)
            g.drawImage(Assets.exit[1],400,550,200,70,null);
        else
            g.drawImage(Assets.exit[0],400,550,200,70,null);
    }


}
