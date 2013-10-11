package com.mds.app.model;

public abstract class ProcuraProjetoModel {

	private static String ano;
	private static int id;
	private static String sigla;
	private static String dataInicio;
	private static ParlamentarModel parlamentarAutor;

	public static String getAno() {
		return ano;
	}

	public static void setAno(String ano) {
		ProcuraProjetoModel.ano = ano;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		ProcuraProjetoModel.id = id;
	}

	public static String getSigla() {
		return sigla;
	}

	public static void setSigla(String sigla) {
		ProcuraProjetoModel.sigla = sigla;
	}

	public static String getDataInicio() {
		return dataInicio;
	}

	public static void setDataInicio(String dataInicio) {
		ProcuraProjetoModel.dataInicio = dataInicio;
	}

	public static ParlamentarModel getAutor() {
		return parlamentarAutor;
	}

	public static void setAutor(ParlamentarModel autor) {
		ProcuraProjetoModel.parlamentarAutor = autor;
	}

}
