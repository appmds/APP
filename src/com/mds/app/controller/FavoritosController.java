package com.mds.app.controller;

import java.util.ArrayList;

import android.util.Log;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;
import com.mds.app.persistencia.Persistencia;

public class FavoritosController {

	private static ArrayList<ProjetoModel> projetosFavoritados = new ArrayList<ProjetoModel>();
	private static ArrayList<String> projetosFavoritadosCompletoStr = new ArrayList<String>();

	public FavoritosController() {

	}

	public void adicionarFavorito(ProjetoModel projeto, String conteudo) {
		if (!projetosFavoritadosCompletoStr.contains(conteudo) && !projetosFavoritados.contains(projeto)) {
			projetosFavoritadosCompletoStr.add(conteudo);
			projetosFavoritados.add(projeto);
			Persistencia.writeToFile(Persistencia.getFileFavoritos(), conteudo);
		}
		else {
			// Projeto ja existe no arquivo dos favoritos, nao tem como favoritar de novo
		}
	}

	public void removerFavorito(ProjetoModel projeto, String stringProjeto) {
		if (projetosFavoritadosCompletoStr.contains(stringProjeto) && projetosFavoritados.contains(projeto)) {
			projetosFavoritadosCompletoStr.remove(stringProjeto);
			String conteudoArquivo = projetosFavoritadosEmString();
			Persistencia.rewriteFile(Persistencia.getFileFavoritos(), conteudoArquivo);
		}
		else {
			// mesma coisa
		}
	}

	private String projetosFavoritadosEmString() {
		String conteudoProjetosFavoritados = "";

		for (int i = 0; i < projetosFavoritadosCompletoStr.size(); i++) {
			conteudoProjetosFavoritados += projetosFavoritadosCompletoStr.get(i);
		}

		return conteudoProjetosFavoritados;
	}

	public static void popularProjetosFavoritados() {
		ArrayList<String> splitParts;
		String strConteudoFavoritos = Persistencia.readFromFile(Persistencia.getFileFavoritos());

		Log.i("LOGGER", "STRCONTFV: " + strConteudoFavoritos);

		final int separadoresPorProjeto = 9;
		final int numeroDeProjetosNoArquivo;
		int numeroDeSeparadores = 0;

		if (strConteudoFavoritos.contains("~")) {
			for (int i = 0; i < strConteudoFavoritos.length(); i++) {
				if (strConteudoFavoritos.charAt(i) == '~') {
					numeroDeSeparadores++;
				}
			}
			System.out.println("separators: " + numeroDeSeparadores);
			numeroDeProjetosNoArquivo = 1 + (numeroDeSeparadores % separadoresPorProjeto);
			Log.i("LOGGER", String.valueOf(numeroDeProjetosNoArquivo));

			for (int i = 0; i < numeroDeProjetosNoArquivo; i++) {
				splitParts = new ArrayList<String>(numeroDeSeparadores);
				String[] parts = strConteudoFavoritos.split("~");

				for (int j = 0; j < separadoresPorProjeto; j++) {
					splitParts.add(j, parts[j]);
				}

				String siglaPartido = splitParts.get(7);
				String ufPartido = splitParts.get(8);
				String nomeParlamentar = splitParts.get(6);
				String nomeProjeto = splitParts.get(0);
				String numeroProjeto = splitParts.get(1);
				String anoProjeto = splitParts.get(2);
				String siglaProjeto = splitParts.get(3);
				String dataProjeto = splitParts.get(4);
				String explicacaoProjeto = splitParts.get(5);

				PartidoModel partido = new PartidoModel(siglaPartido, ufPartido);
				ParlamentarModel parlamentar = new ParlamentarModel(nomeParlamentar, partido);
				ProjetoModel projeto = new ProjetoModel(anoProjeto, nomeProjeto, siglaProjeto, dataProjeto,
						numeroProjeto, explicacaoProjeto, parlamentar);

				projetosFavoritados = new ArrayList<ProjetoModel>();
				projetosFavoritados.add(i, projeto);

				Log.i("LOGGER", projeto.toString());
			}
		}
		else {
			Log.i("LOGGER", "Favoritos esta vazio");
		}
		popularListaStringComProjetos();
	}

	private static void popularListaStringComProjetos() {
		if (!(projetosFavoritados == null)) {
			for (int i = 0; i < projetosFavoritados.size(); i++) {
				String stringProjeto = "";
				stringProjeto += projetosFavoritados.get(i).getNome();
				stringProjeto += "\nNumero: ";
				stringProjeto += projetosFavoritados.get(i).getNumero();
				stringProjeto += "\nAno:  ";
				stringProjeto += projetosFavoritados.get(i).getAno();
				stringProjeto += "\nSigla: ";
				stringProjeto += projetosFavoritados.get(i).getSigla();
				stringProjeto += "\nData de Apresentação: ";
				stringProjeto += projetosFavoritados.get(i).getData();
				stringProjeto += "\nDescrição: ";
				stringProjeto += projetosFavoritados.get(i).getExplicacao();
				stringProjeto += "\nParlamentar: ";
				stringProjeto += projetosFavoritados.get(i).getParlamentar().getNome();
				stringProjeto += "\nPartido: ";
				stringProjeto += projetosFavoritados.get(i).getParlamentar().getPartido().getSiglaPartido();
				stringProjeto += "\nEstado: ";
				stringProjeto += projetosFavoritados.get(i).getParlamentar().getPartido().getUf();
				projetosFavoritadosCompletoStr.add(i, stringProjeto);
			}
		}
		else {
			Log.i("LOGGER", "Favoritos esta vazio");
		}
	}

	public static ArrayList<ProjetoModel> getProjetosFavoritados() {
		return projetosFavoritados;
	}

	public static void setProjetosFavoritados(ArrayList<ProjetoModel> projetosFavoritados) {
		FavoritosController.projetosFavoritados = projetosFavoritados;
	}

	public static ArrayList<String> getProjetosFavoritadosCompletoStr() {
		return projetosFavoritadosCompletoStr;
	}

	public static void setProjetosFavoritadosCompletoStr(ArrayList<String> projetosFavoritadosCompletoStr) {
		FavoritosController.projetosFavoritadosCompletoStr = projetosFavoritadosCompletoStr;
	}

}
