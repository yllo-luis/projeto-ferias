package br.ucsal.pratica.yllo.persistence;

import java.util.List;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.ucsal.pratica.yllo.domain.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {
	private final static Path diretorioRelativo = Paths.get(System.getProperty("user.dir"));
	private final static String arquivo = diretorioRelativo.toString() + File.separatorChar + "usuarios.bin";
	private final static Path caminhoFinal = diretorioRelativo.resolve(arquivo);
	private final static File arquivoconfig = new File(caminhoFinal.toAbsolutePath().toString());

	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static void adicionarUsuario(Usuario usuario) { 
		usuarios.add(usuario);
	}
	
	public static void salvarUsuario() { 
		try {
			arquivoconfig.createNewFile();
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arquivoconfig));
			for (Usuario usuarios : usuarios) {
				output.writeObject(usuarios);
			}
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void restaurarUsuario() throws IOException { 
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivoconfig));
			while (input != null) {
				Usuario usuario = (Usuario) input.readObject();
				usuarios.add(usuario);
			}
			input.close();
		} catch(EOFException e) { 
			System.out.println("Leitura sucedida");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Usuario> retornarUsuarios() {
		return new ArrayList<Usuario>(usuarios);
	}
	
	
	
}
