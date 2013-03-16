package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import swing.action.JPararMP3Action;
import swing.action.JSairMenuAction;
import swing.action.JSobreMenuAction;
import swing.action.JTocarMP3Action;

public class Tocador{
	
	public static final String PRINCIPAL = "BOTOES";
	public static final String PRINCIPAL2 = "LISTA";
	private static final String ABRIR = "Abrir";
	private static final String PLAY = "Play";
	private static final String STOP = "Stop";
	
	private static final String[] coluna = new String[] {"Música"};
	
	private static void tela() {
		
		JFrame frame = new JFrame("S.T.A.R. PLAYER");
        
        JPanel principalBotoes = new JPanel();
        JPanel principalLista = new JPanel();
        JPanel botoes = new JPanel(new GridLayout(1,4,10,0));
        JPanel lista = new JPanel(new GridLayout(1,1));   
        
        JTable playlist = new JTable();
        DefaultTableModel exibir = new DefaultTableModel();
        JScrollPane scrollpane = new JScrollPane();
		
		scrollpane = new JScrollPane(playlist); 
		scrollpane.setPreferredSize(new Dimension(300,300));
	    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);    
	    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);    
	    exibir.setDataVector(null,coluna);
	    playlist.setModel(exibir);
        
        JButton play = new JButton(new JTocarMP3Action(PLAY,frame));
        play.setPreferredSize(new Dimension(70, 50));

		JButton stop = new JButton(new JPararMP3Action(STOP));
		stop.setPreferredSize(new Dimension(70, 50)); 
		
		JButton next = new JButton("Next");
		next.setPreferredSize(new Dimension(70, 50)); 
		
		JButton previous = new JButton("Prev");
		previous.setPreferredSize(new Dimension(70, 50)); 
				
		botoes.add(previous);
		botoes.add(play);
		botoes.add(stop);
		botoes.add(next);
		principalBotoes.add(botoes, PRINCIPAL);
		lista.add(scrollpane);
		principalLista.add(lista, PRINCIPAL2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("star.png").getImage());
		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(principalLista, BorderLayout.PAGE_START);
		frame.getContentPane().add(principalBotoes,BorderLayout.PAGE_END);		
		
		JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Arquivo");
        menubar.add(file);
        JMenu action = new JMenu("Playlist");
        menubar.add(action);
        JMenu help = new JMenu("Ajuda");
        menubar.add(help);
		frame.setJMenuBar(menubar);
        
        Action abrirAction = new JTocarMP3Action(ABRIR, frame);
		file.add(abrirAction);		
		Action sobreAction = new JSobreMenuAction(frame);
		help.add(sobreAction);		
		Action sairAction = new JSairMenuAction();
		file.add(sairAction);
		
		frame.setSize(new Dimension(300, 300));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.pack();
        frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tela();
			}
		});
	}
}