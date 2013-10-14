package com.mds.app.controller;

import java.util.ArrayList;

import com.mds.app.model.ProjetoModel;
import com.mds.app.persistencia.Persistencia;

public class ProjetoController {

	public ProjetoController() {
	}

	ArrayList<ProjetoModel> projetosInstanciados = Persistencia.instanciarProjetos();

}
