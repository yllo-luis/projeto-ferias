package br.ucsal.pratica.yllo.business;

import javax.media.*;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.domain.GeneroENUM;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.media.format.AudioFormat;

import java.time.*;

public class MusicaBO {	
	
	public static void tocarMusica(Integer codigo) {
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
			if (musicas.getCod().equals(codigo)) {
				File arquivoMusica = obterCaminhoMusica(musicas);
				System.out.println(musicas.getNome());
				try {
					URL url = new URL("file:///" + arquivoMusica.getCanonicalPath());
					Player inputPlay = Manager.createRealizedPlayer(url);
					inputPlay.start();	
					System.out.println(inputPlay.getMediaTime().toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static Map<Integer, Musica> retornarDadosMusica() { 
		return MusicaDAO.retornarMusicas();
	}
	
	public static void acharMusica() {
		try(Stream<Path> paths = Files.walk(Paths.get("C:\\Users\\yllol\\Music"), Integer.MAX_VALUE)) {
			Integer codigo = 0;
			List<Path> musicas = paths.filter(F -> F.toString().endsWith(".mp3")).collect(Collectors.toList());
			for (Path path : musicas) {
				codigo++;
				adicionarMusica(path.toString(),path.toAbsolutePath().toString(),codigo);	
			}
		} catch(IOException e) { 
			System.out.println(e);
		}
	}
	
	public static void listarMusicas() { 
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			System.out.println(musicas);
		}
	}
	
	public static void removerMusica(Integer codigo) throws MusicaException { 
		MusicaDAO.removerMusica(codigo);
	}
	
	public static void adicionarArtista(Musica musica, String artista) { 
		musica.setArtista(artista);
	}
	
	public static void atualizarGenero(Musica musica, GeneroENUM genero) { 
		musica.setGenero(genero);
	}
	
	static File obterCaminhoMusica(Musica musica) {
		return musica.getMusica();
	}
	
	private static void adicionarMusica(String nome, String caminhoMusica, Integer codigo) { 
		Musica musica = new Musica(caminhoMusica, nome, codigo);
		MusicaDAO.adicionarMusica(musica);
	}
	
}
