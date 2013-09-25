package com.mds.app.model;

import java.util.List;

public class PartidoModel {

	List<ParlamentarModel> parlamentares;
	
	
	public PartidoModel(List<ParlamentarModel> parlamentares){
		
		this.parlamentares = parlamentares;		
	}
	
	public PartidoModel(){
		
	}

	public List<ParlamentarModel> getParlamentares() {
		return parlamentares;
	}

	public void setParlamentares(List<ParlamentarModel> parlamentares) {
		this.parlamentares = parlamentares;
	}
	
}
