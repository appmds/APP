package com.mds.app.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.BuscaController;

public class BuscaControllerTest {

	public BuscaController buscaController;

	@Before
	public void setUp() throws Exception {
		buscaController = new BuscaController();

	}

	@After
	public void tearDown() throws Exception {
		buscaController = null;
	}

	@Test
	public void testNullsAtualizarDadosDaPesquisa() {
		boolean validacao = buscaController.atualizarDadosDaPesquisa(null, null, null, null, null, null, null);
		assertFalse(validacao);
	}

	@Test
	public void testFail() {
		fail("implementar testes");
	}

}
