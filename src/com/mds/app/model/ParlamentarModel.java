package com.mds.app.model;

public class ParlamentarModel {

	private String nome;
	private PartidoModel partido;

	public ParlamentarModel() {

	}

	public ParlamentarModel(String nome, PartidoModel partido) {
		this.nome = nome;
		this.partido = partido;
		partido.addParlamentar(this);
	}

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
