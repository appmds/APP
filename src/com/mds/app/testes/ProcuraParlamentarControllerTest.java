package com.mds.app.testes;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProcuraParlamentarController;
import com.mds.app.model.ProcuraParlamentarModel;

public class ProcuraParlamentarControllerTest extends TestCase {
	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}
	
	@Test
	public void testInstance(){
		ProcuraParlamentarController procuraParlamentarController = new ProcuraParlamentarController();
		assertNotNull(procuraParlamentarController);
	}

	@Test
	public void testAtualizarDadosPesquisaParlamentar() {
		ProcuraParlamentarController.atualizarDadosPesquisaParlamentar("Joao");
		assertEquals("Joao",ProcuraParlamentarModel.getNome());
		
	}

}
