package br.ucsal.pratica.yllo.domain;

import java.util.ArrayList;
import java.util.List;
import com.google.common.hash.Hashing;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String senha;
	
        public Usuario(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = Hashing.sha256().hashString(senha, StandardCharsets.UTF_8).toString();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", senha=" + senha + '}';
    }
	
}
