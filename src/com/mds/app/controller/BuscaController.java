package com.mds.app.controller;

import java.util.ArrayList;

import com.mds.app.exception.ValidaEntrada;
import com.mds.app.model.ProcuraParlamentarModel;
import com.mds.app.model.ProcuraPartidoModel;
import com.mds.app.model.ProcuraProjetoModel;
import com.mds.app.model.ProjetoModel;
import com.mds.app.services.Endereco;
import com.mds.app.services.RecebeHTTP;
import com.mds.app.services.XMLParser;
import com.mds.app.view.Busca;

public class BuscaController {

	private RecebeHTTP recebeHTTP;
	private XMLParser xmlParser = new XMLParser();
	private Busca buscaView;
	private boolean temConexao;
	private String textoOffline;

	public BuscaController() {
	}

	public void instanciarBusca() {
		this.buscaView = new Busca();
	}

	public String transformaUF(String uf) {
		if (uf.equalsIgnoreCase("Todos")){
			uf = "";
		}
		else if (uf.equalsIgnoreCase("Acre")){
			uf = "AC";
		}
		else if (uf.equalsIgnoreCase("Alagoas")){
			uf = "AL";
		}
		else if (uf.equalsIgnoreCase("Amapá")){
			uf = "AP";
		}
		else if (uf.equalsIgnoreCase("Amazonas")){
			uf = "AM";
		}
		else if (uf.equalsIgnoreCase("Bahia")){
			uf = "BA";
		}
		else if (uf.equalsIgnoreCase("Ceará")){
			uf = "CE";
		}
		else if (uf.equalsIgnoreCase("Distrito Federal")){
			uf = "DF";
		}
		else if (uf.equalsIgnoreCase("Espírito Santo")){
			uf = "ES";
		}
		else if (uf.equalsIgnoreCase("Goiás")){
			uf = "GO";
		}
		else if (uf.equalsIgnoreCase("Maranhão")){
			uf = "MA";
		}
		else if (uf.equalsIgnoreCase("Mato Grosso")){
			uf = "MT";
		}
		else if (uf.equalsIgnoreCase("Mato Grosso do Sul")){
			uf = "MS";
		}
		else if (uf.equalsIgnoreCase("Minas Gerais")){
			uf = "MG";
		}
		else if (uf.equalsIgnoreCase("Pará")){
			uf = "PA";
		}
		else if (uf.equalsIgnoreCase("Paraíba")){
			uf = "PB";
		}
		else if (uf.equalsIgnoreCase("Paraná")){
			uf = "PR";
		}
		else if (uf.equalsIgnoreCase("Pernambuco")){
			uf = "PE";
		}
		else if (uf.equalsIgnoreCase("Piauí")){
			uf = "PI";
		}
		else if (uf.equalsIgnoreCase("Rio de Janeiro")){
			uf = "RJ";
		}
		else if (uf.equalsIgnoreCase("Rio Grande do Norte")){
			uf = "RN";
		}
		else if (uf.equalsIgnoreCase("Rio Grande do Sul")){
			uf = "RS";
		}
		else if (uf.equalsIgnoreCase("Rondônia")){
			uf = "RO";
		}
		else if (uf.equalsIgnoreCase("Roraima")){
			uf = "RR";
		}
		else if (uf.equalsIgnoreCase("Santa Catarina")){
			uf = "SC";
		}
		else if (uf.equalsIgnoreCase("São Paulo")){
			uf = "SP";
		}
		else if (uf.equalsIgnoreCase("Sergipe")){
			uf = "SE";
		}
		else if (uf.equalsIgnoreCase("Tocantins")){
			uf = "TO";
		}
		else{
			//Nao tem outras opcoes
		}
		
		return uf;
	}

	public boolean atualizarDadosDaPesquisa(String ano, String sigla, String numero, String dataIni,
			String nomeAutor, String siglaPartido, String uf) {
		
		if (ano.isEmpty()) {
			ano = "2013";
		}
		if (sigla.isEmpty()) {
			sigla = "";
		}
		if (numero.isEmpty()) {
			numero = "";
		}
		if (dataIni.isEmpty()) {
			dataIni = "";
		}
		if (nomeAutor.isEmpty()) {
			nomeAutor = "";
		}
		if (siglaPartido.isEmpty()) {
			siglaPartido = "";
		}
		if (uf.isEmpty()) {
			uf = "";
		}
		uf = transformaUF(uf);

		String erros = "";
		erros = ValidaEntrada.identificarErros(ano, sigla, numero, dataIni, nomeAutor, siglaPartido, uf);
		System.out.println(erros);
		System.out.println(dataIni);

		if (erros == "") {
			ProcuraProjetoController.atualizarDadosPesquisaProjeto(ano, sigla, numero, dataIni);
			ProcuraPartidoController.atualizaDadosPesquisaPartido(uf, siglaPartido);
			ProcuraParlamentarController.atualizarDadosPesquisaParlamentar(nomeAutor);
			return true;
		}
		else {
			return false;
		}

	}

	public ArrayList<ProjetoModel> procurar() {
		String sigla = ProcuraProjetoModel.getSigla().toUpperCase();
		String ano = ProcuraProjetoModel.getAno();
		String dataInicio = ProcuraProjetoModel.getDataInicio();
		String numero = ProcuraProjetoModel.getId();
		String nomeAutor = ProcuraParlamentarModel.getNome();
		String siglaPartido = ProcuraPartidoModel.getSigla();
		String siglaUF = ProcuraPartidoModel.getUf();

		String url = Endereco.construirEndereco(sigla, numero, ano, dataInicio, "", "", nomeAutor, siglaPartido,
				siglaUF, "", "", "");
		System.out.println(url);
		String response;
		recebeHTTP = new RecebeHTTP();
		if (temConexao) {
			response = recebeHTTP.recebe(url);
		}
		else {
			response = textoOffline;
		}
		return xmlParser.parseProjeto(response);
	}

	public Busca getBuscaView() {
		return buscaView;
	}

	public void setBuscaView(Busca buscaView) {
		this.buscaView = buscaView;
	}

	public boolean isTemConexao() {
		return temConexao;
	}

	public void setTemConexao(boolean temConexao) {
		this.temConexao = temConexao;
	}

	public String getTextoOffline() {
		return textoOffline;
	}

	public void setTextoOffline(String textoOffline) {
		this.textoOffline = textoOffline;
	}

}
