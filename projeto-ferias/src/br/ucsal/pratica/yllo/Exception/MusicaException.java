package br.ucsal.pratica.yllo.Exception;

public class MusicaException extends Exception {
	private static final long serialVersionUID = 1L;
	String mensagem;

	public MusicaException(String mensagem) {
		super(mensagem);
	}
	
	
}
