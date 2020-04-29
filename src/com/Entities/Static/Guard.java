package com.Entities.Static;

import com.Graphics.Assets;
import com.Item.Item;
import com.Main.Handler;
import com.States.KnapsackState;
import com.States.State;
import com.Tile.Tile;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Guard extends StaticEntity {
    public int i=0;
    public static JFrame messageframe=new JFrame();
    public JButton button=new JButton("OK");
    public Guard(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TW , Tile.TH );
        bounds.x = 5;
        bounds.y = 5;
        bounds.width = width / 2 + 60;
        bounds.height = height / 2 + 10;
        AddButtonActionListener();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.guard,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }

    @Override
    public void passThrough(){
        if(i==0) {
            MessageFrame();
            messageframe.setVisible(true);
            handler.getWorld().getItemManager().addItem(Item.bag.createNew(800, 1100));
            i++;
        }
    }
    public void MessageFrame(){
        button.setBounds(0,0,100,50);
        button.setIcon(new ImageIcon("E:\\Game-01\\res\\texture\\ok.png"));
        JPanel panel =new JPanel();
        panel.setLayout(null);
        panel.setBounds(200,430,100, 50);
        panel.add(button);
        messageframe.setSize(500, 500);
        messageframe.add(panel);
        messageframe.add(new JLabel(new ImageIcon("E:\\Game-01\\res\\texture\\Message.png")));
        messageframe.dispose();
        messageframe.setUndecorated(true);
        messageframe.setBackground(new Color(0,0,0,0));
        messageframe.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        messageframe.setResizable(false);
        messageframe.setLocationRelativeTo(null);
    }
    public void AddButtonActionListener(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageframe.setVisible(false);
            }
        });
    }
}
