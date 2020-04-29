package com.States;

import com.Entities.Creature.Player;
import com.Entities.EntityManager;
import com.Entities.Static.Dimension;
import com.Entities.Static.Tree;
import com.Graphics.Assets;
import com.Inventory.Inventory;
import com.Item.Item;
import com.Item.ItemManager;
import com.Main.Game;
import com.Main.Handler;
import com.Tile.Tile;
import com.World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameState_1 extends State {
    public int i=0;
    public static JFrame messageframe=new JFrame();
    public JButton button=new JButton("OK");
    private Player player;
    private World world;
    private EntityManager entityManager;
    public GameState_1(Handler handler) {
        super(handler);
        world=new World(handler,"res/world/world-2.txt");
        handler.setWorld(world);
        handler.getWorld().getItemManager().addItem(Item.stone1.createNew(600,120));
        handler.getWorld().getItemManager().addItem(Item.v1.createNew(910,300));
        handler.getWorld().getItemManager().addItem(Item.v2.createNew(600,590));
        handler.getWorld().getItemManager().addItem(Item.v3.createNew(520,900));
        handler.getWorld().getItemManager().addItem(Item.v4.createNew(400,300));
        handler.getWorld().getItemManager().addItem(Item.v5.createNew(600,400));
        handler.getWorld().getItemManager().addItem(Item.v6.createNew(270,600));
        handler.getWorld().getItemManager().addItem(Item.v1.createNew(400,800));


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
        messageframe.add(new JLabel(new ImageIcon("E:\\Game-01\\res\\texture\\spm.png")));
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
