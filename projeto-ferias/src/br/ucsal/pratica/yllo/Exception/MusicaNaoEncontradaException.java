package br.ucsal.pratica.yllo.Exception;

public class MusicaNaoEncontradaException extends Exception {
	private static final long serialVersionUID = 1L;
	String mensagem;

	public MusicaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	
}
