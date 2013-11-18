package com.mds.app.controller;

import java.util.ArrayList;

import com.mds.app.persistencia.Persistencia;

public class FavoritosController {

	private static ArrayList<String> projetosFavoritados = new ArrayList<String>();
	private static ArrayList<String> projetosFavoritadosCompleto = new ArrayList<String>();

	public FavoritosController() {

	}

	public void adicionarFavorito(String conteudo) {
		if (!projetosFavoritados.contains(conteudo)) {
			projetosFavoritados.add(conteudo);
			Persistencia.writeToFile(Persistencia.getFileFavoritos(), conteudo);
		}
		else {
			// Projeto ja existe no arquivo dos favoritos, nao tem como favoritar de novo
		}
	}

	public void removerFavorito(String stringProjeto) {
		if(projetosFavoritados.contains(stringProjeto)){
			projetosFavoritados.remove(stringProjeto);
			String conteudoArquivo = projetosFavoritadosEmString();
			Persistencia.rewriteFile(Persistencia.getFileFavoritos(), conteudoArquivo);
		}
		else{
			//mesma coisa
		}
	}

	private String projetosFavoritadosEmString() {
		String conteudoProjetosFavoritados = "";
		
		for(int i = 0; i<projetosFavoritados.size(); i++){
			conteudoProjetosFavoritados += projetosFavoritados.get(i);
		}
		
		return conteudoProjetosFavoritados;
	}

	public static ArrayList<String> getProjetosFavoritados() {
		return projetosFavoritados;
	}

	public static void setProjetosFavoritados(ArrayList<String> projetosFavoritados) {
		FavoritosController.projetosFavoritados = projetosFavoritados;
	}

	public static ArrayList<String> getProjetosFavoritadosCompleto() {
		return projetosFavoritadosCompleto;
	}

	public static void setProjetosFavoritadosCompleto(ArrayList<String> projetosFavoritadosCompleto) {
		FavoritosController.projetosFavoritadosCompleto = projetosFavoritadosCompleto;
	}

}
