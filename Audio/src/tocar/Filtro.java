package tocar;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Filtro extends FileFilter  {

	@Override
	public boolean accept(File file) {
		String descricao = file.getName().toUpperCase();
        
		if (descricao.endsWith(".MP3") || file.isDirectory()) {
            return true;
        } else {
            return false;   
        }
	}

	@Override
	public String getDescription() {	
		return "Arquivo de Áudio (*.mp3)";
	}

}
