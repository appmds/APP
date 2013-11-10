package com.mds.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.mds.app.model.ProjetoModel;
import com.mds.app.view.Lista;

public class ListaController {

	private List<ProjetoModel> listaProjetos;
	private ArrayList<String> stringProjetos;
	private Lista lista;

	public ListaController(List<ProjetoModel> result) {
		this.listaProjetos = result;
		this.stringProjetos = new ArrayList<String>();
		transformarLista();
	}

	public ListaController(String string) {
	}

	public List<ProjetoModel> getListaProjetos() {
		return listaProjetos;
	}

	public void setListaProjetos(List<ProjetoModel> listaProjetos) {
		this.listaProjetos = listaProjetos;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public ArrayList<String> getStringProjetos() {
		return stringProjetos;
	}

	public void setStringProjetos(ArrayList<String> stringProjetos) {
		this.stringProjetos = stringProjetos;
	}

	// Transforma List<ProjetoModel> listaProjetos em um ArrayList<String>
	private void transformarLista() {
		for (int i = 0; i < listaProjetos.size(); i++) {
			String stringProjeto = "";
			stringProjeto += listaProjetos.get(i).getNome();
			stringProjeto += " - ";
			stringProjeto += listaProjetos.get(i).getNumero();
			stringProjeto += " - ";
			stringProjeto += listaProjetos.get(i).getParlamentar().getNome();
			stringProjetos.add(stringProjeto);
		}
	}

	public String getLista(String string) {
		return string;
	}
	public void setLista(String string) {

	}

}
