package com.mds.app.controller;

import java.util.ArrayList;

import com.mds.app.persistencia.Persistencia;

public class FavoritosController {

	private static ArrayList<String> projetosFavoritadosCompleto = new ArrayList<String>();

	public FavoritosController() {

	}

	public void adicionarFavorito(String conteudo) {
		if (!projetosFavoritadosCompleto.contains(conteudo)) {
			projetosFavoritadosCompleto.add(conteudo);
			Persistencia.writeToFile(Persistencia.getFileFavoritos(), conteudo);
		}
		else {
			// Projeto ja existe no arquivo dos favoritos, nao tem como favoritar de novo
		}
	}

	public void removerFavorito(String stringProjeto) {
		if(projetosFavoritadosCompleto.contains(stringProjeto)){
			projetosFavoritadosCompleto.remove(stringProjeto);
			String conteudoArquivo = projetosFavoritadosEmString();
			Persistencia.rewriteFile(Persistencia.getFileFavoritos(), conteudoArquivo);
		}
		else{
			//mesma coisa
		}
	}

	private String projetosFavoritadosEmString() {
		String conteudoProjetosFavoritados = "";
		
		for(int i = 0; i<projetosFavoritadosCompleto.size(); i++){
			conteudoProjetosFavoritados += projetosFavoritadosCompleto.get(i);
		}
		
		return conteudoProjetosFavoritados;
	}

	public static ArrayList<String> getProjetosFavoritados() {
		return projetosFavoritadosCompleto;
	}

	public static void setProjetosFavoritados(ArrayList<String> projetosFavoritados) {
		FavoritosController.projetosFavoritadosCompleto = projetosFavoritados;
	}

	public static ArrayList<String> getProjetosFavoritadosCompleto() {
		return projetosFavoritadosCompleto;
	}

	public static void setProjetosFavoritadosCompleto(ArrayList<String> projetosFavoritadosCompleto) {
		FavoritosController.projetosFavoritadosCompleto = projetosFavoritadosCompleto;
	}

}
