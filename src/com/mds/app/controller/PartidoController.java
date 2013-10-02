package com.mds.app.controller;

import java.util.ArrayList;

import com.mds.app.model.PartidoModel;
import com.mds.app.persistencia.Persistencia;

public class PartidoController {

	public PartidoController() {

	}

	ArrayList<PartidoModel> partidosInstanciados = Persistencia.instanciarPartidos();
	
}
