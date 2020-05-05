package br.ucsal.pratica.yllo.business;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.io.FileInputStream;
import java.io.InputStream;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.domain.Album;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.AlbumDAO;

import javazoom.jl.player.Player;

public class AlbumBO {
	
	public static void tocarAlbum(Album album) { 
			/*
			 * Refazer metodo
			 */
		}
	
	public static void cadastrarAlbum(String nomeAlbum, Integer anoLancamento, String nomeGravadora) { 
		Album album = new Album(nomeAlbum,anoLancamento,nomeGravadora);  
		AlbumDAO.adicionarAlbum(album);
	}
	
	public static void removerAlbum(Integer cod) throws MusicaException { 
		AlbumDAO.removerAlbum(cod);
	}
	
	public static Map<Integer,Album> obterAlbum() { 
		return AlbumDAO.retornarAlbum();
	}
	
	public static void atualizarNomeAlbum(String nome, Album album) { 
		album.setNomeAlbum(nome);
	}
	
	public static void atualizarAnoLancamentoAlbum(Integer ano, Album album) { 
		album.setAnoLancamento(ano);
	}
	
	public static void atualizarNomeGravadora(String nome, Album album) { 
		album.setNomeGravadora(nome);
	}
	
}
