package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProcuraProjetoController;
import com.mds.app.model.ProcuraProjetoModel;

public class ProcuraProjetoControllerTest {

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
		ProcuraProjetoController procuraProjetoController = new ProcuraProjetoController();
		assertNotNull(procuraProjetoController);
	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_Ano() {
		ProcuraProjetoController.atualizarDadosPesquisaProjeto("2013", "PL", "6555", "14/03/2013");
		assertEquals("2013", ProcuraProjetoModel.getAno());

	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_Sigla() {
		ProcuraProjetoController.atualizarDadosPesquisaProjeto("2013", "PL", "6555", "14/03/2013");
		assertEquals("PL", ProcuraProjetoModel.getSigla());

	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_Numero() {
		ProcuraProjetoController.atualizarDadosPesquisaProjeto("2013", "PL", "6555", "14/03/2013");
		assertEquals("6555", ProcuraProjetoModel.getId());

	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_DataInicio() {
		ProcuraProjetoController.atualizarDadosPesquisaProjeto("2013", "PL", "6555", "14/03/2013");
		assertEquals("14/03/2013", ProcuraProjetoModel.getDataInicio());

	}
}
