package br.ucsal.pratica.yllo.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;

public class MusicSaveController {
	private static String path;
	
	public static void acharMusica() {
		try(Stream<Path> paths = Files.walk(Paths.get(path), Integer.MAX_VALUE)) {
			Integer codigo = 0;
			List<Path> musicas = paths.filter(F -> F.toString().endsWith(".mp3")).collect(Collectors.toList());
			for (Path path : musicas) {
				codigo++;
				salvarMusica(path.toAbsolutePath().toString(), codigo);
			}
		} catch(IOException e) { 
			System.out.println("Falha ao capturar músicas " + e.getMessage());
		}
	}

	private static void salvarMusica(String caminho, Integer codigo) {
		Musica musica = new Musica(caminho, codigo);
		MusicaDAO.adicionarMusica(musica);
	}

	public static void setPath(String path) {
		MusicSaveController.path = path;
	}
	
}
