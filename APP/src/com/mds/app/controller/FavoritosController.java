package com.mds.app.controller;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;
import com.mds.app.persistencia.Persistencia;

public class FavoritosController implements AlteraArquivos {

	private static ArrayList<ProjetoModel> projetosFavoritados = new ArrayList<ProjetoModel>();
	private static ArrayList<String> projetosFavoritadosCompletoStr = new ArrayList<String>();

	private Persistencia persistencia;

	public FavoritosController(Context context) {
		persistencia = new Persistencia(context);
	}

	public FavoritosController() {

	}

	@Override
	public void adicionar(ProjetoModel projeto, String conteudo) {
		if (!projetosFavoritadosCompletoStr.contains(conteudo)) {
			if (!projetosFavoritados.contains(projeto)) {
				projetosFavoritadosCompletoStr.add(conteudo);
				projetosFavoritados.add(projeto);

				persistencia.escreverNoArquivo(Persistencia.getFileNameFavoritos(), conteudo);
			}
			else {
				System.out.println("ELSE DENTRO ADICIONAR FAVORITOS");
			}
		}
		else {
			// Projeto ja existe no arquivo dos favoritos, nao tem como
			// favoritar de novo
			Log.i("ADICIONAR", "ELSE ADICIONAR FAVORITOS");
		}
	}

	@Override
	public void remover(ProjetoModel projeto, String stringProjeto) {
		if (projetosFavoritadosCompletoStr.contains(stringProjeto)) {
			if (projetosFavoritados.contains(projeto)) {
				projetosFavoritadosCompletoStr.remove(stringProjeto);
				projetosFavoritados.remove(projeto);
				String conteudoArquivo = projetosEmString();
				persistencia.reescreverArquivo(Persistencia.getFileNameFavoritos(), conteudoArquivo);
			}
			else {
				System.out.println("ELSE DENTRO REMOVER FAVORITOS");
			}
		}
		else {
			// mesma coisa
			// Log.i("LOGGER", "ELSE REMOVER FAVORITOS");
			System.out.println("ELSE REMOVER FAVORITOS");
		}
	}

	@Override
	public String projetosEmString() {
		String conteudoProjetosFavoritados = "";

		for (int i = 0; i < projetosFavoritadosCompletoStr.size(); i++) {
			conteudoProjetosFavoritados += projetosFavoritadosCompletoStr.get(i);
		}

		return conteudoProjetosFavoritados;
	}

	@Override
	public void popularProjetos(String strConteudoFavoritos) {
		ArrayList<String> splitParts;

		// Log.i("POPPROJ-F", "Conteudo favoritos:");

		final int separadoresPorProjeto = 9;
		final int numeroDeProjetosNoArquivo;
		int numeroDeSeparadores = 0;
		projetosFavoritados = new ArrayList<ProjetoModel>();

		if (strConteudoFavoritos.contains("~")) {
			for (int i = 0; i < strConteudoFavoritos.length(); i++) {
				if (strConteudoFavoritos.charAt(i) == '~') {
					numeroDeSeparadores++;
				}
			}
			// Log.i("POPPROJ-F", "Separadores: " + numeroDeSeparadores);

			numeroDeProjetosNoArquivo = (numeroDeSeparadores / separadoresPorProjeto);
			// Log.i("POPPROJ-F", "Numero de projetos: " + numeroDeProjetosNoArquivo);

			for (int i = 0; i < numeroDeProjetosNoArquivo; i++) {
				splitParts = new ArrayList<String>(numeroDeSeparadores);
				String[] parts = strConteudoFavoritos.split("~");

				for (int j = 0; j < separadoresPorProjeto; j++) {
					splitParts.add(j, parts[j + (separadoresPorProjeto * i)]);
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

				projetosFavoritados.add(projeto);

				// Log.i("POPPROJ-F", "Adicionando: " + projeto.toString());
			}
		}
		else {
			// Log.i("POPPROJ-F", "Favoritos esta vazio");
		}

		popularListaComProjetos();
	}

	@Override
	public void popularListaComProjetos() {
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
			// Log.i("POPSTR-F", "Favoritos esta vazio");
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
