package swing;

import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import swing.action.JTocarMP3;

public class Tocador{
	
	public static final String PRINCIPAL = "PRINCIPAL";
	
	private static void tela() {
		
		JFrame frame = new JFrame("S.T.A.R");
		
        frame.setLayout(null);
        JButton play = new JButton("Play");
        play.setBounds(20,100,100,50);  
        frame.add(play);
        frame.setLayout(null);
		JButton stop = new JButton("Stop");
		stop.setBounds(150,100,100,50);  
		frame.add(stop);
		
		frame.setMinimumSize(new Dimension(300,300));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("star.png").getImage());
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Mídia");
		menubar.add(file);
		frame.setJMenuBar(menubar);
		
        frame.pack();
        frame.setVisible(true);

		Action tocarAction = new JTocarMP3(
				"C:/Users/Charles/Documents/eclipse/Audio/Victory.mp3");
		/*Action tocarAction = new JTocarMP3(
				"C:/Users/Charles/Documents/eclipse/Audio/Oasis - Falling Down.mp3");*/
		file.add(tocarAction);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tela();
			}
		});
	}

}
