package com.Entities;

import com.Entities.Creature.Player;
import com.Entities.Creature.Police;
import com.Entities.Static.Dimension;
import com.Graphics.Assets;
import com.Main.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    private Handler handler;
    public int x=740,y=800;
    private Player player;
    private Police police,police1,police2;
    private Dimension dimension;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter=new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY()+a.getHeight() <b.getY()+b.getHeight())
                return -1;
            return 1;
        }
    };
    public EntityManager(Handler handler,Player player,Police police,Police police1) {
        this.handler=handler;
        this.player=player;
        this.police=police;
        this.police1=police1;
        entities=new ArrayList<>();
        dimension=new Dimension(handler,x,y);
        addEntity(player);
        addEntity(police);
        addEntity(police1);
    }
    public void tick(){
        Iterator<Entity> it=entities.iterator();
        while(it.hasNext()){
            Entity e=it.next();
            e.tick();
            //if(!e.isActivate()) {
               // it.remove();
            //}
        }
        entities.sort(renderSorter);
    }
    public void render(Graphics g){
        for(Entity e:entities){
            e.render(g);
        }
        player.postRender(g);
    }
    public void addEntity(Entity e){
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public  Player getPlayer() {
        return player;
    }
    public Police getPolice() {
        return police;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
