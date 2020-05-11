package br.ucsal.pratica.yllo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1702027959075328961L;
	private String nomePlaylist;
	private List<Musica> musicas = new ArrayList<>();
	private Integer codPlaylist;
	
	public PlayList(String nomePlaylist, Integer codPlayList) {
		super();
		this.nomePlaylist = nomePlaylist;
		this.codPlaylist = codPlayList;
	}

	public String getNomePlaylist() {
		return nomePlaylist;
	}

	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}

	public void addMusicas(Musica musica) {
		musicas.add(musica);
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public Integer getCodPlaylist() {
		return codPlaylist;
	}

	@Override
	public String toString() {
		return "Nome: " + nomePlaylist + "\n" + "código: " + codPlaylist;
	}
	
	
	
	
	
}
