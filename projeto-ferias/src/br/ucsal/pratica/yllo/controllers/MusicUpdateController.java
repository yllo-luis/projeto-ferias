package br.ucsal.pratica.yllo.controllers;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.domain.GeneroENUM;
import br.ucsal.pratica.yllo.domain.Musica;



public class MusicUpdateController {
	
	public static void adicionarArtista(Integer codigo, String artista) { 
		try {
			Musica musica = MusicDAOController.buscaMusica(codigo);
			musica.setArtista(artista);
		} catch (MusicaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void atualizarGenero(Integer codigo ,String genero) { 
		try {
			Musica musica = MusicDAOController.buscaMusica(codigo);
			musica.setGenero(GeneroENUM.valueOf(genero.toUpperCase()));
		} catch (MusicaException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
