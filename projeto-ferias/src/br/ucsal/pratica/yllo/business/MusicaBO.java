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
	
	public static void tocarMusica(Integer codigo) { 
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			if(musicas.getCod().equals(codigo)) { 
				File arquivoMusica = new File(musicas.getMusica());
				try { 
					InputStream musica = new FileInputStream(arquivoMusica);
					Player player = new Player(musica);
					player.play();
					System.out.println(player.getPosition());
				} catch(IOException | JavaLayerException e) { 
					System.out.println("Falha em playback: " + e.getMessage());
				}
			}
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
			System.out.println("Falha ao capturar músicas" + e.getMessage());
		}
	}
	
	public static void listarMusicas() { 
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			System.out.println(musicas);
			try { 
				Thread.sleep(2000);
			} catch(InterruptedException e) { 
				System.out.println("Algo errado aconteceu... a thread foi interrompida abruptamente" + e.getMessage());
				System.out.println("Causa: " + e.getCause());
			}
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
	
	public static void setPath(String path) {
		MusicaBO.path = path;
	}
	
	static String obterCaminhoMusica(Musica musica) {
		return musica.getMusica();
	}
	
	private static void adicionarMusica(String nome, String caminhoMusica, Integer codigo) { 
		Musica musica = new Musica(caminhoMusica, nome, codigo);
		MusicaDAO.adicionarMusica(musica);
	}
	
	
	
}
