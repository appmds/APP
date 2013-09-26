package com.mds.app.model;

public abstract class ProcuraParlamentarModel {

	private String nome;
	private PartidoModel partido;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PartidoModel getPartido() {
		return partido;
	}

	public void setPartido(PartidoModel partido) {
		this.partido = partido;
	}

}
