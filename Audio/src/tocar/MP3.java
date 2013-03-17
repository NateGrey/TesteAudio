package tocar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3{

	private File mp3;
	private static Player player;
	private static Thread thread;

	public MP3(){
		
	}
	
	public MP3(File mp3) {
		this.mp3 = mp3;
	}

	@SuppressWarnings("static-access")
	public void play() {
		try {
			FileInputStream fis = new FileInputStream(mp3);
			BufferedInputStream bis = new BufferedInputStream(fis);
			this.player = new Player(bis);
		} catch (Exception e) {
			System.out.println("Problema ao carregar " + mp3);
			e.printStackTrace();
		}
		
		 this.thread = new ThreadPlay(player); 
		 this.thread.start();
	}
	
	@SuppressWarnings("static-access")
	public void stop(){
		if (this.player != null){
			this.player.close();
		}
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void pause() throws InterruptedException{
		this.thread.suspend();
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void resume() throws InterruptedException{
		this.thread.resume();
	}
	
	
	@SuppressWarnings("static-access")
	public Player getPlayer(){
		return this.player;
	}
	
	@SuppressWarnings("static-access")
	public void setPlayer(Player player){
		this.player = player;
	}
}
