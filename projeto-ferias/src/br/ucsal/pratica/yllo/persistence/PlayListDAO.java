package br.ucsal.pratica.yllo.persistence;

import java.util.Map;

import br.ucsal.pratica.yllo.domain.PlayList;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class PlayListDAO {
	
	private static Map<Integer,PlayList> musicas = new HashMap<Integer, PlayList>(); 
	private static File arquivoconfig = new File(System.getProperty("user.dir") + "playlists.bin");
	
	
	public static void adicionarPlaylist(PlayList playList) { 
		musicas.put(playList.getCodPlaylist(), playList);
	}
	
	public static void removerPlayList(Integer codPlaylist) { 
		try { 
			musicas.remove(codPlaylist);
		} catch(NullPointerException e) { 
			System.out.println(e.getMessage());
		}
	}
	
	public static HashMap<Integer, PlayList> retornarPlayList() { 
		return new HashMap<Integer,PlayList>(musicas);
	}
	
	public static void salvarArquivo() { 
		try {
			arquivoconfig.createNewFile();
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arquivoconfig));
			for (PlayList musica : musicas.values()) {
				output.writeObject(musica);
			}
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	public static void restaurarArquivo() { 
		musicas.clear();
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivoconfig));
			while (input != null) {
				PlayList playList = (PlayList) input.readObject();
				musicas.put(playList.getCodPlaylist(), playList);
			}
			input.close();
		} catch(EOFException e) { 
			System.out.println("Leitura sucedida");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
