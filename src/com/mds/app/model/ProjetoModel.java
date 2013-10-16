package com.mds.app.model;

public class ProjetoModel {

	private String ano;
	private String numero;
	private String nome;
	private String sigla;
	private String data;
	private String explicacao;
	private ParlamentarModel parlamentar;
	private int cont;

	public ProjetoModel() {
	}

	public ProjetoModel(String ano, String nome, String sigla, String data, String numero, String explicacao,
			ParlamentarModel parlamentar) {
		this.ano = ano;
		this.nome = nome;
		this.sigla = sigla;
		this.data = data;
		this.numero = numero;
		this.explicacao = explicacao;
		this.parlamentar = parlamentar;

		this.cont = 1;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String string) {
		this.numero = string;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {

		if (this.cont == 1) {
			this.nome = nome;
		}
		this.cont++;
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

	public ParlamentarModel getParlamentar() {
		return parlamentar;
	}

	public void setParlamentar(ParlamentarModel parlamentar) {
		this.parlamentar = parlamentar;
	}

	public int getCont() {
		return cont;
	}

}
