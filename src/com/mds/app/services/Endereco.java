package com.mds.app.services;

import java.net.URLEncoder;

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
	
	protected String constroirEndereco() {
		StringBuffer sb = new StringBuffer();
		sb.append(BASE_URL);
		sb.append(SIGLA);
		sb.append(IGUAL);
		sb.append("PL");
		sb.append(E);
		sb.append(NUMERO);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(ANO);
		sb.append(IGUAL);
		sb.append("2013");
		sb.append(E);
		sb.append(DATA_INICIO);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(DATA_FINAL);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(AUTOR);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(NOME_AUTOR);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(SIGLA_PARTIDO);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(SIGLA_UF);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(GENERO_AUTOR);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(CODIGO_ESTADO);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(CODIGO_ORGAO_ESTADO);
		sb.append(IGUAL);
		sb.append(E);
		sb.append(TRAMITACAO);
		sb.append(IGUAL);
		return sb.toString();
	}
	
}
