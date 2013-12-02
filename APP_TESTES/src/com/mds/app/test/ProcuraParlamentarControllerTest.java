package com.mds.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.controller.ProcuraParlamentarController;
import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarControllerTest extends AndroidTestCase {

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
	public void testarNomeDaClasse() {
		ProcuraParlamentarController procura = new ProcuraParlamentarController();
		assertEquals("ProcuraParlamentarController", procura.getClass().getSimpleName());
	}

	@Test
	public void testAtualizarDadosPesquisaParlamentar() {
		ProcuraParlamentarController.atualizarDadosPesquisaParlamentar("Joao");
		assertEquals("Joao", ProcuraParlamentarModel.getNome());

	}

}
