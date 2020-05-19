package br.ucsal.pratica.yllo.persistence;

import java.util.Map;

import br.ucsal.pratica.yllo.domain.Musica;
import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MusicaDAO {
	private static Map<Integer,Musica> musicas = new HashMap<Integer,Musica>();
	
	private final static Path diretorioRelativo = Paths.get(System.getProperty("user.dir"));
	private final static String arquivo = diretorioRelativo.toString() + File.separatorChar + "musica.bin";
	private final static Path caminhoFinal = diretorioRelativo.resolve(arquivo);
	private final static File arquivoconfig = new File(caminhoFinal.toAbsolutePath().toString());

	public static void adicionarMusica(Musica musica) { 
		musicas.put(musica.getCod(), musica);
	}
	
	public static void removerMusica(Integer codigo) { 
		try { 
			musicas.remove(codigo);
		} catch(NullPointerException e) { 
			System.out.println(e.getStackTrace());
		}
	}
	
	public static Map<Integer,Musica> retornarMusicas() { 
		return new HashMap<Integer,Musica>(musicas);
	}
	
	public static void salvarArquivo() { 
		try {
			arquivoconfig.createNewFile();
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arquivoconfig));
			for (Musica musica : musicas.values()) {
				output.writeObject(musica);
			}
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	public static void restaurarArquivo() throws IOException { 
		musicas.clear();
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivoconfig));
			while (input != null) {
				Musica musica = (Musica) input.readObject();
				musicas.put(musica.getCod(), musica);
			}
			input.close();
		} catch(EOFException e) { 
			System.out.println("Leitura sucedida");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
