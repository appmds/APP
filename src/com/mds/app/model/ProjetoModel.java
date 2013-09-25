package com.mds.app.model;

import java.sql.Date;

public class ProjetoModel {

	int ano;
	int id;
	int numero;
	String nome;
	String sigla;
	String data;
	String explicacao;
	ParlamentarModel autor;
	
	public ProjetoModel(int ano, int id, String sigla, String data, ParlamentarModel autor){
		
		this.ano = ano;
		this.id = id;
		this.sigla = sigla;
		this.data = data;
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
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

	public ParlamentarModel getAutor() {
		return autor;
	}
	public void setAutor(ParlamentarModel autor) {
		this.autor = autor;
	}
	
	
}
