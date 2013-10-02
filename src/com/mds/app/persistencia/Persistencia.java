package com.mds.app.persistencia;

import java.util.ArrayList;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class Persistencia {

	public Persistencia() {
		
	}
	
	public static ArrayList<ParlamentarModel> instanciarParlamentares(){
		
		ArrayList<ParlamentarModel> arrayParlamentar = new ArrayList<ParlamentarModel>();
		
		ParlamentarModel parlamentar1 = new ParlamentarModel();
		ParlamentarModel parlamentar2 = new ParlamentarModel();
		ParlamentarModel parlamentar3 = new ParlamentarModel();
		ParlamentarModel parlamentar4 = new ParlamentarModel();
		arrayParlamentar.add(parlamentar1);
		arrayParlamentar.add(parlamentar2);
		arrayParlamentar.add(parlamentar3);
		arrayParlamentar.add(parlamentar4);
		
		return arrayParlamentar;
	}
	
	public static ArrayList<PartidoModel> instanciarPartidos(){
		
		ArrayList<PartidoModel> arrayPartido = new ArrayList<PartidoModel>();
		
		PartidoModel partido1 = new PartidoModel();
		PartidoModel partido2 = new PartidoModel();
		PartidoModel partido3 = new PartidoModel();
		PartidoModel partido4 = new PartidoModel();
		arrayPartido.add(partido1);
		arrayPartido.add(partido2);
		arrayPartido.add(partido3);
		arrayPartido.add(partido4);
		
		return arrayPartido;
	}
	
	public static ArrayList<ProjetoModel> instanciarProjetos(){
		
		ArrayList<ProjetoModel> arrayProjeto = new ArrayList<ProjetoModel>();
		
		ProjetoModel projeto1 = new ProjetoModel();
		ProjetoModel projeto2 = new ProjetoModel();
		ProjetoModel projeto3 = new ProjetoModel();
		ProjetoModel projeto4 = new ProjetoModel();
		arrayProjeto.add(projeto1);
		arrayProjeto.add(projeto2);
		arrayProjeto.add(projeto3);
		arrayProjeto.add(projeto4);
		
		return arrayProjeto;
	}

}
