package com.mds.app.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;

public class ParlamentarModelTest extends AndroidTestCase {

	private ParlamentarModel parlamentarModel;
	private PartidoModel partidoModel;

	@Before
	public void setUp() throws Exception {
		partidoModel = new PartidoModel("PMDS", "DF");
		parlamentarModel = new ParlamentarModel("NomeParlamentar", partidoModel);
	}

	@After
	public void tearDown() throws Exception {
		partidoModel = null;
		parlamentarModel = null;
	}

	@Test
	public void testIntanciaPartido() {
		PartidoModel partido = new PartidoModel();
		assertNotNull(partido);
	}

	@Test
	public void testarNomeClasse() {
		Assert.assertEquals("PartidoModel", partidoModel.getClass().getSimpleName());
	}

	@Test
	public void testarNomeClasse2() {
		Assert.assertEquals("ParlamentarModel", parlamentarModel.getClass().getSimpleName());
	}

	@Test
	public void testIntanciaParlamentar() {
		PartidoModel parlamentar = new PartidoModel();
		assertNotNull(parlamentar);
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