package com.mds.app.model;

import java.util.ArrayList;

public abstract class ProcuraPartidoModel {

	private ArrayList<ParlamentarModel> parlamentares;

	public ArrayList<ParlamentarModel> getParlamentares() {
		return parlamentares;
	}

	public void setParlamentares(ArrayList<ParlamentarModel> parlamentares) {
		this.parlamentares = parlamentares;
	}

}
