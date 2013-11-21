package com.mds.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.mds.app.model.ProjetoModel;

public class ListaController {

	private static final String SEPARADOR = "~";
	private static List<ProjetoModel> listaProjetos;
	private static ProjetoModel projetoAtual;

	public ListaController() {
	}

	public ListaController(List<ProjetoModel> result) {
		setListaProjetos(result);
	}

	/* Transforma List<ProjetoModel> listaProjetos em um ArrayList<String> */
	public ArrayList<String> transformarLista() {
		ArrayList<String> stringProjetos = new ArrayList<String>();

		if (getListaProjetos() != null) {
			for (int i = 0; i < getListaProjetos().size(); i++) {
				String stringProjeto = "";
				stringProjeto += getListaProjetos().get(i).getNome();
				stringProjeto += " - ";
				stringProjeto += getListaProjetos().get(i).getNumero();
				stringProjeto += " - ";
				stringProjeto += getListaProjetos().get(i).getParlamentar()
						.getNome();
				stringProjetos.add(stringProjeto);
			}
		} else {
			String stringProjeto = "Nada encontrado.";
			stringProjetos.add(stringProjeto);
		}

		return stringProjetos;
	}

	public String getStringCompletaParaPerfil() {
		String stringProjeto = "";

		if (getProjetoAtual() != null) {
			stringProjeto += getProjetoAtual().getNome();
			stringProjeto += "\nNumero: ";
			stringProjeto += getProjetoAtual().getNumero();
			stringProjeto += "\nAno:  ";
			stringProjeto += getProjetoAtual().getAno();
			stringProjeto += "\nSigla: ";
			stringProjeto += getProjetoAtual().getSigla();
			stringProjeto += "\nData de Apresentação: ";
			stringProjeto += getProjetoAtual().getData();
			stringProjeto += "\nDescrição: ";
			stringProjeto += getProjetoAtual().getExplicacao();
			stringProjeto += "\nParlamentar: ";
			stringProjeto += getProjetoAtual().getParlamentar().getNome();
			stringProjeto += "\nPartido: ";
			stringProjeto += getProjetoAtual().getParlamentar().getPartido()
					.getSiglaPartido();
			stringProjeto += "\nEstado: ";
			stringProjeto += getProjetoAtual().getParlamentar().getPartido()
					.getUf();
		} else {
			stringProjeto = "Nada encontrado.";
		}

		return stringProjeto;

	}

	public String getStringCompletaParaArquivo() {
		String stringProjeto = "";

		if (getProjetoAtual() != null) {
			stringProjeto += getProjetoAtual().getNome();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getNumero();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getAno();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getSigla();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getData();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getExplicacao();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getParlamentar().getNome();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getParlamentar().getPartido()
					.getSiglaPartido();
			stringProjeto += SEPARADOR;
			stringProjeto += getProjetoAtual().getParlamentar().getPartido()
					.getUf();
			stringProjeto += SEPARADOR;
		} else {
			stringProjeto = null;
		}

		return stringProjeto;
	}

	public static List<ProjetoModel> getListaProjetos() {
		return listaProjetos;
	}

	public static void setListaProjetos(List<ProjetoModel> novaListaProjetos) {
		listaProjetos = novaListaProjetos;
	}

	public static ProjetoModel getProjetoAtual() {
		return projetoAtual;
	}

	public static void setProjetoAtual(ProjetoModel projetoAtual) {
		ListaController.projetoAtual = projetoAtual;
	}

	public static String getSeparador() {
		return SEPARADOR;
	}

}
