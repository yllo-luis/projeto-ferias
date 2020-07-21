package br.ucsal.pratica.yllo.controllers;

import java.io.IOException;

import br.ucsal.pratica.yllo.Exception.PlayListException;
import br.ucsal.pratica.yllo.domain.PlayList;
import br.ucsal.pratica.yllo.persistence.PlayListDAO;

public class PlayListDAOController {


	public static void removerPlayList(Integer codPlayList) { 
		PlayListDAO.removerPlayList(codPlayList);
	}
	
	public static void salvarPlayLists() {
		PlayListDAO.salvarArquivo();
	}
	
	public static void restaurarPlayLists() throws IOException { 
		PlayListDAO.restaurarArquivo();
	}
	
	public static PlayList procurarPlaylist(Integer codPlaylist) throws PlayListException { 
		for(PlayList playList : PlayListDAO.retornarPlayList().values()) { 
			if(playList.getCodPlaylist().equals(codPlaylist)) { 
				return playList;
			}
		}
		throw new PlayListException("PlayList não encontrada");
	}
	
}
