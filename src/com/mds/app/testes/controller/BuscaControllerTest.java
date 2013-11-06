package com.mds.app.testes.controller;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.BuscaController;
import com.mds.app.controller.ProcuraParlamentarController;

public class BuscaControllerTest {

	BuscaController buscaController;
	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
		buscaController = new BuscaController();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testAtualizarDadosDaPesquisa() {
		
		boolean validacao = buscaController.atualizarDadosDaPesquisa(null, null, null, null, null, null, null);
		assertEquals(validacao, false);
	}

}
