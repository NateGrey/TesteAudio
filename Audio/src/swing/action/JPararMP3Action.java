package swing.action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;

import tocar.MP3;

@SuppressWarnings("serial")
public class JPararMP3Action extends AbstractAction {

	private File mp3File;
	private MP3 musica;

	public JPararMP3Action(String path) {
		super("Stop");
		this.mp3File = new File(path);
		this.musica = new MP3(mp3File);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		musica.stop();
		System.out.println("Parado!");
	}
}
