package br.ucsal.pratica.yllo.domain;

import java.util.ArrayList;
import java.util.List;

public class Musica {
	private Integer codigo;
	private String nome;
	private String artista = "Artista Desconhecido";
	private GeneroENUM genero;
	private List<String> compositores = new ArrayList<>();
	private String caminhoMusica;
	
	public Musica(String nome, String caminhoMusica, Integer cod) {
		super(); 
		this.nome = nome;
		this.caminhoMusica = caminhoMusica;
		this.genero = GeneroENUM.GENERO_DESCONHECIDO;
		this.codigo = cod;
		this.caminhoMusica = caminhoMusica;
	}
	
	public Integer getCod() {
		return codigo;
	}
	
	public String getMusica() {
		return caminhoMusica;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public GeneroENUM getGenero() {
		return genero;
	}
	
	public void setGenero(GeneroENUM genero) {
		this.genero = genero;
	}
	
	public List<String> getCompositores() {
		return compositores;
	}
	
	public void addCompositor(String compositor) { 
		this.compositores.add(compositor);
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "\n" + "Nome: " + nome + "\n" + "Artista: " + artista;
		
	}

	
	
	

	
	
	
}
