/*
 * Leeroy jenkinssss! - Yllo Luis 
 * 
 */

package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.Exception.MusicaException;
import br.ucsal.pratica.yllo.business.MusicaBO;
import java.util.Scanner;

public class Executor {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * Entry point para definição de path de musicas
		 */
		definirpath();
	}

	public static void definirpath() {
		System.out.println("Por favor defina a pasta de suas musicas");
		String path = sc.nextLine();
		MusicaBO.setPath(path);
		MusicaBO.acharMusica();
		entrypointMenu();
	}

	public static void entrypointMenu() {
		Integer mode = 0;
		do { 
			System.out.println("------CLI Samantha Java Music Player-------");
			System.out.println("1. Listar Musicas disponóveis");
			System.out.println("2. Tocar Musica");
			System.out.println("3. Excluir Musica");
			System.out.println("4. Atualizar Artista da Musica");
			System.out.println("5. Atualizar Genero Da Musica");
			System.out.println("6. Criar Album de Musicas");
			System.out.println("7. Tocar Album de Musicas");
			System.out.println("8. Mudar pasta de Musicas");
			System.out.println("9. Fechar Player");
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
				exluirMusica();
				break;
			case 4:
				atualizarArtista();
				break;
			case 5:
				atualizarGenero();
				break;
			case 6:
				criarAlbum();
				break;
			case 7:
				tocarAlbum();
				break;
			case 8:
				definirpath();
				break;
			case 9: 
				System.exit(mode);
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
		} while(mode != 7);
		
	}

	private static void exluirMusica() {
		System.out.println("Digite o código da música a ser excluida");
		Integer codigo = sc.nextInt();
		try {
			MusicaBO.removerMusica(codigo);
		} catch (MusicaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void listarMusicas() {
		System.out.println("-----Musicas Disponóveis-----");
		MusicaBO.listarMusicas();
	}

	private static void tocarMusica() {
		System.out.println("Por favor digite o código da música desejada: ");
		Integer codigo = sc.nextInt();
		MusicaBO.tocarMusica(codigo);
	}

	private static void atualizarGenero() {
		System.out.println("Por favor digite o código da musica desejada: ");
		Integer codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o genero da musica");
		String genero = sc.nextLine();
		MusicaBO.atualizarGenero(codigo, genero);
	}

	private static void atualizarArtista() {
		System.out.println("Digite o código da música a ser atualizada");
		Integer codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o nome do artista");
		String artista = sc.nextLine();
		MusicaBO.adicionarArtista(codigo, artista);
	}

	private static void tocarAlbum() {
		// TODO Auto-generated method stub
		
	}

	private static void criarAlbum() {
		// TODO Auto-generated method stub
		
	}

}
