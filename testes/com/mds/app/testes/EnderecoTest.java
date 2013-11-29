package com.mds.app.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.services.Endereco;

public class EnderecoTest {

	Endereco endereco;

	@Before
	public void setUp() throws Exception {
		endereco = new Endereco() {
		};
	}

	@After
	public void tearDown() throws Exception {
		endereco = null;
	}

	@Test
	public void testConstruirEndereco() {
		String enderecoEsperado = "http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx/ListarProposicoes?sigla=PL&numero=&ano=2011&datApresentacaoIni=14/11/2011&datApresentacaoFim=16/11/2011&autor=&parteNomeAutor=&siglaPartidoAutor=&siglaUFAutor=&generoAutor=&codEstado=&codOrgaoEstado=&emTramitacao=1";

		Endereco.sigla = "PL";
		Endereco.numero = "";
		Endereco.ano = "2011";
		Endereco.dataInicio = "14/11/2011";
		Endereco.dataFinal = "16/11/2011";
		Endereco.autor = "";
		Endereco.nomeAutor = "";
		Endereco.siglaPartido = "";
		Endereco.siglaUF = "";
		Endereco.generoAutor = "";
		Endereco.codigoEstado = "";
		Endereco.codigoOrgaoEstado = "";
		String endercoRetornado = Endereco.construirEndereco();

		/* falhando por causa do hotfix, devido ao bug no BD da camara */
		assertEquals(enderecoEsperado, endercoRetornado);
	}
}
