package com.mds.app.teste.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProcuraParlamentarController;
import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarControllerTest {
	@Before
	public void setUp() throws Exception {
		ProcuraParlamentarController procuraParlamentarControllerTeste = new ProcuraParlamentarController();
		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testInstance() {
		ProcuraParlamentarController procuraParlamentarController = new ProcuraParlamentarController();
		assertNotNull(procuraParlamentarController);
	}

	@Test
	public void testAtualizarDadosPesquisaParlamentar() {
		ProcuraParlamentarController.atualizarDadosPesquisaParlamentar("Joao");
		assertEquals("Joao", ProcuraParlamentarModel.getNome());

	}

}
