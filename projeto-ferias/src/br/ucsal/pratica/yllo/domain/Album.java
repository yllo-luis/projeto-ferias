package br.ucsal.pratica.yllo.domain;

import java.util.ArrayList;
import java.util.List;

public class Album {
	private static Integer codAlbum = 0;
	private String nomeAlbum;
	private Integer anoLancamento;
	private String nomeGravadora;
	private List<Musica> musicas = new ArrayList<>();
	
	public Album(String nomeAlbum, Integer anoLancamento, String nomeGravadora) {
		super();
		this.nomeAlbum = nomeAlbum;
		this.anoLancamento = anoLancamento;
		this.nomeGravadora = nomeGravadora;
	}

	public String getNomeAlbum() {
		return nomeAlbum;
	}

	public void setNomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}

	public static Integer getCodAlbum() {
		return codAlbum;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getNomeGravadora() {
		return nomeGravadora;
	}

	public void setNomeGravadora(String nomeGravadora) {
		this.nomeGravadora = nomeGravadora;
	}
	
	public void addMusicas(Musica musica) { 
		musicas.add(musica);
	}

	@Override
	public String toString() {
		return "Album [nomeAlbum=" + nomeAlbum + ", anoLancamento=" + anoLancamento + ", nomeGravadora=" + nomeGravadora
				+ ", toString()=" + super.toString() + "]";
	}
	
}
