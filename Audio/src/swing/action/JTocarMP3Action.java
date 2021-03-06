package swing.action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;

import tocar.FileChooser;
import tocar.MP3;

@SuppressWarnings("serial")
public class JTocarMP3Action extends AbstractAction {

	private File mp3;
	private MP3 musica;
	private JFrame frame;
	private FileChooser arquivoMP3;
	private String nome;
	private static String status;

	public JTocarMP3Action(String nome, JFrame frame) {
		super(nome);
		this.frame = frame;
		this.musica = new MP3();
		this.musica.setPlayer(null);
		this.nome = nome;
	}

	private MP3 criarMP3(String caminho) {
		this.mp3 = new File(caminho);
		this.musica = new MP3(mp3);

		return this.musica;
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (this.musica.getPlayer() == null
				|| this.musica.getPlayer().isComplete() || this.nome == "Abrir") {
			new Thread() {
				public void run() {
					try {
						arquivoMP3 = new FileChooser();
						String path = arquivoMP3.criarFileChooser(frame);
						if (path.endsWith(".mp3")) {
							if (nome == "Abrir") {
								musica.stop();
								musica.setPlayer(null);
							}
							criarMP3(path).play();
							status = "tocando";
							System.out.println(mp3.getName());
							System.out.println("Tocando!");
						} else {
							if (!path.isEmpty()) {
								JOptionPane.showMessageDialog(frame,
										"Arquivo N�o Suportado", "Erro ao Abrir Arquivo",
										JOptionPane.ERROR_MESSAGE);
								System.out.println("Arquivo Inv�lido!");
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}.start();
		} else {
			try {
				if (this.status == "tocando") {
					this.musica.pause();
					this.status = "parado";
					System.out.println("Pause!");
				} else {
					this.musica.resume();
					this.status = "tocando";
					System.out.println("Resume!");
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}