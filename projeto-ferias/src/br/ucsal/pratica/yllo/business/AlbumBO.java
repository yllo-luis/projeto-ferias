package br.ucsal.pratica.yllo.business;

import br.ucsal.pratica.yllo.domain.Album;
import br.ucsal.pratica.yllo.domain.Musica;

public class AlbumBO {
	
	public static void cadastrarAlbum(String nome, String caminhoMusica, String nomeAlbum, Integer anoLancamento, String nomeGravadora, Musica musica) { 
		Album album = new Album(nome,caminhoMusica,nomeAlbum, anoLancamento,nomeGravadora);  
		album.addMusicas(musica);
	}
	
	public static void tocarAlbum() { 
		//TODO ainda preciso pensar em como isto vai funcionar
	}
	
}
