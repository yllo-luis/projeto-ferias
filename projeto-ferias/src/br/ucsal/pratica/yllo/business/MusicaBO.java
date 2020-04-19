package br.ucsal.pratica.yllo.business;

import javax.media.*;

import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;

import java.io.File;
import java.net.URL;
import java.util.Map;
import javax.media.format.AudioFormat;
import java.time.*;

public class MusicaBO {
	public static void tocarMusica(String nome) {
		
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn(
			"com.sun.media.codec.audio.mp3.JavaDecoder",
			new Format[]{input1, input2},
			new Format[]{output},
			PlugInManager.CODEC
		);
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			if (musicas.getNome().equals(nome)) {
				File arquivoMusica = obterCaminhoMusica(musicas);
				try {
					URL url = new URL("file:///" + arquivoMusica.getCanonicalPath());
					System.out.println(url.getFile());
					Player inputPlay = Manager.createPlayer(url);
					inputPlay.start();
					Time time = inputPlay.getDuration();
					System.out.println(inputPlay.getMediaTime().toString());
					System.out.println(time);
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
	
	public static void adicionarArtista(Musica musica, String artista) { 
		musica.setArtista(artista);
	}
	
	public static void adicionarGenero() { 
		
	}
	
	static File obterCaminhoMusica(Musica musica) {
		return musica.getMusica();
	}
	
}
