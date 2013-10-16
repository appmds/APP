package com.mds.app.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarModelTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testSetThenGetNome() {
		ProcuraParlamentarModel.setNome("NomeProcuraParlamentarModel");
		assertEquals("NomeProcuraParlamentarModel", ProcuraParlamentarModel.getNome());
	}

}
