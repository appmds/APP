package com.mds.app.controller;

import java.util.ArrayList;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.persistencia.Persistencia;

public class ParlamentarController {

	public ParlamentarController() {

	}

	ArrayList<ParlamentarModel> parlamentaresInstanciados = Persistencia.instanciarParlamentares();

}
