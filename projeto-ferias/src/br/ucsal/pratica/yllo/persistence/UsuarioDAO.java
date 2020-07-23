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
	private final static Path DIRETORIO =  Paths.get(System.getProperty("user.dir"));
	private final static String ARQUIVO = DIRETORIO.toString() + File.separatorChar + "usuarios.bin";
	private final static Path CAMINHOFINAL = DIRETORIO.resolve(ARQUIVO);
	private final static File ARQUIVOFINAL = new File(CAMINHOFINAL.toAbsolutePath().toString());

	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static void adicionarUsuario(Usuario usuario) { 
		usuarios.add(usuario);
		salvarUsuario();
	}
	
	public static void salvarUsuario() { 
		try {
			ARQUIVOFINAL.createNewFile();
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(ARQUIVOFINAL));
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
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(ARQUIVOFINAL));
			while (input != null) {
				Usuario usuario = (Usuario) input.readObject();
				usuarios.add(usuario);
			}
			input.close();
		} catch(EOFException e) { 
			System.out.println("Leitura sucedida");
		} catch (ClassNotFoundException e) {
                        System.out.println(e.getException());
                }
	}
	
	public static ArrayList<Usuario> retornarUsuarios() {
		return new ArrayList<Usuario>(usuarios);
	}
	
}
