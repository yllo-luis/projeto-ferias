package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.business.MusicaBO;

public class Executor {

	public static void main(String[] args) {
		/*
		 * Entry point para execução da interface grafica
		 */
		MusicaBO.adicionarMusica("Weekend Love",
				"C:\\Users\\yllol\\Music\\NORIKI\\NORIKI with FUKUI - Gassun - [1989] CRESCENT.mp3");
		MusicaBO.tocarMusica("Weekend Love");
	}

}
