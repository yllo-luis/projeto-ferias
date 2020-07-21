package br.ucsal.pratica.yllo.controllers;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.Exception.PlayListException;
import br.ucsal.pratica.yllo.domain.Compartilhamento;
import br.ucsal.pratica.yllo.domain.Usuario;

public class CompartilhamentoController {

	public static void adicionarCompartilhamento(Usuario usuario, String alvo) { 
		Compartilhamento comp = new Compartilhamento(usuario, UsuarioDAOController.buscarUsuario(alvo));
	}
	
	public static void adicionarMusicaComp(Integer codmusica, Usuario usuario) throws MusicaException { 
		for (Compartilhamento comp : usuario.getComps()) {
			if(comp.getUsuario().equals(usuario)) { 
				comp.addMusicas(MusicDAOController.buscaMusica(codmusica));
			}
		}
	}
	
	public static void adicionarPlayListComp(Integer codplaylist, Usuario usuario) throws PlayListException { 
		for (Compartilhamento comp : usuario.getComps()) { 
			if(comp.getUsuario().equals(usuario)) { 
				comp.addPlaylist(PlayListDAOController.procurarPlaylist(codplaylist));
			}
		}
	}
	
}
