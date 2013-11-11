package com.mds.app.testes.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ProcuraProjetoModel;

public class ProcuraProjetoModelTest {

	@Before
	public void setUp() throws Exception {

		ProcuraProjetoModel procuraProjeto = new ProcuraProjetoModel() {
		};

		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testIntanciaProjeto() {

		ProcuraProjetoModel procuraProjeto = new ProcuraProjetoModel() {
		};

		assertNotNull(procuraProjeto);
	}

	@Test
	public void testSetThenGetAno() {
		ProcuraProjetoModel.setAno("2013");
		assertEquals("2013", ProcuraProjetoModel.getAno());
	}

	@Test
	public void testSetThenGetDataInicio() {
		ProcuraProjetoModel.setDataInicio("16/10/2013");
		assertEquals("16/10/2013", ProcuraProjetoModel.getDataInicio());
	}

	@Test
	public void testSetThenGetId() {
		ProcuraProjetoModel.setId("99");
		assertEquals("99", ProcuraProjetoModel.getId());
	}

	@Test
	public void testSetThenGetNome() {
		ProcuraProjetoModel.setSigla("PL");
		assertEquals("PL", ProcuraProjetoModel.getSigla());
	}

}
