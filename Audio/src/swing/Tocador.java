package swing;

import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import swing.action.JAbrirMP3Action;
import swing.action.JPararMP3Action;
import swing.action.JSairMenuAction;
import swing.action.JSobreMenuAction;
import swing.action.JTocarMP3Action;

public class Tocador{
	
	private static final String ABRIR = "Abrir";
	private static final String PLAY = "Play";
	private static final String STOP = "Stop";
	
	private static void tela() {
		
		JFrame frame = new JFrame("S.T.A.R. PLAYER");
		
        frame.setLayout(null);
        JButton play = new JButton(new JTocarMP3Action(PLAY,frame));
        play.setBounds(30,100,100,50);
        frame.add(play);
        
        frame.setLayout(null);
		JButton stop = new JButton(new JPararMP3Action(STOP));
		stop.setBounds(160,100,100,50);  
		frame.add(stop);
		
		frame.setMinimumSize(new Dimension(300,300));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("star.png").getImage());
		
		JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Arquivo");
        menubar.add(file);
        JMenu action = new JMenu("Playlist");
        menubar.add(action);
        JMenu help = new JMenu("Ajuda");
        menubar.add(help);
		frame.setJMenuBar(menubar);
		
        frame.pack();
        frame.setVisible(true);
        
        Action abrirAction = new JAbrirMP3Action(ABRIR, frame);
		file.add(abrirAction);
		
		Action sobreAction = new JSobreMenuAction(frame);
		help.add(sobreAction);
		
		Action sairAction = new JSairMenuAction();
		file.add(sairAction);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tela();
			}
		});
	}
}