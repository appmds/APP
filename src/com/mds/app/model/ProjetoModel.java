package com.mds.app.model;

public class ProjetoModel {

	private String ano;
	private int id;
	private String numero;
	private String nome;
	private String sigla;
	private String data;
	private String explicacao;
	private ParlamentarModel parlamentar;
	private int cont = 1;

	public ProjetoModel() {;
	}

	public ProjetoModel(String ano, int id, String sigla, String data, ParlamentarModel parlamentar) {
		this.ano = ano;
		this.id = id;
		this.sigla = sigla;
		this.data = data;
		
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ParlamentarModel getParlamentar() {
		return parlamentar;
	}

	public void setParlamentar(ParlamentarModel parlamentar) {
		this.parlamentar = parlamentar;
	}

}
