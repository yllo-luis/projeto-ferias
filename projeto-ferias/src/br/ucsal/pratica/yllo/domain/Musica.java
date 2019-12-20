package br.ucsal.pratica.yllo.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Musica {
	private static Integer cod = 0;
	private String nome;
	private String artista;
	private String genero;
	private List<String> compositores = new ArrayList<>();
	private List<Album> album = new ArrayList<>();
	private String caminhoMusica;
	File musica = new File(caminhoMusica);
	
	public Musica(String nome, String caminhoMusica) {
		super();
		cod++;
		this.nome = nome;
		this.caminhoMusica = caminhoMusica;
	}
	
	public static Integer getCod() {
		return cod;
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
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public List<String> getCompositores() {
		return compositores;
	}
	
	public List<Album> getAlbum() {
		return album;
	}
	
	public void addAlbum(Album album) { 
		this.album.add(album);
	}
	
	public void addCompositor(String compositor) { 
		this.compositores.add(compositor);
	}

	@Override
	public String toString() {
		return "Musica [nome=" + nome + ", artista=" + artista + ", genero=" + genero + ", compositores=" + compositores
				+ ", album=" + album + ", caminhoMusica=" + caminhoMusica + ", musica=" + musica + "]";
	}
	
	
}
