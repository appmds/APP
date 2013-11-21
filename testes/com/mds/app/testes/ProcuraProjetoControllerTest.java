package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ProcuraProjetoController;
import com.mds.app.model.ProcuraProjetoModel;

public class ProcuraProjetoControllerTest {

	private ProcuraProjetoController procuraProjetoController;

	@Before
	public void setUp() throws Exception {
		procuraProjetoController = new ProcuraProjetoController();

		ProcuraProjetoController.atualizarDadosPesquisaProjeto("2013", "PL", "6555", "14/03/2013");
	}

	@After
	public void tearDown() throws Exception {
		procuraProjetoController = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(procuraProjetoController);
	}
	
	@Test
	public void testarNomeDaClasse(){
		ProcuraProjetoController procura = new ProcuraProjetoController();
		Assert.assertEquals("ProcuraProjetoController", procura.getClass().getSimpleName());
	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_Ano() {
		assertEquals("2013", ProcuraProjetoModel.getAno());

	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_Sigla() {
		assertEquals("PL", ProcuraProjetoModel.getSigla());

	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_Numero() {
		assertEquals("6555", ProcuraProjetoModel.getId());
	}

	@Test
	public void testAtualizarDadosPesquisaProjeto_DataInicio() {
		assertEquals("14/03/2013", ProcuraProjetoModel.getDataInicio());
	}

}
