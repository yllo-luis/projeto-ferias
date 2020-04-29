/*
 * Leeroy jenkinssss! - Yllo Luis 
 * 
 */

package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.business.MusicaBO;
import java.util.Scanner;

public class Executor {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * Entry point para execuÃ§Ã£o da interface grafica
		 */
		MusicaBO.acharMusica();
		
		entrypointMenu();
		/*
		 * TODO consertar bugs em playbay de musica...
		 * Por algum motivo certas musicas se recusam a tocar(WTF?!)
		 */
	}

	public static void entrypointMenu() {
		Integer mode = 0;
		do { 
			System.out.println("------CLI Samantha Java Music Player-------");
			System.out.println("1. Listar Musicas disponíveis");
			System.out.println("2. Tocar Musica");
			System.out.println("3. Atualizar Artista da Musica");
			System.out.println("4. Atualizar Genero Da Musica");
			System.out.println("5. Criar Album de Musicas");
			System.out.println("6. Tocar Album de Musicas");
			System.out.println("7. Fechar Player");
			System.out.println();
			System.out.print("Opção: ");
			mode = sc.nextInt();
			switch (mode) {
			case 1:
				listarMusicas();
				break;
			case 2:
				tocarMusica();
				break;
			case 3:
				atualizarArtista();
				break;
			case 4:
				atualizarGenero();
				break;
			case 5:
				criarAlbum();
				break;
			case 6:
				tocarAlbum();
				break;
			case 7:
				System.exit(mode);
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
		} while(mode != 7);
		
	}

	private static void listarMusicas() {
		System.out.println("-----Musicas Disponíveis-----");
		MusicaBO.listarMusicas();
	}

	private static void tocarMusica() {
		System.out.println("Por favor digite o código da música desejada: ");
		Integer codigo = sc.nextInt();
		MusicaBO.tocarMusica(codigo);
	}

	private static void atualizarGenero() {
		// TODO Auto-generated method stub
		
	}

	private static void atualizarArtista() {
		// TODO Auto-generated method stub
		
	}

	private static void tocarAlbum() {
		// TODO Auto-generated method stub
		
	}

	private static void criarAlbum() {
		// TODO Auto-generated method stub
		
	}

}
