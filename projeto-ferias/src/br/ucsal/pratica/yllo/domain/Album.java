package br.ucsal.pratica.yllo.domain;

public class Album extends Musica {
	private String nomeAlbum;
	private Integer anoLancamento;
	private String nomeGravadora;
	
	public Album(String nome, String caminhoMusica, String nomeAlbum, Integer anoLancamento, String nomeGravadora) {
		super(nome, caminhoMusica);
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

	@Override
	public String toString() {
		return "Album [nomeAlbum=" + nomeAlbum + ", anoLancamento=" + anoLancamento + ", nomeGravadora=" + nomeGravadora
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
