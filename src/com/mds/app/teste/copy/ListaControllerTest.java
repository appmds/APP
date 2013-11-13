package com.mds.app.teste.copy;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ListaController;

public class ListaControllerTest {

	ListaController listaController;

	@Before
	public void setUp() throws Exception {
		listaController = new ListaController();
		System.out.println("Comecando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando");
	}

	@Test
	public void testFail() {
		fail("implementar testes");
	}

}
