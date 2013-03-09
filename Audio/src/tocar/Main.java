package tocar;

import java.io.File;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //String com o caminho do arquivo MP3 a ser tocado
		//String path = "C:/Musicas/Victory.mp3"; 
		String path = "C:/Users/Charles/Documents/eclipse/Audio/Victory.mp3";
		//String path = "D:/Victory.mp3"; 
	    //Instanciação de um objeto File com o arquivo MP3
	    File mp3File = new File(path);
	    //Instanciação do Objeto MP3, a qual criamos a classe.
	    MP3 musica = new MP3(mp3File);
	    //Finalmente a chamada do método que toca a música
	    System.out.println(mp3File.getName());
	    musica.play();
	}

}
