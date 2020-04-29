package com.Graphics;

import java.awt.image.BufferedImage;

public class Animation {
    public int speed,index;
    public long timer,lastTime;
    private BufferedImage[] frame;
    public Animation(int speed,BufferedImage[] frame){
        this.speed=speed;
        this.frame=frame;
        index=frame.length-2;
        timer=0;
        lastTime=0;
    }
    public void tick(){
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();
        if(timer >speed){
            index--;
            timer=0;
            if(index<=0)
                index=frame.length-2;
        }
    }
    public BufferedImage getCurrentFrame(){
        return frame[index];
    }
    public BufferedImage getFirstFrame(){
        return frame[frame.length-1];
    }
}
