package com.mds.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.model.ProcuraProjetoModel;

public class ProcuraProjetoModelTest extends AndroidTestCase {

	private ProcuraProjetoModel procuraProjetoModel;

	@Before
	public void setUp() throws Exception {
		procuraProjetoModel = new ProcuraProjetoModel() {
		};
	}

	@After
	public void tearDown() throws Exception {
		procuraProjetoModel = null;
	}

	@Test
	public void testIntanciaProjeto() {
		assertNotNull(procuraProjetoModel);
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
