package tocar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3 {
	/**
	   * Objeto para nosso arquivo MP3 a ser tocado
	   */
	  private File mp3;
	  /**
	   * Objeto Player da biblioteca jLayer. Ele tocará o arquivo
	   * MP3
	   */
	  private Player player;
	  /**
	   * Construtor que recebe o objeto File referenciando o arquivo
	   * MP3 a ser tocado e atribui ao atributo MP3 da classe.
	   *
	   * @param mp3
	   */
	  public MP3(File mp3) {
	    this.mp3 = mp3;
	  }
	  /**
	   * Método que toca o MP3
	   */
	  public void play() {
	      try {
	                FileInputStream fis = new FileInputStream(mp3);
	                BufferedInputStream bis = new BufferedInputStream(fis);
	                this.player = new Player(bis);
	                /*System.out.println("Tocando!");
	                this.player.play();
	                
	                while(!this.player.isComplete())
	                	System.out.println(this.player.getPosition());
	                
	                if (this.player.isComplete())
	                	System.out.println("Terminado!");*/
	            }
	            catch (Exception e) {
	                System.out.println("Problema ao tocar " + mp3);
	                e.printStackTrace();
	            }
	      
	      new Thread() {
	            public void run() {
	                try { player.play(); }
	                catch (Exception e) { System.out.println(e); }
	            }
	        }.start();
	        
	        boolean status = true;
	        
	        while(!this.player.isComplete() && status){
            	System.out.println(this.player.getPosition());
            	
            	//simulação do stop, talvez skip
	        	if (this.player.getPosition() > 1000){
	        		this.player.close();
	        		status = false;
	        	}
	        }
	     }
}
