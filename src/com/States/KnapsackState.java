package com.States;


import com.Entities.Creature.Player;
import com.Entities.Static.Dimension;
import com.Entities.Static.Guard;
import com.Item.Item;
import com.Main.Handler;
import com.World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KnapsackState extends State{
    public int k=0;
    public Player player;
    public Dimension dimension;
    private World world;
    public static JFrame messageframe=new JFrame();
    public JButton button=new JButton("OK");
    public KnapsackState(Handler handler) {
        super(handler);
        world=new World(handler,"res/world/world-4.txt");
        handler.setWorld(world);
        player=handler.getWorld().getEntityManager().getPlayer();
        handler.getWorld().getEntityManager().getEntities().removeAll(handler.getWorld().getEntityManager().getEntities());
        handler.getWorld().getEntityManager().addEntity(player);
        handler.getWorld().getEntityManager().addEntity(new Dimension(handler,800,900));
        handler.getWorld().getEntityManager().addEntity(new Guard(handler,740,1030));
        handler.getWorld().getItemManager().addItem(Item.c1.createNew(450,100));
        handler.getWorld().getItemManager().addItem(Item.c2.createNew(460,350));
        handler.getWorld().getItemManager().addItem(Item.c3.createNew(280,530));
        handler.getWorld().getItemManager().addItem(Item.c4.createNew(200,900));
        handler.getWorld().getItemManager().addItem(Item.c5.createNew(400,1060));
        handler.getWorld().getItemManager().addItem(Item.c6.createNew(980,150));
        handler.getWorld().getItemManager().addItem(Item.c7.createNew(980,740));
        MessageFrame();
        messageframe.setVisible(true);
        AddButtonActionListener();



    }

    @Override
    public void tick() {
        world.tick();
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
        messageframe.add(new JLabel(new ImageIcon("E:\\Game-01\\res\\texture\\m.png")));
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
