package com.mds.app.model;

import java.sql.Date;

public class ProjetoModel {

	int ano;
	int id;
	String sigla;
	Date dataInicio;
	ParlamentarModel autor;
	
	public ProjetoModel(int ano, int id, String sigla, Date dataInicio, ParlamentarModel autor){
		
		this.ano = ano;
		this.id = id;
		this.sigla = sigla;
		this.dataInicio = dataInicio;
		this.autor = autor;
	}
	
	public ProjetoModel(){
			
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public ParlamentarModel getAutor() {
		return autor;
	}
	public void setAutor(ParlamentarModel autor) {
		this.autor = autor;
	}
	
	
}
