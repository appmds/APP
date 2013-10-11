package com.mds.app.model;

public class ProjetoModel {

	private int ano;
	private int id;
	private int numero;
	private String nome;
	private String sigla;
	private String data;
	private String explicacao;
	private ParlamentarModel parlamentarAutor;
	private int cont = 1;

	public ProjetoModel() {

	}

	public ProjetoModel(int ano, int id, String sigla, String data, ParlamentarModel autor) {
		this.ano = ano;
		this.id = id;
		this.sigla = sigla;
		this.data = data;
		this.parlamentarAutor = autor;
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
		
		if(cont==1){
			this.nome = nome;
		}
		cont++;
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
		return parlamentarAutor;
	}

	public void setAutor(ParlamentarModel autor) {
		this.parlamentarAutor = autor;
	}

}
