package com.mds.app.model;

import java.util.ArrayList;

public class PartidoModel {

	private String siglaPartido;
	private String uf;

	public PartidoModel() {

	}

	public PartidoModel(String siglaPartido, String uf) {
		this.siglaPartido = siglaPartido;
		this.uf = uf;
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
