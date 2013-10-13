package com.mds.app.model;

public abstract class ProcuraParlamentarModel {

	private static String nome;

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		ProcuraParlamentarModel.nome = nome;
	}

}
