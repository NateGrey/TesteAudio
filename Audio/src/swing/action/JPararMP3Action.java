package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import tocar.MP3;

@SuppressWarnings("serial")
public class JPararMP3Action extends AbstractAction {

	private MP3 musica;

	public JPararMP3Action(String nome) {
		super(nome);
		this.musica = new MP3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(musica.getPlayer() != null){
			musica.stop();
			musica.setPlayer(null);
			System.out.println("Parado!");
		}
	}
}
