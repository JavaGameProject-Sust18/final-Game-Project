package com.Tower;



import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class GameMain {
    public static AudioInputStream audioInputStream;
	public static Clip clip;
	public static void start() {
		music();
	}

	public static void music(){
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Game-01\\res\\sounds\\sio.wav").getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
		    clip.start();
		    clip.loop(Clip.LOOP_CONTINUOUSLY);
		    
	
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void buttonmusic(){
		try {
			AudioInputStream input = AudioSystem.getAudioInputStream(new File("E:\\Game-01\\res\\sounds\\button17.wav").getAbsoluteFile());
	        Clip c = AudioSystem.getClip();
	        c.open(input);
		    c.start();
	
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void buttonsuccess(){
		try {
			AudioInputStream input = AudioSystem.getAudioInputStream(new File("E:\\Game-01\\res\\sounds\\success.wav").getAbsoluteFile());
	        Clip c = AudioSystem.getClip();
	        c.open(input);
		    c.start();
	
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void buttonfail(){
		try {
			AudioInputStream input = AudioSystem.getAudioInputStream(new File("E:\\Game-01\\res\\sounds\\fail.wav").getAbsoluteFile());
	        Clip c = AudioSystem.getClip();
	        c.open(input);
		    c.start();
	
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}