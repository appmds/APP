package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ProcuraPartidoModel;

public class ProcuraPartidoModelTest {

	private ProcuraPartidoModel procuraPartidoModel;

	@Before
	public void setUp() throws Exception {

		procuraPartidoModel = new ProcuraPartidoModel() {
		};

		ProcuraPartidoModel.setUf("DF");
		ProcuraPartidoModel.setSigla("PMDS");

	}

	@After
	public void tearDown() throws Exception {
		procuraPartidoModel = null;
	}

	@Test
	public void testIntanciaPartido() {
		assertNotNull(procuraPartidoModel);
	}

	@Test
	public void testSetThenGetUf() {
		assertEquals("DF", ProcuraPartidoModel.getUf());
	}

	@Test
	public void testSetThenGetSigla() {
		assertEquals("PMDS", ProcuraPartidoModel.getSigla());
	}

}
