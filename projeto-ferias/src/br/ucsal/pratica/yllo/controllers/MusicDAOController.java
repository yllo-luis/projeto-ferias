package br.ucsal.pratica.yllo.controllers;

import java.io.IOException;
import java.util.Map;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;

public class MusicDAOController {
	
	public static Map<Integer, Musica> retornarDadosMusica() { 
		return MusicaDAO.retornarMusicas();
	}
	
	public static void removerMusica(Integer codigo) { 
		MusicaDAO.removerMusica(codigo);
	}
	
	static Musica buscaMusica(Integer codigo) throws MusicaException {
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			if(musicas.getCod().equals(codigo)) { 
				return musicas;
			}
		}
		throw new MusicaException("Musica não encontrada");
	}
	
	public static void salvarConfiguracoes() { 
		MusicaDAO.salvarArquivo();
	}
	
	public static void restaurarConfiguracoes() throws IOException { 
		MusicaDAO.restaurarArquivo();
	}
	
}
