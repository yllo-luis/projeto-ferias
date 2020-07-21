package br.ucsal.pratica.yllo.controllers;

import br.ucsal.pratica.yllo.Exception.PlayListException;
import br.ucsal.pratica.yllo.domain.PlayList;
import br.ucsal.pratica.yllo.domain.Musica;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.InputStream;

public class PlayListReproductionController {
	
	public static void tocarPlayList(Integer cod) { 
		try { 
			PlayList playlist = PlayListDAOController.procurarPlaylist(cod);
			for (Musica musica : playlist.getMusicas()) {
				InputStream input = new FileInputStream(new File(musica.getMusica()));
				Player player = new Player(input);
				System.out.println(musica);
				player.play();
			}
		} catch(PlayListException | JavaLayerException | FileNotFoundException e) { 
			System.out.println(e.getMessage());
		}
	}	
}
