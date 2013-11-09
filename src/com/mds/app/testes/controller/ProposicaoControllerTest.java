package com.mds.app.testes.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProposicaoController;

public class ProposicaoControllerTest {

	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}
	@Test
	public void testInstance() {
		ProposicaoController proposicaoController = new ProposicaoController();
		assertNotNull(proposicaoController);
	}

}
