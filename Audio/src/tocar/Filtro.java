package tocar;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Filtro extends FileFilter  {

	@Override
	public boolean accept(File f) {
		String descricao = f.getName().toUpperCase();
        
		if (descricao.endsWith(".MP3") || f.isDirectory()) {
            return true;
        } else {
            return false;   
        }
	}

	@Override
	public String getDescription() {	
		return ".mp3";
	}

}
