package com.mds.app.controller;

import com.mds.app.model.ProcuraProjetoModel;

public class ProcuraProjetoController {

	public ProcuraProjetoController() {
	}

	public static void atualizarDadosPesquisaProjeto(String ano, String sigla, String numero, String dataIni){
		
		ProcuraProjetoModel.setAno(ano);
		ProcuraProjetoModel.setSigla(sigla);
		ProcuraProjetoModel.setId(numero);
		ProcuraProjetoModel.setDataInicio(dataIni);
		
		
		
	}

}
