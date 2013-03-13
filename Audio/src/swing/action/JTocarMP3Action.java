package swing.action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;

import tocar.MP3;

@SuppressWarnings("serial")
public class JTocarMP3Action extends AbstractAction {

	private File mp3File;
	private MP3 musica;

	public JTocarMP3Action() {
		super("Play");
	}
	
	private MP3 criarMP3(){
		this.mp3File = new File("Oasis - Falling Down.mp3");
		this.musica = new MP3(mp3File);
		
		return this.musica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread() {
			public void run() {
				try {
					criarMP3().play();
					System.out.println(mp3File.getName());
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();
		System.out.println("Tocando!");
	}
}