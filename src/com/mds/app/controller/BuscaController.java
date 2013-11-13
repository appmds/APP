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
	
	public void instanciarBusca(){
		this.buscaView = new Busca();
	}
	
	public String transformaUF(String uf){
		if(uf.equalsIgnoreCase("Acre"))
			uf = "AC";
		if(uf.equalsIgnoreCase("Alagoas"))
			uf = "AL";
		if(uf.equalsIgnoreCase("Amapá"))
			uf = "AP";
		if(uf.equalsIgnoreCase("Amazonas"))
			uf = "AM";
		if(uf.equalsIgnoreCase("Bahia"))
			uf = "BA";
		if(uf.equalsIgnoreCase("Ceará"))
			uf = "CE";
		if(uf.equalsIgnoreCase("Distrito Federal"))
			uf = "DF";
		if(uf.equalsIgnoreCase("Espírito Santo"))
			uf = "ES";
		if(uf.equalsIgnoreCase("Goiás"))
			uf = "GO";
		if(uf.equalsIgnoreCase("Maranhão"))
			uf = "MA";
		if(uf.equalsIgnoreCase("Mato Grosso"))
			uf = "MT";
		if(uf.equalsIgnoreCase("Mato Grosso do Sul"))
			uf = "MS";
		if(uf.equalsIgnoreCase("Minas Gerais"))
			uf = "MG";
		if(uf.equalsIgnoreCase("Pará"))
			uf = "PA";
		if(uf.equalsIgnoreCase("Paraíba"))
			uf = "PB";
		if(uf.equalsIgnoreCase("Paraná"))
			uf = "PR";
		if(uf.equalsIgnoreCase("Pernambuco"))
			uf = "PE";
		if(uf.equalsIgnoreCase("Piauí"))
			uf = "PI";
		if(uf.equalsIgnoreCase("Rio de Janeiro"))
			uf = "RJ";
		if(uf.equalsIgnoreCase("Rio Grande do Norte"))
			uf = "RN";
		if(uf.equalsIgnoreCase("Rio Grande do Sul"))
			uf = "RS";
		if(uf.equalsIgnoreCase("Rondônia"))
			uf = "RO";
		if(uf.equalsIgnoreCase("Roraima"))
			uf = "RR";
		if(uf.equalsIgnoreCase("Santa Catarina"))
			uf = "SC";
		if(uf.equalsIgnoreCase("São Paulo"))
			uf = "SP";
		if(uf.equalsIgnoreCase("Sergipe"))
			uf = "SE";
		if(uf.equalsIgnoreCase("Tocantins"))
			uf = "TO";
			return uf;
		}
	

	public boolean atualizarDadosDaPesquisa(String ano, String sigla, String numero, String dataIni,
			String nomeAutor, String siglaPartido, String uf) {

		if (ano == null) {
			ano = "";
		}
		if (sigla == null) {
			sigla = "";
		}
		if (numero == null) {
			numero = "";
		}
		if (dataIni == null) {
			dataIni = "";
		}
		if (nomeAutor == null) {
			nomeAutor = "";
		}
		if (siglaPartido == null) {
			siglaPartido = "";
		}
		if (uf == null) {
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
