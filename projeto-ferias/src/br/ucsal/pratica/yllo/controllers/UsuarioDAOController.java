package br.ucsal.pratica.yllo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import br.ucsal.pratica.yllo.domain.Usuario;
import br.ucsal.pratica.yllo.persistence.UsuarioDAO;

public class UsuarioDAOController {
	
	public static ArrayList<Usuario> retornarUsuariosOrdenados() { 	
		ArrayList<Usuario> usuarios = UsuarioDAO.retornarUsuarios();
		usuarios.sort(Comparator.comparing(Usuario::getNome));
		return new ArrayList<>(usuarios);
	}
	
	public static Usuario buscarUsuario(String alvo) { 
		for (Usuario usuario : retornarUsuariosOrdenados()) {
			if(usuario.getNome().equals(alvo)) { 
				return usuario;
			}
		}
		return null;
	}
	
	public static void restaurarUsuarios() throws IOException {
		UsuarioDAO.restaurarUsuario();
	}
	
}
