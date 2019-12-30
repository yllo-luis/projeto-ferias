package br.ucsal.pratica.yllo.business;

import br.ucsal.pratica.yllo.Exception.MusicaNaoEncontradaException;
import br.ucsal.pratica.yllo.domain.Album;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.AlbumDAO;

public class AlbumBO {
	
	public static void cadastrarAlbum(String nome, String caminhoMusica, String nomeAlbum, Integer anoLancamento, String nomeGravadora, Musica musica) { 
		Album album = new Album(nome,caminhoMusica,nomeAlbum, anoLancamento,nomeGravadora);  
		album.addMusicas(musica);
	}
	
	
	public static void removerAlbum(Integer cod) throws MusicaNaoEncontradaException { 
		AlbumDAO.removerAlbum(cod);
	}
	
	public static void tocarAlbum() { 
		//TODO ainda preciso pensar em como isto vai funcionar
	}
	
}
