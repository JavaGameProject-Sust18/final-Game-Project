package com.States;

import com.Entities.Creature.Player;
import com.Item.Item;
import com.Main.Handler;
import com.World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameState extends State {
    public int i=0;
    public static JFrame messageframe=new JFrame();
    public JButton button=new JButton("OK");
    private Player player;
    private World world;
    public GameState(Handler handler) {
        super(handler);
        world=new World(handler,"res/world/world-1.txt");
        handler.setWorld(world);
        handler.getWorld().getItemManager().addItem(Item.stone.createNew(600,120));

    }

    @Override
    public void tick() {
        world.tick();
        if(i==0) {
            MessageFrame();
            messageframe.setVisible(true);
            AddButtonActionListener();
            i++;
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
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
        messageframe.add(new JLabel(new ImageIcon("E:\\Game-01\\res\\texture\\thm.png")));
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
