package br.ucsal.pratica.yllo.business;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.Exception.PlayListException;
import br.ucsal.pratica.yllo.domain.*;
import br.ucsal.pratica.yllo.persistence.PlayListDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.InputStream;

public class PlayListBO {
	
	public static void tocarPlayList(Integer cod) { 
		try { 
			PlayList playlist = procurarPlaylist(cod);
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
	
	public static void cadastrarPlayList(String nomePlaylist, Integer codPlayList) { 
		PlayList playlist = new PlayList(nomePlaylist, codPlayList);
		PlayListDAO.adicionarPlaylist(playlist);
	}
	
	public static void adicionarMusica(Integer codmusica, Integer codPlayList) { 
		try { 
			PlayList playList = procurarPlaylist(codPlayList);
			playList.addMusicas(MusicaBO.buscaMusica(codmusica));
		} catch(PlayListException | MusicaException e) { 
			System.out.println(e.getMessage());
		}
	}
	
	public static void removerPlayList(Integer codPlayList) { 
		PlayListDAO.removerPlayList(codPlayList);
	}
	
	private static PlayList procurarPlaylist(Integer codPlaylist) throws PlayListException { 
		for(PlayList playList : PlayListDAO.retornarPlayList().values()) { 
			if(playList.getCodPlaylist().equals(codPlaylist)) { 
				return playList;
			}
		}
		throw new PlayListException("PlayList não encontrada");
	}
	
}
