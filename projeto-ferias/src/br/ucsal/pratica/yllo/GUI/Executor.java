/*
 * Leeroy jenkinssss! - Yllo Luis 
 * 
 */

package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.business.MusicaBO;
import br.ucsal.pratica.yllo.business.PlayListBO;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.domain.PlayList;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;
import br.ucsal.pratica.yllo.persistence.PlayListDAO;

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
			System.out.println("1. Listar Musicas disponíveis");
			System.out.println("2. Tocar Musica");
			System.out.println("3. Excluir Musica");
			System.out.println("4. Atualizar Artista da Musica");
			System.out.println("5. Atualizar Genero Da Musica");
			System.out.println("6. Criar playlist de Musicas");
			System.out.println("7. Adicionar Musicas a uma PlayList");
			System.out.println("8. Tocar playlist de Musicas");
			System.out.println("9. Listar Playlist's");
			System.out.println("10. Mudar pasta de Musicas");
			System.out.println("11. Fechar Player");
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
				criarPlaylist();
				break;
			case 7:
				addMusicasPlayList();
				break;
			case 8:
				tocarPlaylist();
				break;
			case 9:
				listarPlayList();
				break;
			case 10:
				definirpath();
				break;
			case 11: 
				System.exit(mode);
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
		} while(mode != 11);
		
	}

	private static void exluirMusica() {
		System.out.println("Digite o código da música a ser excluida");
		Integer codigo = sc.nextInt();
		MusicaBO.removerMusica(codigo);
	}

	private static void listarMusicas() {
		System.out.println("-----Musicas Disponóveis-----");
		for (Musica musicas : MusicaDAO.retornarMusicas().values()) {
			System.out.println(musicas);
			try { 
				Thread.sleep(2000);
			} catch(InterruptedException e) { 
				System.out.println("Algo errado aconteceu... a thread foi interrompida abruptamente" + e.getMessage());
				System.out.println("Causa: " + e.getCause());
			}
		}
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

	private static void addMusicasPlayList() {
		System.out.println("Por favor digite o código da música a ser adicionada");
		Integer cod = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor digite o código da PlayList");
		Integer codPlayList = sc.nextInt();
		PlayListBO.adicionarMusica(cod, codPlayList);
	}

	private static void tocarPlaylist() {
		System.out.println("Digite o código da playlist a ser tocada");
		Integer cod = sc.nextInt();
		PlayListBO.tocarPlayList(cod);
	}

	private static void criarPlaylist() {
		sc.nextLine();
		System.out.println("Digite o nome da sua nova playlist");
		String nome = sc.nextLine();
		System.out.println("Digite o código da sua playlist");
		Integer cod = sc.nextInt();
		PlayListBO.cadastrarPlayList(nome, cod);
	}

	private static void listarPlayList() {
		System.out.println("-----Playlist's Disponóveis-----");
		for (PlayList playList : PlayListDAO.retornarPlayList().values()) {
			System.out.println(playList);
			try { 
				Thread.sleep(2000);
			} catch(InterruptedException e) { 
				System.out.println("Algo errado aconteceu... a thread foi interrompida abruptamente" + e.getMessage());
				System.out.println("Causa: " + e.getCause());
			}
		}
	}

}
