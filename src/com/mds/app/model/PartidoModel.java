package com.mds.app.model;

import java.util.ArrayList;

public class PartidoModel {

	private ArrayList<ParlamentarModel> parlamentares;

	public PartidoModel() {

	}

	public PartidoModel(ArrayList<ParlamentarModel> parlamentares) {
		this.parlamentares = parlamentares;
	}

	public ArrayList<ParlamentarModel> getParlamentares() {
		return parlamentares;
	}

	public void setParlamentares(ArrayList<ParlamentarModel> parlamentares) {
		this.parlamentares = parlamentares;
	}
	
	public void addParlamentar(ParlamentarModel parlamentar) {
		this.parlamentares.add(parlamentar);
	}

}
