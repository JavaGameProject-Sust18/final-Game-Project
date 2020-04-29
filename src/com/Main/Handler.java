package com.Main;

import com.Graphics.GameCemera;
import com.Input.KeyManager;
import com.Input.MouseManger;
import com.World.World;

public class Handler {
    private Game game;
    private World world;
    public Handler(Game game) {
        this.game=game;
    }
    public GameCemera getGameCemera(){
        return game.getGameCemera();
    }
    public KeyManager getKeyManeger(){
        return game.getKeyManeger();
    }
    public MouseManger getMouseManager(){
        return game.getMouseManger();
    }
    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
