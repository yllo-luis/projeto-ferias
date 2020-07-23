/*
 * Leeroy jenkinssss! - Yllo Luis 
 * 
 */

package br.ucsal.pratica.yllo.GUI;

import br.ucsal.pratica.yllo.Exception.UsuarioException;
import br.ucsal.pratica.yllo.controllers.MusicReproductionController;
import br.ucsal.pratica.yllo.controllers.MusicSaveController;
import br.ucsal.pratica.yllo.controllers.MusicUpdateController;
import br.ucsal.pratica.yllo.controllers.PlayListDAOController;
import br.ucsal.pratica.yllo.controllers.PlayListReproductionController;
import br.ucsal.pratica.yllo.controllers.PlayListSaveController;
import br.ucsal.pratica.yllo.controllers.UsuarioAuthController;
import br.ucsal.pratica.yllo.controllers.UsuarioDAOController;
import br.ucsal.pratica.yllo.domain.Musica;
import br.ucsal.pratica.yllo.domain.PlayList;
import br.ucsal.pratica.yllo.domain.Usuario;
import br.ucsal.pratica.yllo.persistence.MusicaDAO;
import br.ucsal.pratica.yllo.persistence.PlayListDAO;
import br.ucsal.pratica.yllo.controllers.LoadSettings;
import br.ucsal.pratica.yllo.controllers.MusicDAOController;
import br.ucsal.pratica.yllo.controllers.UsuarioSaveController;

import java.util.Scanner;

public class Executor {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LoadSettings.loadSettings();
		check();
	}
	
        private static void check() {
            System.out.println("Deseja criar um usuário novo?");
            String choice = sc.nextLine();
            switch(choice) { 
                case "Sim":
                    newUser();
                    break;
                case "Nao":
                    login();
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
	
	public static void login() {
		System.out.println("Digite o seu usuário");
		String nome = sc.nextLine();
		System.out.println("Digite sua senha");
		String senha = sc.nextLine();
		try { 
			Usuario usuario = UsuarioAuthController.Autenticarusuario(senha, nome);
			entrypointMenu(usuario);
		} catch(UsuarioException e) { 
			System.out.println(e.getMessage());
		}
	} 
	
        public static void newUser() { 
            System.out.println("Digite seu nome de usuário");
            String nome = sc.nextLine();
            System.out.println("Digite uma senha");
            String senha = sc.nextLine();
            UsuarioSaveController.SalvarUsuario(nome, senha);
            login();
        }

	public static void entrypointMenu(Usuario usuario) {
		Integer mode = 0;
		do {
			System.out.println("Diretorio do projeto: " + System.getProperty("user.dir"));
			System.out.println("------CLI Samantha Java Music Player-------");
			System.out.println("Usuario: " + usuario.getNome());
			System.out.println("1. Salvar Musicas");
			System.out.println("2. Salvar Playlist");
			System.out.println("3. Listar Musicas disponíveis");
			System.out.println("4. Tocar Musica");
			System.out.println("5. Excluir Musica");
			System.out.println("6. Atualizar Artista da Musica");
			System.out.println("7. Atualizar Genero Da Musica");
			System.out.println("8. Criar playlist de Musicas");
			System.out.println("9. Adicionar Musicas a uma PlayList");
			System.out.println("10. Tocar playlist de Musicas");
			System.out.println("11. Listar Playlist's");
			System.out.println("12. Excluir Playlist");
			System.out.println("13. Detectar Musicas");
			System.out.println("14. Fechar Player");
			System.out.println();
			System.out.print("Opção: ");
			mode = sc.nextInt();
			switch (mode) {
			case 1:
				MusicDAOController.salvarConfiguracoes();
				break;
			case 2:
				PlayListDAOController.salvarPlayLists();
				break;
			case 3:
				listarMusicas();
				break;
			case 4:
				tocarMusica();
				break;
			case 5: 
				excluirMusica();
				break;
			case 6:
				atualizarArtista();
				break;
			case 7:
				atualizarGenero();
				break;
			case 8:
				criarPlaylist();
				break;
			case 9:
				addMusicasPlayList();
				break;
			case 10:
				tocarPlaylist();
				break;
			case 11:
				listarPlayList();
				break;
			case 12:
				excluirPlayList();
				break;
			case 13:
				detectarMusicas();
				break;
			case 14: 
				System.out.println("Até");
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
		} while(mode != 14);		
	}

	private static void detectarMusicas() {
		sc.nextLine();
		System.out.println("Por favor defina a pasta de suas musicas");
		String path = sc.nextLine();
		MusicSaveController.setPath(path);
		MusicSaveController.acharMusica();
	}
	
	private static void excluirMusica() {
		System.out.println("Digite o código da música a ser excluida");
		Integer codigo = sc.nextInt();
		MusicDAOController.removerMusica(codigo);
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
		MusicReproductionController.tocarMusica(codigo);
	}

	private static void atualizarGenero() {
		System.out.println("Por favor digite o código da musica desejada: ");
		Integer codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o genero da musica");
		String genero = sc.nextLine();
		MusicUpdateController.atualizarGenero(codigo, genero);
	}

	private static void atualizarArtista() {
		System.out.println("Digite o código da música a ser atualizada");
		Integer codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o nome do artista");
		String artista = sc.nextLine();
		MusicUpdateController.adicionarArtista(codigo, artista);
	}

	private static void addMusicasPlayList() {
		System.out.println("Por favor digite o código da música a ser adicionada");
		Integer cod = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor digite o código da PlayList");
		Integer codPlayList = sc.nextInt();
		PlayListSaveController.adicionarMusica(cod, codPlayList);
	}

	private static void excluirPlayList() {
		System.out.println("Por favor digite o código da playlist a ser ecluida");
		Integer cod = sc.nextInt();
		PlayListDAOController.removerPlayList(cod);
	}


	private static void tocarPlaylist() {
		System.out.println("Digite o código da playlist a ser tocada");
		Integer cod = sc.nextInt();
		PlayListReproductionController.tocarPlayList(cod);
	}

	private static void criarPlaylist() {
		sc.nextLine();
		System.out.println("Digite o nome da sua nova playlist");
		String nome = sc.nextLine();
		System.out.println("Digite o código da sua playlist");
		Integer cod = sc.nextInt();
		PlayListSaveController.cadastrarPlayList(nome, cod);
	}

	private static void listarPlayList() {
		System.out.println("-----Playlist's Disponóveis-----");
		for (PlayList playList : PlayListDAO.retornarPlayList().values()) {
			System.out.println(playList);
			try { 
				Thread.sleep(2000);
			} catch(InterruptedException e) { 
				System.out.println("Algo errado aconteceu... a thread foi interrompida abruptamente" + e.getMessage());
			}
		}
	}

}
