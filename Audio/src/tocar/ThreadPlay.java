package tocar;

import javazoom.jl.player.Player;

public class ThreadPlay extends Thread{
	
	private Player player;
	
	public ThreadPlay(Player player){
		this.player = player;
	}
	
	public void run(){
		try {
			this.player.play();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
