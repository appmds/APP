package com.mds.app.model;

public abstract class ProcuraPartidoModel {

	private static String uf;
	private static String sigla;

	public static String getUf() {
		return uf;
	}

	public static void setUf(String uf) {
		ProcuraPartidoModel.uf = uf;
	}

	public static String getSigla() {
		return sigla;
	}

	public static void setSigla(String sigla) {
		ProcuraPartidoModel.sigla = sigla;
	}

}
