package br.ucsal.pratica.yllo.business;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;

import com.google.common.hash.Hashing;

import br.ucsal.pratica.yllo.Exception.UsuarioException;
import br.ucsal.pratica.yllo.domain.Compartilhamento;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.domain.PlayList;
import br.ucsal.pratica.yllo.domain.Usuario;
import br.ucsal.pratica.yllo.persistence.UsuarioDAO;

public class UsuarioBO {
	
	public static void SalvarUsuario(String nome, String senha) { 
		Usuario usuario = new Usuario(nome, senha);
		UsuarioDAO.adicionarUsuario(usuario);
	}
	
	public static Usuario Autenticarusuario(String senha, String nome) throws UsuarioException {
		senha = Hashing.sha256().hashString(senha, StandardCharsets.UTF_8).toString();
		for(Usuario usuario : retornarUsuariosOrdenados()) { 
			if(usuario.getSenha().equals(senha) && usuario.getNome().equals(nome)) { 
				return usuario;
			}
		}
		throw new UsuarioException("Senha ou usuário invalidos"); 	
	}
	
	public static void adicionarCompartilhamento(Usuario usuario, Usuario alvo, Musica musica) { 
		Compartilhamento comp = new Compartilhamento(usuario.getNome(), alvo.getNome());
		comp.addMusicas(musica);
		usuario.addComps(comp);
	}
	
	public static void adicionarMusicaComp(Musica musica) { 
		
	}
	
	public static void adicionarPlayListComp(PlayList playlist) { 
		
	}
	
	public static void adicionarCompartilhamento(Usuario usuario, Usuario alvo, PlayList playlist) { 
		Compartilhamento comp = new Compartilhamento(usuario.getNome(), alvo.getNome());
		comp.addPlaylist(playlist);
	}
	
	
	private static ArrayList<Usuario> retornarUsuariosOrdenados() { 	
		ArrayList<Usuario> usuarios = UsuarioDAO.retornarUsuarios();
		usuarios.sort(Comparator.comparing(Usuario::getNome));
		return new ArrayList<>(usuarios);
	}

	public static void restaurarUsuarios() throws IOException {
		UsuarioDAO.restaurarUsuario();
	}
	
}
