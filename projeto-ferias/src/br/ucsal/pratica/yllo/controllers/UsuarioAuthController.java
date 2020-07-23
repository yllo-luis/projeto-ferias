package br.ucsal.pratica.yllo.controllers;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import br.ucsal.pratica.yllo.Exception.UsuarioException;
import br.ucsal.pratica.yllo.domain.Usuario;

public class UsuarioAuthController {
	
	public static Usuario Autenticarusuario(String senha, String nome) throws UsuarioException {
		senha = Hashing.sha256().hashString(senha, StandardCharsets.UTF_8).toString();
		for(Usuario usuario : UsuarioDAOController.retornarUsuariosOrdenados()) { 
                    if(usuario.getSenha().equals(senha) && usuario.getNome().equals(nome)) { 
				return usuario;
			}
		}
		throw new UsuarioException("Senha ou usuário invalidos"); 	
	}
        
}
