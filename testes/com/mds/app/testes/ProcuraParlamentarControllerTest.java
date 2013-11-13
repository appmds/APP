package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProcuraParlamentarController;
import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarControllerTest {

	private ProcuraParlamentarController procuraParlamentarController;

	@Before
	public void setUp() throws Exception {
		procuraParlamentarController = new ProcuraParlamentarController();
	}

	@After
	public void tearDown() throws Exception {
		procuraParlamentarController = null;
	}

	@Test
	public void testInstance() {
		procuraParlamentarController = new ProcuraParlamentarController();
		assertNotNull(procuraParlamentarController);
	}

	@Test
	public void testAtualizarDadosPesquisaParlamentar() {
		ProcuraParlamentarController.atualizarDadosPesquisaParlamentar("Joao");
		assertEquals("Joao", ProcuraParlamentarModel.getNome());

	}

}
