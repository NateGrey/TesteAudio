package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class JSobreMenuAction extends AbstractAction {

	private JFrame frame;

	public JSobreMenuAction(JFrame frame) {
		super("Sobre");
		this.frame = frame;
		putValue(SHORT_DESCRIPTION, "Sobre a aplicação.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Mostrar tela com Sobre");
		JOptionPane
				.showMessageDialog(
						frame,
						"STAR MP3 PLAYER\n(c) 2013 Charles Pereira Franco\nchar__86@hotmail.com",
						"Sobre", JOptionPane.INFORMATION_MESSAGE);
	}
}