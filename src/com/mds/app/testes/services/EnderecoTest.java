package com.mds.app.testes.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.services.Endereco;

public class EnderecoTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}
	
	@Test
	public void testConstruirEndereco(){
		assertEquals("http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx/ListarProposicoes?sigla=PL&numero=&ano=2011&datApresentacaoIni=14/11/2011&datApresentacaoFim=16/11/2011&autor=&parteNomeAutor=&siglaPartidoAutor=&siglaUFAutor=&generoAutor=&codEstado=&codOrgaoEstado=&emTramitacao=1",
				Endereco.construirEndereco("PL", "", "2011", "14/11/2011", "16/11/2011", "", "", "", "", "", "", ""));
	}
}
