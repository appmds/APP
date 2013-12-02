package com.mds.app.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.HistoricoController;
import com.mds.app.controller.ListaController;
import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class HistoricoControllerTest {

	public HistoricoController historicoController;
	public ArrayList<String> projetosString;
	public ArrayList<ProjetoModel> projetos;
	public ProjetoModel projetoModel;
	public ParlamentarModel parlamentarModel;
	public PartidoModel partidoModel;

	@Before
	public void setUp() throws Exception {
		projetosString = new ArrayList<String>();
		projetos = new ArrayList<ProjetoModel>();
		partidoModel = new PartidoModel("PMDS", "AC");
		parlamentarModel = new ParlamentarModel("Ranger", partidoModel);
		projetoModel = new ProjetoModel("2013", "Zordon", "PL", "12/01/2013", "6663", "explicacao marota",
				parlamentarModel);
		projetos.add(projetoModel);
		
		historicoController = new HistoricoController();
		HistoricoController.setProjetosHistorico(projetos);
		HistoricoController.setProjetosHistoricoCompletoStr(new ArrayList<String>());
	}

	@After
	public void tearDown() throws Exception {
		historicoController = null;
		projetosString = null;
		projetos = null;
		projetoModel = null;
		parlamentarModel = null;
		partidoModel = null;
		HistoricoController.setProjetosHistorico(null);
		HistoricoController.setProjetosHistoricoCompletoStr(null);
	}

	@Test
	public void testInstance() {
		assertNotNull(historicoController);
	}

	@Test
	public void testRemover() {
		fail("mexe na persistencia");
	}

	@Test
	public void testAdicionar() {
		fail("mexe na persistencia");
	}
	
	@Test
	public void testProjetosEmString() {
		historicoController.popularListaComProjetos();
		String esperado = "Zordon\nNumero: 6663\nAno:  2013\nSigla: PL\nData de Apresentação: 12/01/2013\nDescrição: explicacao marota\nParlamentar: Ranger\nPartido: PMDS\nEstado: AC";
		String retornado = historicoController.projetosEmString();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testPopularListaComProjetos() {
		HistoricoController.setProjetosHistorico(projetos);
		historicoController.popularListaComProjetos();
		String esperado = "[Zordon\nNumero: 6663\nAno:  2013\nSigla: PL\nData de Apresentação: 12/01/2013\nDescrição: explicacao marota\nParlamentar: Ranger\nPartido: PMDS\nEstado: AC]";
		String retornado = HistoricoController.getProjetosHistoricoCompletoStr().toString();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testSetThenGetProjetosFavoritadosCompletosStr() {
		ArrayList<String> arrayTeste = new ArrayList<String>();
		arrayTeste.add("TESTANDO PROJETO");
		HistoricoController.setProjetosHistoricoCompletoStr(arrayTeste);
		assertSame(arrayTeste, HistoricoController.getProjetosHistoricoCompletoStr());
	}

	@Test
	public void testSetThenGetProjetosFavoritados() {
		HistoricoController.setProjetosHistorico(projetos);
		assertSame(projetos, HistoricoController.getProjetosHistorico());
	}

	@Test
	public void testarNomeDaClasse() {
		String nomeEsperado = "HistoricoController";
		String nomeRetornado = historicoController.getClass().getSimpleName();
		assertEquals(nomeEsperado, nomeRetornado);
	}

	@Test
	public void testGetMaxProjetos() {
		int esperado = 10;
		int retornado = HistoricoController.getMaxProjetos();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testGetNumeroProjetosNoHistorico() {
		int esperado = 1; // no caso do teste, pois so tem um projeto
		int retornado = HistoricoController.getNumeroDeProjetosNoHistorico();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testGetProjetoMaisVelho() {
		ProjetoModel retornado = HistoricoController.getProjetoMaisVelho();
		assertEquals(projetoModel, retornado);
	}

	@Test
	public void testPopularProjetos() {
		ListaController listaController = new ListaController();
		ListaController.setProjetoAtual(projetoModel);
		String stringInput = listaController.getStringCompletaParaArquivo();
		historicoController.popularProjetos(stringInput);
		String esperado = HistoricoController.getProjetosHistorico().get(0).toString();
		String retornado = projetoModel.toString();

		assertEquals(esperado, retornado);
	}

	@Test(expected = NullPointerException.class)
	public void testGetProjetoMaisVelhoNull() {
		HistoricoController.setProjetosHistorico(null);
		ProjetoModel retornado = HistoricoController.getProjetoMaisVelho();
	}

	@Test
	public void testGetStringProjetoMaisVelho() {
		String esperado = "teste";
		HistoricoController.getProjetosHistoricoCompletoStr().add(esperado);
		String retornado = HistoricoController.getStringProjetoMaisVelho();
		assertEquals(esperado, retornado);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetStringProjetoMaisVelhoNull() {
		String retornado = HistoricoController.getStringProjetoMaisVelho();
		fail("teste falhou");
	}

}
