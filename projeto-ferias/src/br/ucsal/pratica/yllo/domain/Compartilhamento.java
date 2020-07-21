package br.ucsal.pratica.yllo.domain;

import java.util.ArrayList;
import java.util.List;

public class Compartilhamento {
	private Usuario usuario;
	private Usuario compartilhado;
	private List<PlayList> playlists = new ArrayList<PlayList>();
	private List<Musica> musicas = new ArrayList<Musica>();
	
	public Compartilhamento(Usuario usuario, Usuario compartilhado) {
		super();
		this.usuario = usuario;
		this.compartilhado = compartilhado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getCompartilhado() {
		return compartilhado;
	}
	
	public void setCompartilhado(Usuario compartilhado) {
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
