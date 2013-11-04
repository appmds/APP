package com.mds.app.controller;

import java.util.ArrayList;

import android.util.Log;

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

	private RecebeHTTP recebeHTTP = new RecebeHTTP();
	private XMLParser xmlParser = new XMLParser();
	private Busca buscaView;
	private boolean temConexao;
	private String textoOffline;
	
	public BuscaController() {
		this.buscaView = new Busca();
	}
	
	public boolean atualizarDadosDaPesquisa(String ano, String sigla, String numero, String dataIni, String nomeAutor, String siglaPartido, String uf) {	
		
		if (ano==null)
			ano = "";
		if (sigla==null)
			sigla = "";
		if (numero==null)
			numero = "";
		if (dataIni==null)
			dataIni = "";
		if (nomeAutor==null)
			nomeAutor = "";
		if (siglaPartido==null)
			siglaPartido = "";
		if (uf==null)
			uf = "";
		
		String erros = "";
		erros = ValidaEntrada.identificarErros(ano, sigla, numero, dataIni, nomeAutor, siglaPartido, uf);
		System.out.println(erros);
		System.out.println(dataIni);
		
		if (erros==""){
			ProcuraProjetoController.atualizarDadosPesquisaProjeto(ano, sigla, numero, dataIni);
			ProcuraPartidoController.atualizaDadosPesquisaPartido(uf, siglaPartido);
			ProcuraParlamentarController.atualizarDadosPesquisaParlamentar(nomeAutor);
			return true;
		}
		else{
			
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
			
		String url = Endereco.construirEndereco(sigla, numero, ano, dataInicio, "", "", nomeAutor, siglaPartido, siglaUF, "", "", "");
		System.out.println(url);
		String response;
		if(temConexao)
			response = recebeHTTP.recebe(url);
		else
			response = textoOffline;
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
