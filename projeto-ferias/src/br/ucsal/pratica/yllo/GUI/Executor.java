package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.business.MusicaBO;

public class Executor {

	public static void main(String[] args) {
		/*
		 * Entry point para execução da interface grafica
		 */
		MusicaBO.adicionarMusica("Weekend Love",
				"/home/ylloluis/Música/Yuria Kokubu/Yurie Kokubu - Weekend Love - [1983] Relief 72 hours.wav");
		MusicaBO.tocarMusica("Weekend Love");
	}

}
