package br.ucsal.pratica.yllo.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Musica {
	private Integer codigo;
	private String nome;
	private String artista;
	private GeneroENUM genero;
	private List<String> compositores = new ArrayList<>();
	private String caminhoMusica;
	File musica;
	
	public Musica(String nome, String caminhoMusica, Integer cod) {
		super(); 
		this.nome = nome;
		this.caminhoMusica = caminhoMusica;
		this.genero = GeneroENUM.GENERO_DESCONHECIDO;
		this.codigo = cod;
		musica = new File(caminhoMusica);
	}
	
	public Integer getCod() {
		return codigo;
	}
	
	public File getMusica() {
		return musica;
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
		return "Musica [nome=" + nome + ", artista=" + artista + ", genero=" + genero + ", compositores=" + compositores
				+ ", caminhoMusica=" + caminhoMusica + ", musica=" + musica + "]" + ", codigo =" + codigo;
	}
	
	

	
	
	
}
