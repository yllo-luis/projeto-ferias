package br.ucsal.pratica.yllo.controllers;


import br.ucsal.pratica.yllo.Exception.MusicaException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicReproductionController {	
	
	public static void tocarMusica(Integer codigo) {
		try {
			File arquivoMusica = new File(MusicDAOController.buscaMusica(codigo).getMusica());
			InputStream musica = new FileInputStream(arquivoMusica);
			Player player = new Player(musica);
			player.play();
		} catch (IOException | JavaLayerException | MusicaException e) {
			System.out.println("Falha em playback: " + e.getMessage());
		}
	}
	
}
