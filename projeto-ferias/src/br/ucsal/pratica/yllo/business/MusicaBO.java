package br.ucsal.pratica.yllo.business;


import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.domain.GeneroENUM;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.InputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicaBO {	
	
	private static String path;
	
	public static void salvarConfiguracoes() { 
		MusicaDAO.salvarArquivo();
	}
	
	public static void restaurarConfiguracoes() { 
		MusicaDAO.restaurarArquivo();
	}
	
	public static void tocarMusica(Integer codigo) {
		try {
			File arquivoMusica = new File(buscaMusica(codigo).getMusica());
			InputStream musica = new FileInputStream(arquivoMusica);
			Player player = new Player(musica);
			player.play();
		} catch (IOException | JavaLayerException | MusicaException e) {
			System.out.println("Falha em playback: " + e.getMessage());
		}
	}
	
	
	public static Map<Integer, Musica> retornarDadosMusica() { 
		return MusicaDAO.retornarMusicas();
	}
	
	public static void acharMusica() {
		try(Stream<Path> paths = Files.walk(Paths.get(path), Integer.MAX_VALUE)) {
			Integer codigo = 0;
			List<Path> musicas = paths.filter(F -> F.toString().endsWith(".mp3")).collect(Collectors.toList());
			for (Path path : musicas) {
				codigo++;
				adicionarMusica(path.toString(), path.toAbsolutePath().toString(), codigo);
			}
		} catch(IOException e) { 
			System.out.println("Falha ao capturar músicas " + e.getMessage());
		}
	}
	
	public static void removerMusica(Integer codigo) { 
		MusicaDAO.removerMusica(codigo);
	}
	
	public static void adicionarArtista(Integer codigo, String artista) { 
		try {
			Musica musica = buscaMusica(codigo);
			musica.setArtista(artista);
		} catch (MusicaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void atualizarGenero(Integer codigo ,String genero) { 
		try {
			Musica musica = buscaMusica(codigo);
			musica.setGenero(GeneroENUM.valueOf(genero.toUpperCase()));
		} catch (MusicaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void setPath(String path) {
		MusicaBO.path = path;
	}
	
	private static void adicionarMusica(String nome, String caminhoMusica, Integer codigo) { 
		Musica musica = new Musica(caminhoMusica, nome, codigo);
		MusicaDAO.adicionarMusica(musica);
	}
	
	static Musica buscaMusica(Integer codigo) throws MusicaException { 
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			if(musicas.getCod().equals(codigo)) { 
				return musicas;
			}
		}
		throw new MusicaException("Musica não encontrada");
	}
}
