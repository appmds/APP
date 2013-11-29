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

public class BuscaController {

	private RecebeHTTP recebeHTTP;
	private XMLParser xmlParser;
	private boolean temConexao;
	private String textoOffline;

	public BuscaController() {
		xmlParser = new XMLParser();
	}

	public String transformaSigla(String sigla) {
		if (sigla.equalsIgnoreCase("Projeto de Lei")) {
			sigla = "PL";
		}
		else if (sigla.equalsIgnoreCase("Propostas de Emenda à Constituição")) {
			sigla = "PEC";
		}
		else if (sigla.equalsIgnoreCase("Projetos de Lei Complementar")) {
			sigla = "PLP";
		}
		else if (sigla.equalsIgnoreCase("Projetos de Decreto Legislativo ")) {
			sigla = "PDC";
		}
		else if (sigla.equalsIgnoreCase("Projetos de Resolução")) {
			sigla = "PRC";
		}
		else {
			// não tem outras opções
			throw new IllegalArgumentException("sigla invalida");
		}
		return sigla;
	}

	public String transformaUF(String uf) {
		System.out.println(uf);

		if (uf.equalsIgnoreCase("Todos os Estados")) {
			uf = "";
		}
		else if (uf.equalsIgnoreCase("Acre")) {
			uf = "AC";
		}
		else if (uf.equalsIgnoreCase("Alagoas")) {
			uf = "AL";
		}
		else if (uf.equalsIgnoreCase("Amapá")) {
			uf = "AP";
		}
		else if (uf.equalsIgnoreCase("Amazonas")) {
			uf = "AM";
		}
		else if (uf.equalsIgnoreCase("Bahia")) {
			uf = "BA";
		}
		else if (uf.equalsIgnoreCase("Ceará")) {
			uf = "CE";
		}
		else if (uf.equalsIgnoreCase("Distrito Federal")) {
			uf = "DF";
		}
		else if (uf.equalsIgnoreCase("Espírito Santo")) {
			uf = "ES";
		}
		else if (uf.equalsIgnoreCase("Goiás")) {
			uf = "GO";
		}
		else if (uf.equalsIgnoreCase("Maranhão")) {
			uf = "MA";
		}
		else if (uf.equalsIgnoreCase("Mato Grosso")) {
			uf = "MT";
		}
		else if (uf.equalsIgnoreCase("Mato Grosso do Sul")) {
			uf = "MS";
		}
		else if (uf.equalsIgnoreCase("Minas Gerais")) {
			uf = "MG";
		}
		else if (uf.equalsIgnoreCase("Pará")) {
			uf = "PA";
		}
		else if (uf.equalsIgnoreCase("Paraíba")) {
			uf = "PB";
		}
		else if (uf.equalsIgnoreCase("Paraná")) {
			uf = "PR";
		}
		else if (uf.equalsIgnoreCase("Pernambuco")) {
			uf = "PE";
		}
		else if (uf.equalsIgnoreCase("Piauí")) {
			uf = "PI";
		}
		else if (uf.equalsIgnoreCase("Rio de Janeiro")) {
			uf = "RJ";
		}
		else if (uf.equalsIgnoreCase("Rio Grande do Norte")) {
			uf = "RN";
		}
		else if (uf.equalsIgnoreCase("Rio Grande do Sul")) {
			uf = "RS";
		}
		else if (uf.equalsIgnoreCase("Rondônia")) {
			uf = "RO";
		}
		else if (uf.equalsIgnoreCase("Roraima")) {
			uf = "RR";
		}
		else if (uf.equalsIgnoreCase("Santa Catarina")) {
			uf = "SC";
		}
		else if (uf.equalsIgnoreCase("São Paulo")) {
			uf = "SP";
		}
		else if (uf.equalsIgnoreCase("Sergipe")) {
			uf = "SE";
		}
		else if (uf.equalsIgnoreCase("Tocantins")) {
			uf = "TO";
		}
		else {
			// Nao tem outras opcoes
			throw new IllegalArgumentException("uf invalida");
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
		if (siglaPartido.equals("Todos os Partidos")) {
			siglaPartido = "";
		}
		if (uf.isEmpty()) {
			uf = "";
		}
		uf = transformaUF(uf);
		sigla = transformaSigla(sigla);

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

	public String receberXml() {

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

		String response = null;
		recebeHTTP = new RecebeHTTP();
		if (temConexao) {
			response = recebeHTTP.recebe(url);
		}
		else {
			response = textoOffline;
		}

		return response;

	}

	public ArrayList<ProjetoModel> procurar() {
		String xmlProjeto = receberXml();
		return xmlParser.parseProjeto(xmlProjeto);
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

	public XMLParser getXmlParser() {
		return xmlParser;
	}

	public void setXmlParser(XMLParser xmlParser) {
		this.xmlParser = xmlParser;
	}

}
