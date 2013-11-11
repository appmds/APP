package com.mds.app.testes.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProcuraPartidoModel;

public class ProcuraPartidoModelTest {

	@Before
	public void setUp() throws Exception {

		ProcuraPartidoModel partido = new ProcuraPartidoModel() {
		};

		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testIntanciaParlamentar() {
		PartidoModel parlamentar = new PartidoModel();
		assertNotNull(parlamentar);
	}

	@Test
	public void testSetThenGetUf() {
		ProcuraPartidoModel.setUf("DF");
		assertEquals("DF", ProcuraPartidoModel.getUf());
	}

	@Test
	public void testSetThenGetSigla() {
		ProcuraPartidoModel.setSigla("PMDS");
		assertEquals("PMDS", ProcuraPartidoModel.getSigla());
	}

	@Test
	public void testIntanciaPartido() {

		ProcuraPartidoModel partido = new ProcuraPartidoModel() {
		};
		assertNotNull(partido);
	}

}
