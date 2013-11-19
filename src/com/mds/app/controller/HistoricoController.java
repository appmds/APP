package com.mds.app.controller;

import java.util.ArrayList;

import android.util.Log;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;
import com.mds.app.persistencia.Persistencia;

public class HistoricoController implements AlteraArquivos {

	private static final int MAX_PROJETOS = 2;
	private static ArrayList<ProjetoModel> projetosHistorico = new ArrayList<ProjetoModel>(MAX_PROJETOS);
	private static ArrayList<String> projetosHistoricoCompletoStr = new ArrayList<String>();

	@Override
	public void adicionar(ProjetoModel projeto, String conteudo) {
		if (!projetosHistoricoCompletoStr.contains(conteudo) && !projetosHistorico.contains(projeto)) {
			projetosHistoricoCompletoStr.add(conteudo);
			projetosHistorico.add(projeto);
			Persistencia.writeToFile(Persistencia.getFileHistorico(), conteudo);
		}
		else {
			// projeto que ja existe foi visto, e portanto pula pro "final da fila"
			Log.i("LOGGER", "ELSE ADICIONAR HISTORICO");
			projetosHistorico.remove(projeto);
			ArrayList<ProjetoModel> atualizadaProjetosHistorico = new ArrayList<ProjetoModel>(MAX_PROJETOS);
			atualizadaProjetosHistorico.add(0, projeto);
			for (int i = 1; i < projetosHistorico.size(); i++) {
				atualizadaProjetosHistorico.add(i, projetosHistorico.get(i - 1));
			}
			setProjetosHistorico(atualizadaProjetosHistorico);
		}
	}

	@Override
	public void remover(ProjetoModel projeto, String stringProjeto) {
		if (projetosHistoricoCompletoStr.contains(stringProjeto) && projetosHistorico.contains(projeto)) {
			projetosHistoricoCompletoStr.remove(stringProjeto);
			projetosHistorico.remove(projeto);
			String conteudoArquivo = projetosEmString();
			Persistencia.rewriteFile(Persistencia.getFileFavoritos(), conteudoArquivo);
		}
		else {
			//
			Log.i("LOGGER", "ELSE REMOVER HISTORICO");
		}
	}

	@Override
	public String projetosEmString() {
		String conteudoProjetosHistorico = "";

		for (int i = 0; i < projetosHistoricoCompletoStr.size(); i++) {
			conteudoProjetosHistorico += projetosHistoricoCompletoStr.get(i);
		}

		return conteudoProjetosHistorico;
	}

	@Override
	public void popularProjetos() {
		ArrayList<String> splitParts;
		String strConteudoHistorico = Persistencia.readFromFile(Persistencia.getFileHistorico());
		Log.i("LOGGER", "Conteudo historico: " + strConteudoHistorico);

		final int separadoresPorProjeto = 9;
		final int numeroDeProjetosNoArquivo;
		int numeroDeSeparadores = 0;

		if (strConteudoHistorico.contains("~")) {
			for (int i = 0; i < strConteudoHistorico.length(); i++) {
				if (strConteudoHistorico.charAt(i) == '~') {
					numeroDeSeparadores++;
				}
			}
			Log.i("LOGGER", "separators: " + numeroDeSeparadores);
			Log.i("LOGGER", "MOD: " + (numeroDeSeparadores % separadoresPorProjeto));
			numeroDeProjetosNoArquivo = 1 + (numeroDeSeparadores % separadoresPorProjeto);
			Log.i("LOGGER", "Numero de projetos: " + numeroDeProjetosNoArquivo);

			for (int i = 0; i < numeroDeProjetosNoArquivo; i++) {
				splitParts = new ArrayList<String>(numeroDeSeparadores);
				String[] parts = strConteudoHistorico.split("~");

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

				projetosHistorico = new ArrayList<ProjetoModel>();
				projetosHistorico.add(i, projeto);

				Log.i("LOGGER", projeto.toString());
			}
		}
		else {
			Log.i("LOGGER", "Historico esta vazio");
		}

		popularListaComProjetos();
	}

	@Override
	public void popularListaComProjetos() {
		if (!(projetosHistorico == null)) {
			for (int i = 0; i < projetosHistorico.size(); i++) {
				String stringProjeto = "";
				stringProjeto += projetosHistorico.get(i).getNome();
				stringProjeto += "\nNumero: ";
				stringProjeto += projetosHistorico.get(i).getNumero();
				stringProjeto += "\nAno:  ";
				stringProjeto += projetosHistorico.get(i).getAno();
				stringProjeto += "\nSigla: ";
				stringProjeto += projetosHistorico.get(i).getSigla();
				stringProjeto += "\nData de Apresentação: ";
				stringProjeto += projetosHistorico.get(i).getData();
				stringProjeto += "\nDescrição: ";
				stringProjeto += projetosHistorico.get(i).getExplicacao();
				stringProjeto += "\nParlamentar: ";
				stringProjeto += projetosHistorico.get(i).getParlamentar().getNome();
				stringProjeto += "\nPartido: ";
				stringProjeto += projetosHistorico.get(i).getParlamentar().getPartido().getSiglaPartido();
				stringProjeto += "\nEstado: ";
				stringProjeto += projetosHistorico.get(i).getParlamentar().getPartido().getUf();
				projetosHistoricoCompletoStr.add(i, stringProjeto);
			}
		}
		else {
			Log.i("LOGGER", "Historico esta vazio");
		}
	}

	public static ArrayList<ProjetoModel> getProjetosHistorico() {
		return projetosHistorico;
	}

	public static void setProjetosHistorico(ArrayList<ProjetoModel> projetosHistorico) {
		HistoricoController.projetosHistorico = projetosHistorico;
	}

	public static ArrayList<String> getProjetosHistoricoCompletoStr() {
		return projetosHistoricoCompletoStr;
	}

	public static void setProjetosHistoricoCompletoStr(ArrayList<String> projetosHistoricoCompletoStr) {
		HistoricoController.projetosHistoricoCompletoStr = projetosHistoricoCompletoStr;
	}

	public static int getNumeroDeProjetosNoHistorico() {
		return projetosHistorico.size();
	}

	public static int getMaxProjetos() {
		return MAX_PROJETOS;
	}

	public static ProjetoModel getProjetoMaisVelho() {
		ProjetoModel projeto = projetosHistorico.get(0);
		if (!projetosHistorico.isEmpty()) {
			projeto = projetosHistorico.get(0);
		}
		return projeto;
	}

	public static String getStringProjetoMaisVelho() {
		String projetoString = "";
		if (!projetosHistoricoCompletoStr.isEmpty()) {
			projetoString = projetosHistoricoCompletoStr.get(0);
		}
		return projetoString;
	}
}
