package com.mds.app.testes.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ProcuraPartidoModel;

public class ProcuraPartidoModelTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
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

}
