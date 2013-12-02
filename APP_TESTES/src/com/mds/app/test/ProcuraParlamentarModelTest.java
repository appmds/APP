package com.mds.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarModelTest extends AndroidTestCase {

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
