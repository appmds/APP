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

		String endercoRetornado = Endereco.construirEndereco("PL", "", "2011", "14/11/2011", "16/11/2011", "", "",
				"", "", "", "", "");

		assertEquals(enderecoEsperado, endercoRetornado);

	}
}
