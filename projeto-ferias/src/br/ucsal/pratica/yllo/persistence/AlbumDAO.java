package br.ucsal.pratica.yllo.persistence;

import java.util.HashMap;
import java.util.Map;

import br.ucsal.pratica.yllo.Exception.MusicaNaoEncontradaException;
import br.ucsal.pratica.yllo.domain.Album;

public class AlbumDAO {
	private static Map<Integer, Album> albuns = new HashMap<Integer, Album>();
	
	public static void adicionarAlbum(Album album) { 
		albuns.put(Album.getCodAlbum(), album);
	}
	
	public static void removerAlbum(Integer codAlbum) throws MusicaNaoEncontradaException { 
		if(albuns.remove(codAlbum).equals(null)) { 
			throw new MusicaNaoEncontradaException("Album não encontrado!");
		}
	}
	
	public static Map<Integer,Album> retornarAlbum() { 
		return new HashMap<Integer,Album>(albuns);
	}
}
