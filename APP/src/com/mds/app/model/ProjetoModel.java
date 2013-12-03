package com.mds.app.model;

public class ProjetoModel {

	private String id;
	private String ano;
	private String numero;
	private String nome;
	private String sigla;
	private String data;
	private String explicacao;
	private String status;
	private ParlamentarModel parlamentar;
	private int cont = 0;
	private int contId = 0;
	

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
		else {
			// fazer nada
		}
		this.cont++;
	}

	public void setId(String id) {
		if (this.contId == 0) {
			this.id = id;
			this.contId++;
		}
		else {
			// fazer nada
		}
	}

	public String getSigla() {
		return sigla;
	}

	public String getId() {
		return id;
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

	public void setCont(int cont) {
		this.cont = cont;
	}

	public int getContId() {
		return contId;
	}

	public void setContId(int contId) {
		this.contId = contId;
	}

	@Override
	public String toString() {
		return "ProjetoModel [ano=" + ano + ", numero=" + numero + ", nome=" + nome + ", sigla=" + sigla
				+ ", data=" + data + ", explicacao=" + explicacao + ", parlamentar=" + parlamentar.getNome() + "]";
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
		
	}

}
