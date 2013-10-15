package com.mds.app.testes;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.PartidoModel;

public class PartidoModelTest extends TestCase {

	private PartidoModel partidoModel;

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");

		// Criando o partido de teste
		partidoModel = new PartidoModel("PMDS", "DF");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testInstance(){
		PartidoModel testInstancePartidoModel = new PartidoModel();
		assertNotNull(testInstancePartidoModel);
	}
	
	@Test
	public void testGetSiglaPartido() {
		assertEquals("PMDS", partidoModel.getSiglaPartido());
	}

	@Test
	public void testGetUf() {
		assertEquals("DF", partidoModel.getUf());
	}

	@Test
	public void testSetSiglaPartido() {
		partidoModel.setSiglaPartido("PGPP");
		assertEquals("PGPP", partidoModel.getSiglaPartido());
	}

	@Test
	public void testSetUf() {
		partidoModel.setUf("MG");
		assertEquals("MG", partidoModel.getUf());
	}
	
}
