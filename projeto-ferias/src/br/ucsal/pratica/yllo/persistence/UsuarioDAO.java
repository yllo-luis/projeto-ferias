package br.ucsal.pratica.yllo.persistence;

import java.util.List;

import br.ucsal.pratica.yllo.domain.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static void salvarUsuario(Usuario usuario) { 
		usuarios.add(usuario);
	}
	
	public static List<Usuario> retornarUsuarios() {
		return new ArrayList<Usuario>(usuarios);
	}

}
