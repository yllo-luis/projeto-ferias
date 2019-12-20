package br.ucsal.pratica.yllo.business;

import javax.media.*;

import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;

import java.io.File;
import java.util.Map;


public class MusicaBO {
	
	public static void tocarMusica() { 
		/*
		 * Operação para tocar a musica aqui eu preciso ler como usar o JMF
		 */
	}
	
	public static Map<Integer,File> retornarDadosMusica() { 
		return MusicaDAO.retornarMusicas();
	}
	
	public static void adicionarMusica(String nome, String caminhoMusica) { 
		Musica musica = new Musica(nome,caminhoMusica);
		MusicaDAO.adicionarMusica(musica);
	}
	
	public static void removerMusica(Integer cod) { 
		MusicaDAO.removerMusica(cod);
	}
}
