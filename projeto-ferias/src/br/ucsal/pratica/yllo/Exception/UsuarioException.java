package br.ucsal.pratica.yllo.Exception;

public class UsuarioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mensagem;
	
	public UsuarioException(String mensagem) {
		super(mensagem);
	} 
	
	
	
}
