package br.ucsal.pratica.yllo.persistence;

import java.util.Map;

import br.ucsal.pratica.yllo.domain.PlayList;

import java.util.HashMap;

public class PlayListDAO {
	
	/*
	 * TODO Implementar pesistencia de arquivo.
	 */
	private static Map<Integer,PlayList> musicas = new HashMap<Integer, PlayList>(); 
	
	public static void adicionarPlaylist(PlayList playList) { 
		musicas.put(playList.getCodPlaylist(), playList);
	}
	
	public static void removerPlayList(Integer codPlaylist) { 
		try { 
			musicas.remove(codPlaylist);
		} catch(NullPointerException e) { 
			System.out.println(e.getMessage());
		}
	}
	
	public static HashMap<Integer, PlayList> retornarPlayList() { 
		return new HashMap<Integer,PlayList>(musicas);
	}
}
