package com.mds.app.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ListaController;
import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class ListaControllerTest {

	public ListaController listaController;
	public ArrayList<String> stringLista;
	public ArrayList<ProjetoModel> projetos;
	public ProjetoModel projetoModel;
	public ParlamentarModel parlamentarModel;
	public PartidoModel partidoModel;

	@Before
	public void setUp() throws Exception {
		stringLista = new ArrayList<String>();
		projetos = new ArrayList<ProjetoModel>();
		partidoModel = new PartidoModel("PMDS", "AC");
		parlamentarModel = new ParlamentarModel("Ranger", partidoModel);
		projetoModel = new ProjetoModel("2013", "Zordon", "PL", "12/01/2013", "6663", "explicacao marota",
				parlamentarModel);
		projetos.add(projetoModel);

		listaController = new ListaController(projetos);
	}

	@After
	public void tearDown() throws Exception {
		listaController = null;
		stringLista = null;
		projetos = null;
		projetoModel = null;
		parlamentarModel = null;
		partidoModel = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(listaController);
	}

	@Test
	public void testInstanceConstrutorVazio() {
		ListaController listaControllerTeste = new ListaController();
		assertNotNull(listaControllerTeste);
	}

	@Test
	public void testTransformarLista() {
		ArrayList<String> retornado = listaController.transformarLista();

		String stringEsperada = "[Zordon - 6663 - Ranger]";
		String stringRetornada = retornado.toString();

		assertEquals(stringEsperada, stringRetornada);
	}

	@Test
	public void testGetListaProjetos() {
		assertEquals(projetos, ListaController.getListaProjetos());
	}

	@Test
	public void testSetListaProjetos() {
		ArrayList<ProjetoModel> novoProjetos = new ArrayList<ProjetoModel>();
		ProjetoModel novoProjetoModel = new ProjetoModel("2012", "DIFF", "PEC", "12/01/2013", "6263",
				"explicacao", parlamentarModel);
		novoProjetos.add(novoProjetoModel);
		ListaController.setListaProjetos(novoProjetos);
		assertSame(novoProjetos, ListaController.getListaProjetos());
	}

	@Test
	public void testSetThenGetProjetoAtual() {
		ProjetoModel projetoModel2 = new ProjetoModel("2012", "nomedois", "PRC", "12/01/2013", "6263",
				"explicacao marota", parlamentarModel);
		ListaController.setProjetoAtual(projetoModel2);
		assertSame(projetoModel2, ListaController.getProjetoAtual());
	}

	@Test
	public void testTransformarListaNull() {
		ListaController listaControllerTeste = new ListaController();
		ListaController.setListaProjetos(null);
		ArrayList<String> arrayRetornado = listaControllerTeste.transformarLista();
		String esperado = "[Nada encontrado.]";
		String retornado = arrayRetornado.toString();
		assertEquals(esperado, retornado);

	}

	@Test
	public void testGetStringCompletaParaPerfil() {
		ListaController.setProjetoAtual(projetoModel);
		String retornado = listaController.getStringCompletaParaPerfil();
		String esperado = "Zordon\nNumero: 6663\nAno:  2013\nSigla: PL\nData de Apresentação: 12/01/2013\nDescrição: explicacao marota\nParlamentar: Ranger\nPartido: PMDS\nEstado: AC";
		assertEquals(esperado, retornado);
	}

	@Test
	public void testGetStringCompletaParaPerfilNull() {
		ListaController.setProjetoAtual(null);
		String retornado = listaController.getStringCompletaParaPerfil();
		String esperado = "Nada encontrado.";
		assertEquals(esperado, retornado);
	}

	@Test
	public void testGetStringCompletaParaArquivo() {
		ListaController.setProjetoAtual(projetoModel);
		String retornado = listaController.getStringCompletaParaArquivo();
		System.out.println(retornado);
		String esperado = "Zordon~6663~2013~PL~12/01/2013~explicacao marota~Ranger~PMDS~AC~";
		assertEquals(esperado, retornado);
	}

	@Test
	public void testGetStringCompletaParaArquivoNull() {
		ListaController.setProjetoAtual(null);
		String retornado = listaController.getStringCompletaParaArquivo();
		String esperado = null;
		assertEquals(esperado, retornado);
	}

	@Test
	public void testGetSeparador() {
		String esperado = "~";
		String retornado = ListaController.getSeparador();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testarNomeDaClasse() {
		String nomeEsperado = "ListaController";
		String nomeRetornado = listaController.getClass().getSimpleName();
		assertEquals(nomeEsperado, nomeRetornado);
	}

}
