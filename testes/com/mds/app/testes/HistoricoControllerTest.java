package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.HistoricoController;
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
		historicoController.setProjetosHistorico(projetos);
		historicoController.setProjetosHistoricoCompletoStr(new ArrayList<String>());
	}

	@After
	public void tearDown() throws Exception {
		historicoController = null;
		projetosString = null;
		projetos = null;
		projetoModel = null;
		parlamentarModel = null;
		partidoModel = null;
		historicoController.setProjetosHistorico(null);
		historicoController.setProjetosHistoricoCompletoStr(null);
	}

	@Test
	public void testInstance() {
		assertNotNull(historicoController);
	}

	@Test
	public void testAdicionar2() {
		ProjetoModel projetoModel2 = new ProjetoModel("2132", "ZTeste", "PEC", "13/01/2014", "1163",
				"explicacao marota", parlamentarModel);
		historicoController.adicionar(projetoModel2, "ola");
		fail();
	}

	@Test
	public void testAdicionar() {
		historicoController.adicionar(projetoModel, "ola");
		fail();
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
		String nomeEsperado = "FavoritosController";
		String nomeRetornado = historicoController.getClass().getSimpleName();
		assertEquals(nomeEsperado, nomeRetornado);
	}

	@Test
	public void testGetMaxProjetos() {
		int esperado = 3;
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
	public void testGetStringProjetoMaisVelho() {
		System.out.println(HistoricoController.getStringProjetoMaisVelho());
		fail();
	}

}
