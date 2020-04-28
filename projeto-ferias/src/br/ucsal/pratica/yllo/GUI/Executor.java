package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.business.MusicaBO;

public class Executor {

	public static void main(String[] args) {
		/*
		 * Entry point para execução da interface grafica
		 */
		MusicaBO.acharMusica();
		MusicaBO.tocarMusica(445);
		
		/*
		 * TODO consertar bugs em playbay de musica...
		 * Por algum motivo certas musicas se recusam a tocar(WTF?!)
		 */
	}

}
