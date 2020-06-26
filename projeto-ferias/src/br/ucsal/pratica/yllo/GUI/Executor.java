/*
 * Leeroy jenkinssss! - Yllo Luis 
 * 
 */

package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.Exception.UsuarioException;
import br.ucsal.pratica.yllo.business.MusicaBO;
import br.ucsal.pratica.yllo.business.PlayListBO;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.domain.PlayList;
import br.ucsal.pratica.yllo.domain.Usuario;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;
import br.ucsal.pratica.yllo.persistence.PlayListDAO;
import br.ucsal.pratica.yllo.persistence.UsuarioDAO;
import br.ucsal.pratica.yllo.business.UsuarioBO;

import java.io.IOException;
import java.util.Scanner;

public class Executor {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * Entry point para definição de path de musicas
		 */
		try {
			MusicaBO.restaurarConfiguracoes();
			UsuarioBO.restaurarUsuarios();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		login();
	}
	
	
	public static void login() {
		System.out.println("Digite o seu usuário");
		String nome = sc.nextLine();
		System.out.println("Digite sua senha");
		String senha = sc.nextLine();
		try { 
			Usuario usuario = UsuarioBO.Autenticarusuario(senha, nome);
			entrypointMenu(usuario);
		} catch(UsuarioException e) { 
			System.out.println(e.getMessage());
			System.out.println("Deseja criar um usuário novo? Y ou N");
			String op = sc.nextLine();
			if(op.equals("Y") || op.equals("y")) { 
				UsuarioBO.SalvarUsuario(nome, senha);
				login();
			} else { 
				System.exit(0);
			}
		} 
	}


	public static void entrypointMenu(Usuario usuario) {
		Integer mode = 0;
		do {
			System.out.println("Diretorio do projeto: " + System.getProperty("user.dir"));
			System.out.println("------CLI Samantha Java Music Player-------");
			System.out.println("Usuario: " + usuario.getNome());
			System.out.println("1. Salvar Musicas");
			System.out.println("2. Salvar Playlist");
			System.out.println("3. Restaurar Playlist");
			System.out.println("4. Listar Musicas disponíveis");
			System.out.println("5. Tocar Musica");
			System.out.println("6. Excluir Musica");
			System.out.println("7. Atualizar Artista da Musica");
			System.out.println("8. Atualizar Genero Da Musica");
			System.out.println("9. Criar playlist de Musicas");
			System.out.println("10. Adicionar Musicas a uma PlayList");
			System.out.println("11. Tocar playlist de Musicas");
			System.out.println("12. Listar Playlist's");
			System.out.println("13. Excluir Playlist");
			System.out.println("14. Detectar Musicas");
			System.out.println("15. Fechar Player");
			System.out.println();
			System.out.print("Opção: ");
			mode = sc.nextInt();
			switch (mode) {
			case 1:
				MusicaBO.salvarConfiguracoes();
				break;
			case 2:
				PlayListBO.salvarPlayLists();
				break;
			case 3:
				restaurarPlayLists();
				break;
			case 4:
				listarMusicas();
				break;
			case 5:
				tocarMusica();
				break;
			case 6: 
				exluirMusica();
				break;
			case 7:
				atualizarArtista();
				break;
			case 8:
				atualizarGenero();
				break;
			case 9:
				criarPlaylist();
				break;
			case 10:
				addMusicasPlayList();
				break;
			case 11:
				tocarPlaylist();
				break;
			case 12:
				listarPlayList();
				break;
			case 13:
				exluirPlayList();
				break;
			case 14:
				detectarMusicas();
				break;
			case 15: 
				System.exit(mode);
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
		} while(mode != 15);
		
	}
	
	private static void detectarMusicas() {
		sc.nextLine();
		System.out.println("Por favor defina a pasta de suas musicas");
		String path = sc.nextLine();
		MusicaBO.setPath(path);
		MusicaBO.acharMusica();
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

	private static void exluirPlayList() {
		System.out.println("Por favor digite o código da playlist a ser ecluida");
		Integer cod = sc.nextInt();
		PlayListBO.removerPlayList(cod);
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


	private static void restaurarPlayLists() {
		try {
			PlayListBO.restaurarPlayLists();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}

}
