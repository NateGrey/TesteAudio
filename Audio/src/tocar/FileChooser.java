package tocar;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser {
	private String path;
	
	public String criarFileChooser(JFrame frame){
		JFileChooser arquivoMP3 = new JFileChooser();
		arquivoMP3.setDialogTitle("Abrir Música");
		arquivoMP3.setFileFilter(new Filtro());
		//arquivoMP3.setCurrentDirectory(mp3File);
		int retorno = arquivoMP3.showOpenDialog(frame);

		if (retorno == JFileChooser.APPROVE_OPTION) {
			this.path = arquivoMP3.getSelectedFile().getAbsolutePath();
			System.out.println("Abriu!");
			return this.path;
		} else {
			System.out.println("Não abriu/fechou...");
			return "";
		}
	}
}
