package com.mds.app.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.FavoritosController;
import com.mds.app.controller.HistoricoController;
import com.mds.app.controller.ListaController;
import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class FavoritosControllerTest {

	public FavoritosController favoritosController;
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

		favoritosController = new FavoritosController();
		FavoritosController.setProjetosFavoritados(projetos);
		FavoritosController.setProjetosFavoritadosCompletoStr(new ArrayList<String>());
	}

	@After
	public void tearDown() throws Exception {
		favoritosController = null;
		projetosString = null;
		projetos = null;
		projetoModel = null;
		parlamentarModel = null;
		partidoModel = null;
		FavoritosController.setProjetosFavoritados(null);
		FavoritosController.setProjetosFavoritadosCompletoStr(null);
	}

	@Test
	public void testInstance() {
		assertNotNull(favoritosController);
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
		favoritosController.popularListaComProjetos();
		String esperado = "Zordon\nNumero: 6663\nAno:  2013\nSigla: PL\nData de Apresentação: 12/01/2013\nDescrição: explicacao marota\nParlamentar: Ranger\nPartido: PMDS\nEstado: AC";
		String retornado = favoritosController.projetosEmString();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testPopularListaComProjetos() {
		FavoritosController.setProjetosFavoritados(projetos);
		favoritosController.popularListaComProjetos();
		String esperado = "[Zordon\nNumero: 6663\nAno:  2013\nSigla: PL\nData de Apresentação: 12/01/2013\nDescrição: explicacao marota\nParlamentar: Ranger\nPartido: PMDS\nEstado: AC]";
		String retornado = FavoritosController.getProjetosFavoritadosCompletoStr().toString();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testPopularProjetos() {
		ListaController listaController = new ListaController();
		ListaController.setProjetoAtual(projetoModel);
		String stringInput = listaController.getStringCompletaParaArquivo();
		favoritosController.popularProjetos(stringInput);
		String esperado = HistoricoController.getProjetosHistorico().get(0).toString();
		String retornado = projetoModel.toString();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testSetThenGetProjetosFavoritadosCompletosStr() {
		ArrayList<String> arrayTeste = new ArrayList<String>();
		arrayTeste.add("TESTANDO PROJETO");
		FavoritosController.setProjetosFavoritadosCompletoStr(arrayTeste);
		assertSame(arrayTeste, FavoritosController.getProjetosFavoritadosCompletoStr());
	}

	@Test
	public void testSetThenGetProjetosFavoritados() {
		FavoritosController.setProjetosFavoritados(projetos);
		assertSame(projetos, FavoritosController.getProjetosFavoritados());
	}

	@Test
	public void testarNomeDaClasse() {
		String nomeEsperado = "FavoritosController";
		String nomeRetornado = favoritosController.getClass().getSimpleName();
		assertEquals(nomeEsperado, nomeRetornado);
	}

}
