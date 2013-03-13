package swing.action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;

import tocar.MP3;

@SuppressWarnings("serial")
public class JTocarMP3Action extends AbstractAction {

	private File mp3File;
	private MP3 musica;

	public JTocarMP3Action(String path) {
		super("Play");
		this.mp3File = new File(path);
		this.musica = new MP3(mp3File);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread() {
			public void run() {
				try {
					musica.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();
		
		System.out.println(mp3File.getName());
		System.out.println("Tocando!");
	}
}