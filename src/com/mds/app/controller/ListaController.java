package com.mds.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.mds.app.model.ProjetoModel;
import com.mds.app.view.Lista;

public class ListaController {

	private List<ProjetoModel> listaProjetos;
	private ArrayList<String> stringProjetos;
	private ArrayList<String> stringProjetosCompleto;
	private Lista lista;

	public ListaController(List<ProjetoModel> result) {
		this.listaProjetos = result;
		this.stringProjetos = new ArrayList<String>();
		this.stringProjetosCompleto = new ArrayList<String>();
		transformarLista();
		transformarListaCompleto();
	}

	public ListaController() {
		this.listaProjetos = null;
		this.stringProjetos = new ArrayList<String>();
		this.stringProjetosCompleto = new ArrayList<String>();
	}

	/* Transforma List<ProjetoModel> listaProjetos em um ArrayList<String> */
	public void transformarLista() {
		String stringProjeto = "";
		if (this.getListaProjetos() != null) {
			for (int i = 0; i < listaProjetos.size(); i++) {
				stringProjeto += listaProjetos.get(i).getNome();
				stringProjeto += " - ";
				stringProjeto += listaProjetos.get(i).getNumero();
				stringProjeto += " - ";
				stringProjeto += listaProjetos.get(i).getParlamentar().getNome();
				stringProjetos.add(stringProjeto);
			}
		}
		else {
			stringProjeto = "Nada encontrado.";
			stringProjetos.add(stringProjeto);
		}
	}
	
	public void transformarListaCompleto() {
		String stringProjeto = "";
		if (this.getListaProjetos() != null) {
			for (int i = 0; i < listaProjetos.size(); i++) {
				stringProjeto += listaProjetos.get(i).getNome();
				stringProjeto += "\nNumero: ";
				stringProjeto += listaProjetos.get(i).getNumero();
				stringProjeto += "\nAno:  ";
				stringProjeto += listaProjetos.get(i).getAno();
				stringProjeto += "\nSigla: ";
				stringProjeto += listaProjetos.get(i).getSigla();
				stringProjeto += "\nData de Apresentação: ";
				stringProjeto += listaProjetos.get(i).getData();
				stringProjeto += "\nDescrição: ";
				stringProjeto += listaProjetos.get(i).getExplicacao();
				stringProjeto += "\nParlamentar: ";
				stringProjeto += listaProjetos.get(i).getParlamentar().getNome();
				stringProjeto += "\nPartido: ";
				stringProjeto += listaProjetos.get(i).getParlamentar().getPartido().getSiglaPartido();
				stringProjeto += "\nEstado: ";
				stringProjeto += listaProjetos.get(i).getParlamentar().getPartido().getUf();
				stringProjetosCompleto.add(stringProjeto);
			}
		}
		else {
			stringProjeto = "Nada encontrado.";
			stringProjetosCompleto.add(stringProjeto);
		}
	}

	public List<ProjetoModel> getListaProjetos() {
		return listaProjetos;
	}

	public void setListaProjetos(List<ProjetoModel> listaProjetos) {
		this.listaProjetos = listaProjetos;
	}

	public ArrayList<String> getStringProjetos() {
		return stringProjetos;
	}

	public void setStringProjetos(ArrayList<String> stringProjetos) {
		this.stringProjetos = stringProjetos;
	}

	public ArrayList<String> getStringProjetosCompleto() {
		return stringProjetosCompleto;
	}

	public void setStringProjetosCompleto(ArrayList<String> stringProjetosCompleto) {
		this.stringProjetosCompleto = stringProjetosCompleto;
	}

}
