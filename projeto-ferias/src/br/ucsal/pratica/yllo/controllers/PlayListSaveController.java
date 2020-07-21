package br.ucsal.pratica.yllo.controllers;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.Exception.PlayListException;
import br.ucsal.pratica.yllo.domain.PlayList;
import br.ucsal.pratica.yllo.persistence.PlayListDAO;

public class PlayListSaveController {
	public static void cadastrarPlayList(String nomePlaylist, Integer codPlayList) { 
		PlayList playlist = new PlayList(nomePlaylist, codPlayList);
		PlayListDAO.adicionarPlaylist(playlist);
	}
	
	public static void adicionarMusica(Integer codmusica, Integer codPlayList) { 
		try { 
			PlayList playList = PlayListDAOController.procurarPlaylist(codPlayList);
			playList.addMusicas(MusicDAOController.buscaMusica(codmusica));
		} catch(PlayListException | MusicaException e) { 
			System.out.println(e.getMessage());
		}
	}
}
