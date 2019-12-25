package br.ucsal.pratica.yllo.persistence;

import java.util.HashMap;
import java.util.Map;

import br.ucsal.pratica.yllo.domain.Album;

public class AlbumDAO {
	private static Map<Integer, Album> albuns = new HashMap<Integer, Album>();
	
	public static void adicionarAlbum(Album album) { 
		albuns.put(Album.getCodAlbum(), album);
	}
	
	public static void removerAlbum(Integer codAlbum) { 
		albuns.remove(codAlbum);
	}
	
	public static Map<Integer,Album> retornarAlbum() { 
		return new HashMap<Integer,Album>(albuns);
	}
}
