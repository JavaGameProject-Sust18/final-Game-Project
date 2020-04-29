package com.States;

import com.Main.Game;
import com.Main.Handler;

import java.awt.*;

public abstract class State {
    private static State currentState=null;
    private static Component currentcomponent=null;
    protected Game game;
    protected Handler handler;
    public State(Handler handler){
        this.handler=handler;
    }
    public static void setState(State state){
        currentState=state;
    }
    public static void setComponent(Component component){
        currentcomponent=component;
    }
    public static State getState(){
        return currentState;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
}
