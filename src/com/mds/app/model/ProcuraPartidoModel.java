package com.mds.app.model;

import java.util.List;

public abstract class ProcuraPartidoModel {

	List<ParlamentarModel> parlamentares;

	public List<ParlamentarModel> getParlamentares() {
		return parlamentares;
	}

	public void setParlamentares(List<ParlamentarModel> parlamentares) {
		this.parlamentares = parlamentares;
	}
	
}
