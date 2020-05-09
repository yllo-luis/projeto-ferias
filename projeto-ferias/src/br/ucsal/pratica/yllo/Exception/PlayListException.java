package br.ucsal.pratica.yllo.Exception;

public class PlayListException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mensagem;

	public PlayListException(String mensagem) {
		super();
		this.mensagem = mensagem;
	}
	
	
}
