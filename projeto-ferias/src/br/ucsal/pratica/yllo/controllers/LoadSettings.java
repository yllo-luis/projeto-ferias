package br.ucsal.pratica.yllo.controllers;

import java.io.IOException;

public class LoadSettings {
	public static void loadSettings() { 
		try {
			MusicDAOController.restaurarConfiguracoes();
			UsuarioDAOController.restaurarUsuarios();
			PlayListDAOController.restaurarPlayLists();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
}
