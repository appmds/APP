package com.mds.app.testes;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProposicaoController;

public class ProposicaoControllerTest {

	private ProposicaoController proposicaoController;

	@Before
	public void setUp() throws Exception {
		proposicaoController = new ProposicaoController();
	}

	@After
	public void tearDown() throws Exception {
		proposicaoController = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(proposicaoController);
	}

}
