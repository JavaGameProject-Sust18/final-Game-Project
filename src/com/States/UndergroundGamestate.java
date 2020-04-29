package com.States;

import com.Entities.Creature.Player;
import com.Entities.EntityManager;
import com.Entities.Static.Stone;
import com.Entities.Static.UpStair;
import com.Graphics.Assets;
import com.Item.Item;
import com.Main.Handler;
import com.World.World;

import java.awt.*;
import java.io.*;

public class UndergroundGamestate extends State{
    public static int h=0;
    public Player player;
    private World world;
    private EntityManager entityManager;
    public UndergroundGamestate(Handler handler) {
        super(handler);
        world=new World(handler,"res/world/world-3.1.txt");
        handler.setWorld(world);
        player=handler.getWorld().getEntityManager().getPlayer();
        player.setX(700);
        player.setY(1000);
        handler.getWorld().getEntityManager().getEntities().removeAll(handler.getWorld().getEntityManager().getEntities());
        handler.getWorld().getEntityManager().addEntity(player);
        handler.getWorld().getEntityManager().addEntity(new UpStair(handler,820,180,1));
        handler.getWorld().getEntityManager().addEntity(new UpStair(handler,820,1000,2));
        if(readFile().equals("1") && h==0){
            handler.getWorld().getItemManager().addItem(Item.stone2.createNew(500,500));
            h+=1;
        }

    }

    @Override
    public void tick() {
        world.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);

    }
    public String  readFile(){
        File file = new File("E:\\Game-01\\res\\world\\example.txt");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                return st;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
