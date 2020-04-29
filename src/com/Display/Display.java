package com.Display;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas {
    private int W,H;
    private Canvas canvas;
    public static JFrame frame;
    public Display(int W, int H){
        this.W=W;
        this.H=H;
        createDisplay();
    }

    private void createDisplay() {
        frame=new JFrame();
        frame.setSize(W,H);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(W,H));
        canvas.setMaximumSize(new Dimension(W,H));
        canvas.setMinimumSize(new Dimension(W,H));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);



    }
    public Canvas getCanvas(){
        return canvas;
    }
    public JFrame getFrame(){return frame;}
    public static void vanish(){
        frame.setVisible(false);
    }
    public static void appear(){
        frame.setVisible(true);
    }
}
