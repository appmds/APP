package com.mds.app.testes.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarModelTest {

	@Before
	public void setUp() throws Exception {

		ProcuraParlamentarModel p = new ProcuraParlamentarModel() {
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
	public void testSetThenGetNome() {
		ProcuraParlamentarModel.setNome("NomeProcuraParlamentarModel");
		assertEquals("NomeProcuraParlamentarModel", ProcuraParlamentarModel.getNome());
	}

}
