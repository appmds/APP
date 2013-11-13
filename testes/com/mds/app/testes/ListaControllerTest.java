package com.mds.app.testes;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ListaController;

public class ListaControllerTest {

	public ListaController listaController;

	@Before
	public void setUp() throws Exception {
		listaController = new ListaController();
	}

	@After
	public void tearDown() throws Exception {
		listaController = null;
	}

	@Test
	public void testFail() {
		fail("implementar testes");
	}

}
