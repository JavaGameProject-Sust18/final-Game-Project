package com.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    public boolean[] key,justPressed,canPressed;
    public boolean up,down,left,right;
    public boolean hup,hdown,hleft,hright;

    public KeyManager() {
        key=new boolean[256];
        justPressed=new boolean[key.length];
        canPressed=new boolean[key.length];
    }
    public void tick(){
        for(int i=0;i<key.length;i++){
            if(canPressed[i] && !key[i]){
                canPressed[i]=false;
            }else if(justPressed[i]){
                canPressed[i]=true;
                justPressed[i]=false;
            }
            if(!canPressed[i] && key[i])
                justPressed[i]=true;
        }

        up=key[KeyEvent.VK_UP];
        down=key[KeyEvent.VK_DOWN];
        left=key[KeyEvent.VK_LEFT];
        right=key[KeyEvent.VK_RIGHT];
        hup=key[KeyEvent.VK_S];
        hdown=key[KeyEvent.VK_S];
        hleft=key[KeyEvent.VK_S];
        hright=key[KeyEvent.VK_S];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() <0 || e.getKeyCode() >= key.length)
            return;
        key[e.getKeyCode()]=true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() <0 || e.getKeyCode() >= key.length)
            return;
        key[e.getKeyCode()]=false;
    }
}
