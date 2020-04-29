package com.Input;

import com.Tile.ui.UiManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManger implements MouseMotionListener, MouseListener {
    public boolean leftPressed,rightPressed;
    private int mouseX,mouseY,pointX,pointY;
    private UiManager uiManager;
    public Point p1,p;
    public int sX, sY ,sA,sB,curX=500, curY=500,curA=600,curB=500;
    public Rectangle b,c;

    public MouseManger() {

    }
    public void setUiManager(UiManager uiManager){
        this.uiManager=uiManager;

    }
    public boolean isLeftPressed(){
        return leftPressed;
    }
    public boolean isRightPressed(){
        return rightPressed;
    }


    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        p1=e.getPoint();

        if(e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed=true;
    }


    @Override
    public void mouseReleased(MouseEvent e) {

        if(e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;

        }
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed=false;
        if(uiManager !=null)
            uiManager.onMouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        p=e.getPoint();
        mouseX=e.getX();
        mouseY=e.getY();
        if(uiManager !=null)
            uiManager.onMouseMove(e);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP() {
        return p;
    }

    public UiManager getUiManager() {
        return uiManager;
    }
}
