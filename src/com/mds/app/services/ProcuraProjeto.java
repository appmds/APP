package com.mds.app.services;

import java.util.ArrayList;

import android.util.Log;

import com.mds.app.model.ProcuraProjetoModel;
import com.mds.app.model.ProjetoModel;

public class ProcuraProjeto extends Endereco {

	public ArrayList<ProjetoModel> procurar() {
		ArrayList<ProjetoModel> listaProjetos = receberListaProjetos();
		return listaProjetos;
	}

	public ArrayList<ProjetoModel> procurar(int maxResultados) {
		ArrayList<ProjetoModel> listaProjetos = receberListaProjetos();
		return ReceberPrimeirosResultados(listaProjetos, maxResultados);
	}

	private ArrayList<ProjetoModel> receberListaProjetos() {
		String sigla = ProcuraProjetoModel.getSigla();
		String ano = ProcuraProjetoModel.getAno();
		String dataIni = ProcuraProjetoModel.getDataInicio();

		String url = construirEndereco(sigla, "", ano, dataIni, "", "", "", "", "", "", "", "");
		System.out.println(url);
		String response = recebeHTTP.recebe(url);
		Log.d(getClass().getSimpleName(), response);
		return xmlParser.parseProjeto(response);
	}

}
