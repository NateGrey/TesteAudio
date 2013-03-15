package swing.action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;

import tocar.FileChooser;
import tocar.MP3;

@SuppressWarnings("serial")
public class JTocarMP3Action extends AbstractAction  {

	private File mp3File;
	private MP3 musica;
	private JFrame frame; 
	private FileChooser arquivoMP3;
	private String nome;

	public JTocarMP3Action(String nome,JFrame frame) {
		super(nome);
		this.frame = frame;
		this.musica = new MP3();
		this.musica.setPlayer(null);
		this.nome = nome;
	}

	private MP3 criarMP3(String path) {
		this.mp3File = new File(path);
		this.musica = new MP3(mp3File);

		return this.musica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.nome == "Abrir"){
			this.musica.stop();
			this.musica.setPlayer(null);
		}
			
		if (this.musica.getPlayer() == null || this.musica.getPlayer().isComplete()) {
			new Thread() {
				public void run() {
					try {
						arquivoMP3 = new FileChooser();
						String path = arquivoMP3.criarFileChooser(frame);
						if (path.endsWith(".mp3")){
							criarMP3(path).play();
							System.out.println(mp3File.getName());
							System.out.println("Tocando!");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}.start();
		} else
			System.out.println("futuro pause, maybe...");
	}
}