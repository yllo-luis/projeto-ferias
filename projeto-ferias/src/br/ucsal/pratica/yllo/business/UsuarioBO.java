package br.ucsal.pratica.yllo.business;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import br.ucsal.pratica.yllo.domain.Usuario;
import br.ucsal.pratica.yllo.persistence.UsuarioDAO;

public class UsuarioBO {
	
	public static void SalvarUsuario(String nome, String senha) { 
		Usuario usuario = new Usuario(nome, senha);
		UsuarioDAO.salvarUsuario(usuario);
	}
	
	public static boolean Autenticarusuario(String senha) {
		senha = Hashing.sha256().hashString(senha, StandardCharsets.UTF_8).toString();
		for(Usuario usuario : UsuarioDAO.retornarUsuarios()) { 
			if(usuario.getSenha().equals(senha)) { 
				return true;
			}
		}
		return false; 	
	}
	
}
