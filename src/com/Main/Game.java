package com.Main;

import com.Display.Display;
import com.Graphics.Assets;
import com.Graphics.GameCemera;
import com.Input.KeyManager;
import com.Input.MouseManger;
import com.States.*;
import com.Tower.GameHold;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private Display display;
    public int W,H;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    public State gamestate,gamestate_2,gamehold;
    public State menustate,problemstate;
    private boolean running=false;
    private KeyManager keyManeger;
    private GameCemera gameCemera;
    private MouseManger mouseManger;
    private Handler handler;

    public Game(int W,int H) {
        this.W=W;
        this.H=H;
        keyManeger=new KeyManager();
        mouseManger=new MouseManger();

    }
    private void init(){
        display=new Display(W,H);
        display.getFrame().addKeyListener(keyManeger);
        display.getFrame().addMouseListener(mouseManger);
        display.getFrame().addMouseMotionListener(mouseManger);
        display.getCanvas().addMouseListener(mouseManger);
        display.getCanvas().addMouseMotionListener(mouseManger);
        Assets.init();
        handler=new Handler(this);
        gameCemera=new GameCemera(handler,0,0);
        gamestate=new GameState(handler);
        menustate=new MenuState(handler);
        problemstate=new ProblemState(handler);

        State.setState(menustate);
    }
    private void tick(){
        keyManeger.tick();
       if(State.getState() != null){
           State.getState().tick();
       }

    }
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        g.clearRect(0,0,W,H);
        if(State.getState() != null){
            State.getState().render(g);
        }
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        double fps=60.0;
        double timePertick=1000000000 / fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        int ticks=0;
        while(running){
            now=System.nanoTime();
            delta+=(now-lastTime) / timePertick;
            timer += now-lastTime;
            lastTime=now;
            if(delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >=1000000000){
                //System.out.println("Timer & fps :"+ticks);
                ticks=0;
                timer=0;

            }
        }
        stop();
    }
    public KeyManager getKeyManeger(){
        return keyManeger;
    }
    public MouseManger getMouseManger(){
        return mouseManger;
    }
    public GameCemera getGameCemera(){
        return gameCemera;
    }

    public int getWidth(){
        return W;
    }
    public int getHeight(){
        return H;
    }
    public synchronized void start(){
        if(running) return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running) return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Display getDisplay(){
        return display;
    }

}
