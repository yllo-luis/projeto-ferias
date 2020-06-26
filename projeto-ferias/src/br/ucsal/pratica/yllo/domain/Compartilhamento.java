package br.ucsal.pratica.yllo.domain;

import java.util.ArrayList;
import java.util.List;

public class Compartilhamento {
	private String usuario;
	private String compartilhado;
	private List<PlayList> playlists = new ArrayList<PlayList>();
	private List<Musica> musicas = new ArrayList<Musica>();
	
	public Compartilhamento(String usuario, String compartilhado) {
		super();
		this.usuario = usuario;
		this.compartilhado = compartilhado;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getCompartilhado() {
		return compartilhado;
	}
	
	public void setCompartilhado(String compartilhado) {
		this.compartilhado = compartilhado;
	}
	
	public List<PlayList> getPlaylist() {
		return playlists;
	}
	
	public void addPlaylist(PlayList playlist) {
		this.playlists.add(playlist);
	}
	
	public List<Musica> getMusicas() {
		return musicas;
	}
	
	public void addMusicas(Musica musica) {
		this.musicas.add(musica);
	}
	
	
}
