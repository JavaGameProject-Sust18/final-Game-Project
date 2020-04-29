package com.Main;

import com.States.State;

import java.awt.*;

public class Check extends State {
    private boolean solved;
    public Check(Handler handler){
        super(handler);

    }

    public boolean issolved() {
        return solved;
    }

    public void setsolved(boolean solved) {
        this.solved = solved;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
