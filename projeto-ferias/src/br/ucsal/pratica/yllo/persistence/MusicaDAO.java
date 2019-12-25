package br.ucsal.pratica.yllo.persistence;

import java.util.Map;
import br.ucsal.pratica.yllo.domain.*;
import java.util.HashMap;

public class MusicaDAO {
	private static Map<Integer,Musica> musicas = new HashMap<Integer,Musica>();
	
	public static void adicionarMusica(Musica musica) { 
		musicas.put(Musica.getCod(), musica);
	}
	
	public static void removerMusica(Integer cod) { 
		musicas.remove(cod);
	}
	
	public static Map<Integer,Musica> retornarMusicas() { 
		return new HashMap<Integer,Musica>(musicas);
	}
	
}
