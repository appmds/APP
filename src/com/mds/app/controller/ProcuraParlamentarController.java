package com.mds.app.controller;

import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarController {

	public ProcuraParlamentarController() {
	}
	
	public static void atualizarDadosPesquisaParlamentar(String nomeAutor){
		
		ProcuraParlamentarModel.setNome(nomeAutor);
			
	}

}
