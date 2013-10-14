package com.mds.app.controller;

import java.util.ArrayList;

import android.util.Log;

import com.mds.app.model.ProcuraParlamentarModel;
import com.mds.app.model.ProcuraPartidoModel;
import com.mds.app.model.ProcuraProjetoModel;
import com.mds.app.model.ProjetoModel;
import com.mds.app.services.Endereco;
import com.mds.app.services.RecebeHTTP;
import com.mds.app.services.XMLParser;

public class BuscaController {

	private RecebeHTTP recebeHTTP = new RecebeHTTP();
	private XMLParser xmlParser = new XMLParser();
	
	public BuscaController() {
		
	}
	
	public void atualizarDadosDaPesquisa(String ano, String sigla, String numero, String dataIni, String nomeAutor, String siglaPartido, String uf) {

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
		
		ProcuraProjetoController.atualizarDadosPesquisaProjeto(ano, sigla, numero, dataIni);
		ProcuraPartidoController.atualizaDadosPesquisaPartido(uf, siglaPartido);
		ProcuraParlamentarController.atualizarDadosPesquisaParlamentar(nomeAutor);
	}
	
	public ArrayList<ProjetoModel> procurar() {
		ArrayList<ProjetoModel> listaProjetos = receberListaProjetos();
		return listaProjetos;
	}

	private ArrayList<ProjetoModel> receberListaProjetos() {
		String sigla = ProcuraProjetoModel.getSigla().toUpperCase();
		String ano = ProcuraProjetoModel.getAno();
		String dataInicio = ProcuraProjetoModel.getDataInicio();
		String numero = ProcuraProjetoModel.getId();
		String nomeAutor = ProcuraParlamentarModel.getNome();
		String siglaPartido = ProcuraPartidoModel.getSigla();
		String siglaUF = ProcuraPartidoModel.getUf();
			
		String url = Endereco.construirEndereco(sigla, numero, ano, dataInicio, "", "", nomeAutor, siglaPartido, siglaUF, "", "", "");
		System.out.println(url);
		String response = recebeHTTP.recebe(url);
		Log.d(getClass().getSimpleName(), response);
		return xmlParser.parseProjeto(response);
	}

}
