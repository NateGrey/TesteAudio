package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JAbrirMP3Action extends AbstractAction{
	
	private JFrame frame; 
	
	public JAbrirMP3Action(String nome,JFrame frame){
		super(nome);
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
