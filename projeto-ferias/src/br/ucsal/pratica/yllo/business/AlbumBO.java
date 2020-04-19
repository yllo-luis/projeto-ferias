package br.ucsal.pratica.yllo.business;

import java.io.File;
import java.net.URL;
import java.util.Map;

import javax.media.Format;
import javax.media.Manager;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;

import br.ucsal.pratica.yllo.Exception.MusicaNaoEncontradaException;
import br.ucsal.pratica.yllo.domain.Album;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.AlbumDAO;

public class AlbumBO {
	
	public static void cadastrarAlbum(String nome, String caminhoMusica, String nomeAlbum, Integer anoLancamento, String nomeGravadora, Musica musica) { 
		Album album = new Album(nome,caminhoMusica,nomeAlbum, anoLancamento,nomeGravadora);  
	}
	
	public static void adicionarMusicas() { 
		/*
		 * TODO metodo para automatizar cadastros de musicas em um album... Talvez o JLayer seja util aqui..
		 * Preciso descobrir um modo de ler dados de uma arquivo de musica coisas como artistas, duração essas coisas...
		 */
//		album.addMusicas(musica);
	}
	
	public static void removerAlbum(Integer cod) throws MusicaNaoEncontradaException { 
		AlbumDAO.removerAlbum(cod);
	}
	
	public static void tocarAlbum(Album album) { 
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn(
			"com.sun.media.codec.audio.mp3.JavaDecoder",
			new Format[]{input1, input2},
			new Format[]{output},
			PlugInManager.CODEC
		);
		for (Musica musicas : album.getMusicas()) {
			File arquivoMusica = MusicaBO.obterCaminhoMusica(musicas);
				try {
					URL url = new URL("file:///" + arquivoMusica.getCanonicalPath());
					System.out.println(url.getFile());
					Player inputPlay = Manager.createPlayer(url);
					inputPlay.start();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	
	public static Map<Integer,Album> obterAlbum() { 
		return AlbumDAO.retornarAlbum();
	}
	
	public static void atualizarNomeAlbum(String nome, Album album) { 
		album.setNome(nome);
	}
	
	public static void atualizarAnoLancamentoAlbum(Integer ano, Album album) { 
		album.setAnoLancamento(ano);
	}
	
	public static void atualizarNomeGravadora(String nome, Album album) { 
		album.setNomeGravadora(nome);
	}
	
}
