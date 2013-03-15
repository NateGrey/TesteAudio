package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class JSairMenuAction extends AbstractAction {

	public JSairMenuAction() {
		super("Sair");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Saindo...");
		System.exit(0);
	}
}