package br.ucsal.pratica.yllo.business;

import javax.media.*;

import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;

import java.io.File;
import java.net.URL;
import java.util.Map;

public class MusicaBO {
	
	public static void tocarMusica(String nome) {
		/*
		 * TODO refinar metodo JMF
		 */
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			if (musicas.getNome().equals(nome)) {
				File arquivoMusica = obterCaminhoMusica(musicas);
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
	}

	public static Map<Integer, Musica> retornarDadosMusica() { 
		return MusicaDAO.retornarMusicas();
	}
	
	public static void adicionarMusica(String nome, String caminhoMusica) { 
		Musica musica = new Musica(nome,caminhoMusica);
		MusicaDAO.adicionarMusica(musica);
	}
	
	public static void removerMusica(Integer cod) { 
		MusicaDAO.removerMusica(cod);
	}
	
	public static void adicionarArtista() { 
		
	}
	
	public static void adicionarGenero() { 
		
	}
	
	public static void adicionarMusicaAlbum() { 
		
	}
	
	private static File obterCaminhoMusica(Musica musica) {
		return musica.getMusica();
	}
	
}
