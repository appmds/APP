package com.mds.app.model;

public abstract class ProcuraProjetoModel {

	private static String ano;
	private static String id;
	private static String sigla;
	private static String dataInicio;

	public static String getAno() {
		return ano;
	}

	public static void setAno(String ano) {
		ProcuraProjetoModel.ano = ano;
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
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

}
