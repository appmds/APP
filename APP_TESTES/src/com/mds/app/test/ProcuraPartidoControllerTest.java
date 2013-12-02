package com.mds.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.controller.ProcuraPartidoController;
import com.mds.app.model.ProcuraPartidoModel;

public class ProcuraPartidoControllerTest extends AndroidTestCase {

	private ProcuraPartidoController procuraPartidoController;

	@Before
	public void setUp() throws Exception {
		procuraPartidoController = new ProcuraPartidoController();
		ProcuraPartidoController.atualizaDadosPesquisaPartido("DF", "PMDB");
	}

	@After
	public void tearDown() throws Exception {
		procuraPartidoController = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(procuraPartidoController);
	}

	@Test
	public void testarNomeDaClasse() {
		ProcuraPartidoController procura = new ProcuraPartidoController();
		assertEquals("ProcuraPartidoController", procura.getClass().getSimpleName());
	}

	@Test
	public void testAtualizaDadosPesquisaPartido_UF() {
		assertEquals("DF", ProcuraPartidoModel.getUf());
	}

	@Test
	public void testAtualizaDadosPesquisaPartido_Sigla() {
		assertEquals("PMDB", ProcuraPartidoModel.getSigla());
	}

}
