package br.ucsal.pratica.yllo.controllers;

import br.ucsal.pratica.yllo.domain.Usuario;
import br.ucsal.pratica.yllo.persistence.UsuarioDAO;

public class UsuarioSaveController {
	public static void SalvarUsuario(String nome, String senha) { 
		Usuario usuario = new Usuario(nome, senha);
		UsuarioDAO.adicionarUsuario(usuario);
	}
}
