package swing;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import swing.action.JTocarMP3;

@SuppressWarnings("serial")
public class Tocador extends JFrame {

	public Tocador() {
		super("S.T.A.R");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        setIconImage(new ImageIcon("star.png").getImage());

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Midia");
		menubar.add(file);
		setJMenuBar(menubar);

		/*Action tocarAction = new JTocarMP3(
				"C:/Users/Charles/Documents/eclipse/Audio/Victory.mp3");*/
		Action tocarAction = new JTocarMP3(
				"C:/Users/Charles/Documents/eclipse/Audio/Oasis - Falling Down.mp3");
		file.add(tocarAction);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Tocador play = new Tocador();
				play.setVisible(true);
			}
		});
	}

}
