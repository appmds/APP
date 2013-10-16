package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;

public class ParlamentarModelTest {

	private ParlamentarModel parlamentarModel;
	private PartidoModel partidoModel;

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");

		partidoModel = new PartidoModel("PMDS", "DF");
		parlamentarModel = new ParlamentarModel("NomeParlamentar", partidoModel);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testGetNome() {
		assertEquals("NomeParlamentar", parlamentarModel.getNome());
	}

	@Test
	public void testSetNome() {
		parlamentarModel.setNome("NomeParlamentar");
		assertEquals("NomeParlamentar", parlamentarModel.getNome());
	}

	@Test
	public void testGetPartido() {
		assertSame(partidoModel, parlamentarModel.getPartido());
	}

	@Test
	public void testSetPartido() {
		parlamentarModel.setPartido(partidoModel);
		assertSame(partidoModel, parlamentarModel.getPartido());
	}
}