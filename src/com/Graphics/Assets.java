package com.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static int width=50;
    private static float height=51.25f;
    public static Font font28;
    public static BufferedImage grass,rock,tree,rock1,stone,TWood,SRock,dimension,tower,image,cave;
    public static BufferedImage[] player_down,player_up,player_left,player_right,police_down,police_up,police_left,police_right;
    public static BufferedImage[] button,button1,loadImage,exit;
    public static BufferedImage coin,coin_1,value1,value2,value3,value4,value5,value6,coin_2,c1,c2,c3,c4,c5,c6,c7;
    public static BufferedImage inventoryScreen,stair1,stair2,black,dart,upstair,guard,bag,maze;
    public static void init(){
        exit=new BufferedImage[2];
        Spritesheet Exit=new Spritesheet(ImageLoader.loadImage("/texture/exit.png"));
        exit[0]=Exit.crop(0,0,302,80);
        exit[1]=Exit.crop(0,82,302,82);

        Spritesheet Maze=new Spritesheet(ImageLoader.loadImage("/texture/maze.png"));
        maze=Maze.crop(0,0,355,355);

        Spritesheet C1=new Spritesheet(ImageLoader.loadImage("/texture/c1.png"));
        c1=C1.crop(0,0,700,800);
        Spritesheet C2=new Spritesheet(ImageLoader.loadImage("/texture/c2.png"));
        c2=C2.crop(0,0,700,800);
        Spritesheet C3=new Spritesheet(ImageLoader.loadImage("/texture/c3.png"));
        c3=C3.crop(0,0,700,800);
        Spritesheet C4=new Spritesheet(ImageLoader.loadImage("/texture/c4.png"));
        c4=C4.crop(0,0,700,800);
        Spritesheet C5=new Spritesheet(ImageLoader.loadImage("/texture/c5.png"));
        c5=C5.crop(0,0,700,800);
        Spritesheet C6=new Spritesheet(ImageLoader.loadImage("/texture/c6.png"));
        c6=C6.crop(0,0,700,800);
        Spritesheet C7=new Spritesheet(ImageLoader.loadImage("/texture/c7.png"));
        c7=C7.crop(0,0,700,800);




        Spritesheet G=new Spritesheet(ImageLoader.loadImage("/texture/guard.png"));
        guard=G.crop(0,0,34,36);

        Spritesheet B=new Spritesheet(ImageLoader.loadImage("/texture/bag.png"));
        bag=B.crop(0,0,59,62);

        Spritesheet Coin2=new Spritesheet(ImageLoader.loadImage("/texture/gem3.png"));
        coin_2=Coin2.crop(0,0,553,553);
        Spritesheet UpStair=new Spritesheet(ImageLoader.loadImage("/upStair.png"));
        upstair=UpStair.crop(0,0,95,147);
        Spritesheet Dart=new Spritesheet(ImageLoader.loadImage("/texture/dart.png"));
        dart=Dart.crop(0,0,225,225);
        Spritesheet blac=new Spritesheet(ImageLoader.loadImage("/texture/black.png"));
        black=blac.crop(0,0,599,418);
        Spritesheet S1=new Spritesheet(ImageLoader.loadImage("/pokemon-stair.png"));
        stair1=S1.crop(0,0,122,167);
        Spritesheet S2=new Spritesheet(ImageLoader.loadImage("/pokemon-stair-1.png"));
        stair2=S2.crop(0,0,105,140);

        Spritesheet V1=new Spritesheet(ImageLoader.loadImage("/texture/value1.png"));
        value1=V1.crop(0,0,500,500);
        Spritesheet V2=new Spritesheet(ImageLoader.loadImage("/texture/value2.png"));
        value2=V2.crop(0,0,500,500);
        Spritesheet V3=new Spritesheet(ImageLoader.loadImage("/texture/value3.png"));
        value3=V3.crop(0,0,500,500);
        Spritesheet V4=new Spritesheet(ImageLoader.loadImage("/texture/value4.png"));
        value4=V4.crop(0,0,500,500);
        Spritesheet V5=new Spritesheet(ImageLoader.loadImage("/texture/value5.png"));
        value5=V5.crop(0,0,500,500);
        Spritesheet V6=new Spritesheet(ImageLoader.loadImage("/texture/value6.png"));
        value6=V6.crop(0,0,500,500);
        Spritesheet Coin1=new Spritesheet(ImageLoader.loadImage("/texture/gem2.png"));
        coin_1=Coin1.crop(0,0,581,586);
        police_up=new BufferedImage[4];
        police_down=new BufferedImage[4];
        police_left=new BufferedImage[4];
        police_right=new BufferedImage[4];
        Spritesheet police=new Spritesheet(ImageLoader.loadImage("/texture/police.png"));
        for(int i=0;i<4;i++) {
            police_up[i] = police.crop(64*i, 0, 64,82);
        }
        for(int i=0;i<4;i++) {
            police_left[i] = police.crop(64*i, 82, 64,82);
        }
        for(int i=0;i<4;i++) {
            police_right[i] = police.crop(64*i, 82*2, 64, 82);
        }
        for(int i=0;i<4;i++) {
            police_down[i] = police.crop(64*i, 82*3, 64,82);
        }



        Spritesheet c=new Spritesheet(ImageLoader.loadImage("/texture/cave.png"));
        cave=c.crop(0,0,771,490);
        Spritesheet im=new Spritesheet(ImageLoader.loadImage("/images/untitle.jpg"));
        image=im.crop(0,0,800,596);
        loadImage=new BufferedImage[1];
        Spritesheet img=new Spritesheet(ImageLoader.loadImage("/images/loadgame.jpg"));
        loadImage[0]=img.crop(0,0,200,45);
        Spritesheet Tower=new Spritesheet(ImageLoader.loadImage("/images/Towers-of-Hanoi.png"));
        tower=Tower.crop(0,0,548,548);

        Spritesheet Coin=new Spritesheet(ImageLoader.loadImage("/texture/gem1.png"));
        coin=Coin.crop(0,0,521,512);
        Spritesheet D=new Spritesheet(ImageLoader.loadImage("/texture/door.png"));
        dimension=D.crop(0,0,64,64);
        font28=FontLoader.loadFont("res/fonts/slkscr.ttf",28);
        inventoryScreen=ImageLoader.loadImage("/texture/inventoryScreen.png");
        Spritesheet a=new Spritesheet(ImageLoader.loadImage("/texture/wood-1.png"));
        TWood=a.crop(0,0,52,74);
        Spritesheet b=new Spritesheet(ImageLoader.loadImage("/texture/small-rock.png"));
        SRock=b.crop(0,0,100,100);
        Spritesheet wood=new Spritesheet(ImageLoader.loadImage("/texture/wood.png"));
        stone=wood.crop(0,0,107,111);
        Spritesheet btn=new Spritesheet(ImageLoader.loadImage("/texture/button.png"));
        button=new BufferedImage[2];
        button[0]=btn.crop(0,0,302,82);
        button[1]=btn.crop(0,82,302,82);
        button1=new BufferedImage[2];
        button1[0]=btn.crop(0,0,302,82);
        button1[1]=btn.crop(0,82,302,82);
        Spritesheet sheet=new Spritesheet(ImageLoader.loadImage("/texture/player.png"));
        player_down=new BufferedImage[5];
        player_up=new BufferedImage[5];
        player_left=new BufferedImage[5];
        player_right=new BufferedImage[5];

        for(int i=0;i<5;i++) {
            player_up[i] = sheet.crop(width*i, 0, width, (int)height);
        }
        for(int i=0;i<5;i++) {
            player_down[i] = sheet.crop(width*i, (int)height, width,(int) height);
        }
        for(int i=0;i<5;i++) {
            player_right[i] = sheet.crop(width*i, (int)height*2, width, (int)height);
        }
        for(int i=0;i<5;i++) {
            player_left[i] = sheet.crop(width*i, (int)height*3, width,(int) height);
        }

        Spritesheet Grass=new Spritesheet(ImageLoader.loadImage("/texture/grass.png"));
        Spritesheet Rock=new Spritesheet(ImageLoader.loadImage("/texture/rock.png"));
        Spritesheet Rock1=new Spritesheet(ImageLoader.loadImage("/texture/rock-1.png"));
        Spritesheet Tree=new Spritesheet(ImageLoader.loadImage("/texture/tree.png"));
        grass=Grass.crop(0,0,250,250);
        rock=Rock.crop(0,0,71,71);
        rock1=Rock1.crop(0,0,71,71);
        tree=Tree.crop(0,0,250,250);

    }
}
