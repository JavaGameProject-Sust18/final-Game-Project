package com.Tower;

import com.Display.Display;
import com.Graphics.Assets;
import com.Main.Handler;
import com.States.GameState;
import com.States.GameState_1;
import com.States.State;
import com.World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameHold extends State implements ActionListener{
	private static JFrame gameFrame = new JFrame();
	public static Handler handler;
	private static World world;
   
    public GameHold(Handler handler) {
        super(handler);
        this.handler=handler;
        world=new World(handler,"res/world/world-2.txt");
        run();
        call(4);
    }

    public static void sevisiblex(){
    	gameFrame.setVisible(false);
    }
    public static void setstate(){
        State.setState(new GameState_1(handler));
    }
    public static void gamestate(){
        State.setState(new GameState(handler));
    }

    public void run(){
        gameFrame.setSize(900, 700);
        gameFrame.dispose();
        gameFrame.setUndecorated(true);
        gameFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);

    } 
   
    public  void call(int level) {
        Tower t =new Tower();
        gameFrame.getContentPane().add(t);
        handler.getGame().getDisplay().getFrame().setVisible(false);
        gameFrame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        //g.drawImage(Assets.grass,0,0,900,700,null);
    }

}