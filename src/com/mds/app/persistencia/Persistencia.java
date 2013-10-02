package com.mds.app.persistencia;

import java.util.ArrayList;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public abstract class Persistencia {

	public Persistencia() {
		
	}
	
	public ArrayList<ArrayList> instanciar(){
	
		ArrayList<ParlamentarModel> arrayParlamentar = new ArrayList<ParlamentarModel>();
		ArrayList<PartidoModel> arrayPartido = new ArrayList<PartidoModel>();
		ArrayList<ProjetoModel> arrayProjeto = new ArrayList<ProjetoModel>();
		ArrayList<ArrayList> arrayFinal = new ArrayList<ArrayList>();
		
		ParlamentarModel parlamentar1 = new ParlamentarModel();
		ParlamentarModel parlamentar2 = new ParlamentarModel();
		ParlamentarModel parlamentar3 = new ParlamentarModel();
		ParlamentarModel parlamentar4 = new ParlamentarModel();
		arrayParlamentar.add(parlamentar1);
		arrayParlamentar.add(parlamentar2);
		arrayParlamentar.add(parlamentar3);
		arrayParlamentar.add(parlamentar4);
		
		PartidoModel partido1 = new PartidoModel();
		PartidoModel partido2 = new PartidoModel();
		PartidoModel partido3 = new PartidoModel();
		PartidoModel partido4 = new PartidoModel();
		arrayPartido.add(partido1);
		arrayPartido.add(partido2);
		arrayPartido.add(partido3);
		arrayPartido.add(partido4);
		
		ProjetoModel projeto1 = new ProjetoModel();
		ProjetoModel projeto2 = new ProjetoModel();
		ProjetoModel projeto3 = new ProjetoModel();
		ProjetoModel projeto4 = new ProjetoModel();
		arrayProjeto.add(projeto1);
		arrayProjeto.add(projeto2);
		arrayProjeto.add(projeto3);
		arrayProjeto.add(projeto4);
		
		arrayFinal.add(arrayParlamentar);
		arrayFinal.add(arrayPartido);
		arrayFinal.add(arrayProjeto);
		
		return arrayFinal;
		
	}

}
