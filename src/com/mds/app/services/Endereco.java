package com.mds.app.services;

import java.util.ArrayList;

import com.mds.app.model.ProjetoModel;

public abstract class Endereco {

	private final static String BASE_URL = "http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx/ListarProposicoes?";
	private final static String IGUAL = "=";
	private final static String E = "&";
	private final static String SIGLA = "sigla";
	private final static String NUMERO = "numero";
	private final static String ANO = "ano";
	private final static String DATA_INICIO = "datApresentacaoIni";
	private final static String DATA_FINAL = "datApresentacaoFim";
	private final static String AUTOR = "autor";
	private final static String NOME_AUTOR = "parteNomeAutor";
	private final static String SIGLA_PARTIDO = "siglaPartidoAutor";
	private final static String SIGLA_UF = "siglaUFAutor";
	private final static String GENERO_AUTOR = "generoAutor";
	private final static String CODIGO_ESTADO = "codEstado";
	private final static String CODIGO_ORGAO_ESTADO = "codOrgaoEstado";
	private final static String TRAMITACAO = "emTramitacao";

	protected RecebeHTTP recebeHTTP = new RecebeHTTP();
	protected XMLParser xmlParser = new XMLParser();

	public abstract ArrayList<ProjetoModel> procurar();

	public abstract ArrayList<ProjetoModel> procurar(int maxResultados);

	protected String construirEndereco(String sigla, String numero, String ano, String dataInicio,
			String dataFinal, String autor, String nomeAutor, String siglaPartido, String siglaUF,
			String generoAutor, String codigoEstado, String codigoOrgaoEstado) {

		StringBuffer sb = new StringBuffer();
		sb.append(BASE_URL);
		sb.append(SIGLA);
		sb.append(IGUAL);
		sb.append(sigla);
		sb.append(E);
		sb.append(NUMERO);
		sb.append(IGUAL);
		sb.append(numero);
		sb.append(E);
		sb.append(ANO);
		sb.append(IGUAL);
		sb.append(ano);
		sb.append(E);
		sb.append(DATA_INICIO);
		sb.append(IGUAL);
		sb.append(dataInicio);
		sb.append(E);
		sb.append(DATA_FINAL);
		sb.append(IGUAL);
		sb.append(dataFinal);
		sb.append(E);
		sb.append(AUTOR);
		sb.append(IGUAL);
		sb.append(autor);
		sb.append(E);
		sb.append(NOME_AUTOR);
		sb.append(IGUAL);
		sb.append(nomeAutor);
		sb.append(E);
		sb.append(SIGLA_PARTIDO);
		sb.append(IGUAL);
		sb.append(siglaPartido);
		sb.append(E);
		sb.append(SIGLA_UF);
		sb.append(IGUAL);
		sb.append(siglaUF);
		sb.append(E);
		sb.append(GENERO_AUTOR);
		sb.append(IGUAL);
		sb.append(generoAutor);
		sb.append(E);
		sb.append(CODIGO_ESTADO);
		sb.append(IGUAL);
		sb.append(codigoEstado);
		sb.append(E);
		sb.append(CODIGO_ORGAO_ESTADO);
		sb.append(IGUAL);
		sb.append(codigoOrgaoEstado);
		sb.append(E);
		sb.append(TRAMITACAO);
		sb.append(IGUAL);
		return sb.toString();
	}

	public ArrayList<ProjetoModel> ReceberPrimeirosResultados(ArrayList<ProjetoModel> lista, int maxResultados) {

		ArrayList<ProjetoModel> novaLista = new ArrayList<ProjetoModel>();

		int count = Math.min(lista.size(), maxResultados);
		for (int i = 0; i < count; i++) {
			novaLista.add(lista.get(i));
		}
		return novaLista;
	}

}
