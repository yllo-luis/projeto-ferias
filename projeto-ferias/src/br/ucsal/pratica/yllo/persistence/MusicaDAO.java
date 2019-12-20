package br.ucsal.pratica.yllo.persistence;

import java.util.Map;
import br.ucsal.pratica.yllo.domain.Musica;
import java.util.HashMap;
import java.io.File;

public class MusicaDAO {
	private static Map<Integer,File> musicas = new HashMap<Integer,File>();
	
	public static void adicionarMusica(Musica musica) { 
		musicas.put(Musica.getCod(), musica.getMusica());
	}
	
	public static void removerMusica(Integer cod) { 
		musicas.remove(cod);
	}
	
	public static Map<Integer,File> retornarMusicas() { 
		return new HashMap<Integer,File>(musicas);
	}
}
