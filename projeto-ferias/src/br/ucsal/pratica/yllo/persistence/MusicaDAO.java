package br.ucsal.pratica.yllo.persistence;

import java.util.Map;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.domain.Musica;
import java.util.HashMap;

public class MusicaDAO {
	private static Map<Integer,Musica> musicas = new HashMap<Integer,Musica>();
	
	public static void adicionarMusica(Musica musica) { 
		musicas.put(Musica.getCod(), musica);
	}
	
	public static void removerMusica(Integer cod) throws MusicaException { 
		musicas.remove(cod);
		if(musicas.remove(cod).equals(null)) { 
			throw new MusicaException("Musica não encontrada");
		}
	}
	
	public static Map<Integer,Musica> retornarMusicas() { 
		return new HashMap<Integer,Musica>(musicas);
	}
	
}
