package com.mds.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.model.PartidoModel;

public class PartidoModelTest extends AndroidTestCase {

	private PartidoModel partidoModel;

	@Before
	public void setUp() throws Exception {
		partidoModel = new PartidoModel("PMDS", "DF");
	}

	@After
	public void tearDown() throws Exception {
		partidoModel = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(partidoModel);
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
