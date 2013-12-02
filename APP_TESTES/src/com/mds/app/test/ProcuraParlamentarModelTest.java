package com.mds.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarModelTest {

	public ProcuraParlamentarModel procuraParlamentarModel;

	@Before
	public void setUp() throws Exception {
		procuraParlamentarModel = new ProcuraParlamentarModel() {
		};
	}

	@After
	public void tearDown() throws Exception {
		procuraParlamentarModel = null;
	}

	@Test
	public void testSetThenGetNome() {
		ProcuraParlamentarModel.setNome("NomeProcuraParlamentarModel");
		assertEquals("NomeProcuraParlamentarModel", ProcuraParlamentarModel.getNome());
	}

}
