package com.mds.app.model;

import java.sql.Date;

public abstract class ProcuraProjetoModel {

	private static int ano;
	private static int id;
	private static String sigla;
	private static Date dataInicio;
	private static ParlamentarModel parlamentarAutor;

	public static int getAno() {
		return ano;
	}

	public static void setAno(int ano) {
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

	public static Date getDataInicio() {
		return dataInicio;
	}

	public static void setDataInicio(Date dataInicio) {
		ProcuraProjetoModel.dataInicio = dataInicio;
	}

	public static ParlamentarModel getAutor() {
		return parlamentarAutor;
	}

	public static void setAutor(ParlamentarModel autor) {
		ProcuraProjetoModel.parlamentarAutor = autor;
	}

}
