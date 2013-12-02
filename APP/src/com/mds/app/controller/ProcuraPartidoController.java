package com.mds.app.controller;

import com.mds.app.model.ProcuraPartidoModel;

public class ProcuraPartidoController {

	public ProcuraPartidoController() {

	}

	public static void atualizaDadosPesquisaPartido(String uf, String siglaPartido) {

		ProcuraPartidoModel.setUf(uf);
		ProcuraPartidoModel.setSigla(siglaPartido);

	}

}
