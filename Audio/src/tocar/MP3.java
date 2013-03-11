package tocar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import javazoom.jl.decoder.Control;

public class MP3{

	private File mp3;
	private Player player;

	public MP3(File mp3) {
		this.mp3 = mp3;
	}

	public void play() {
		try {
			FileInputStream fis = new FileInputStream(mp3);
			BufferedInputStream bis = new BufferedInputStream(fis);
			this.player = new Player(bis);
		} catch (Exception e) {
			System.out.println("Problema ao tocar " + mp3);
			e.printStackTrace();
		}
		
		new Thread() {
			public void run() {
				try {
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();

		/*boolean status = true;

		while (!this.player.isComplete() && status) {
			System.out.println(this.player.getPosition());

			// simulação do stop, talvez skip
			if (this.player.getPosition() > 1000) {
				this.player.close();
				status = false;
			}
		}*/
	}
	
	//não funciona
	public void stop(){
		this.player.close();
	}
}
