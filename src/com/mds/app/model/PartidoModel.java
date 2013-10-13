package com.mds.app.model;

import java.util.ArrayList;

public class PartidoModel {

	private ArrayList<ParlamentarModel> parlamentares;
	private String siglaPartido;
	private String uf;

	public PartidoModel() {

	}

	public PartidoModel(ArrayList<ParlamentarModel> parlamentares, String siglaPartido, String uf) {
		this.parlamentares = parlamentares;
		this.siglaPartido = siglaPartido;
		this.uf = uf;
	}

	public ArrayList<ParlamentarModel> getParlamentares() {
		return parlamentares;
	}

	public void setParlamentares(ArrayList<ParlamentarModel> parlamentares) {
		this.parlamentares = parlamentares;
	}

	public void addParlamentar(ParlamentarModel parlamentar) {
		parlamentares.add(parlamentar);
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
