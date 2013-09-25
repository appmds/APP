package com.mds.app.controller;

import com.mds.app.model.ProcuraProjetoModel;

public class ProjetoController {

	public ProjetoController(){
		
		
	}
	
	public void atualizaDadosPesquisa(String ano, String sigla){
		int anoI = Integer.parseInt(ano);
		ProcuraProjetoModel.setAno(anoI);
		ProcuraProjetoModel.setSigla(sigla);
		System.out.println(anoI + sigla);
	}
}
