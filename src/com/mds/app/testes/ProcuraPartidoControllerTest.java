package com.mds.app.testes;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProcuraPartidoController;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProcuraPartidoModel;


public class ProcuraPartidoControllerTest extends TestCase{

	private ProcuraPartidoController procuraPartidoController;
	private ProcuraPartidoModel procuraPartidoModel;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
		procuraPartidoController = new ProcuraPartidoController();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testAtualizaDadosPesquisaPartido_UF() {
		ProcuraPartidoController.atualizaDadosPesquisaPartido("DF","PMDB");
		assertEquals("DF",ProcuraPartidoModel.getUf());
	}
	@Test
	public void testAtualizaDadosPesquisaPartido_Sigla() {
		ProcuraPartidoController.atualizaDadosPesquisaPartido("DF","PMDB");
		assertEquals("PMDB",ProcuraPartidoModel.getSigla());
	}
}
