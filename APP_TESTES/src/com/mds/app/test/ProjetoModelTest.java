package com.mds.app.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.ProjetoModel;

public class ProjetoModelTest extends AndroidTestCase {

	private ProjetoModel projetoModel;
	private ParlamentarModel parlamentarModel;

	@Before
	public void setUp() throws Exception {
		parlamentarModel = new ParlamentarModel();
		projetoModel = new ProjetoModel("2013", "NomeProjeto", "PL", "16/10/2013", "66", "ExplicacaoProjeto",
				parlamentarModel);
	}

	@After
	public void tearDown() throws Exception {
		parlamentarModel = null;
		projetoModel = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(projetoModel);
	}

	@Test
	public void testarNomeClasse() {
		Assert.assertEquals("ParlamentarModel", parlamentarModel.getClass().getSimpleName());
	}

	@Test
	public void testarNomeClasse2() {
		Assert.assertEquals("ProjetoModel", projetoModel.getClass().getSimpleName());
	}

	@Test
	public void testGetNome() {
		assertEquals("NomeProjeto", projetoModel.getNome());
	}

	@Test
	public void testGetAno() {
		assertEquals("2013", projetoModel.getAno());
	}

	@Test
	public void testGetSigla() {
		assertEquals("PL", projetoModel.getSigla());
	}

	@Test
	public void testGetData() {
		assertEquals("16/10/2013", projetoModel.getData());
	}

	@Test
	public void testGetNumero() {
		assertEquals("66", projetoModel.getNumero());
	}

	@Test
	public void testGetExplicacao() {
		assertEquals("ExplicacaoProjeto", projetoModel.getExplicacao());
	}

	@Test
	public void testGetParlamentar() {
		/* ParlamentarModel outroParlamentar = new ParlamentarModel(); */
		assertEquals(parlamentarModel, projetoModel.getParlamentar());
	}

	@Test
	public void testGetContEqualsOne() {
		assertEquals(1, projetoModel.getCont());
	}

	@Test
	public void testGetContMaiorQueUm() {
		projetoModel.setNome("TesteCont");
		assertEquals(2, projetoModel.getCont());
	}

	@Test
	public void testSetNome() {
		projetoModel.setNome("SetNomeProjeto");
		assertEquals("SetNomeProjeto", projetoModel.getNome());
	}

	@Test
	public void testSetAno() {
		projetoModel.setAno("2012");
		assertEquals("2012", projetoModel.getAno());
	}

	@Test
	public void testSetSigla() {
		projetoModel.setSigla("PDS");
		assertEquals("PDS", projetoModel.getSigla());
	}

	@Test
	public void testSetData() {
		projetoModel.setData("15/10/2013");
		assertEquals("15/10/2013", projetoModel.getData());
	}

	@Test
	public void testSetNumero() {
		projetoModel.setNumero("67");
		assertEquals("67", projetoModel.getNumero());
	}
	
	@Test
	public void testSetThenGetStatus(){
		String esperado = "statusteste";
		projetoModel.setStatus(esperado);
		assertEquals(esperado, projetoModel.getStatus());
	}

	@Test
	public void testSetExplicacao() {
		projetoModel.setExplicacao("SetExplicacaoProjeto");
		assertEquals("SetExplicacaoProjeto", projetoModel.getExplicacao());
	}

	@Test
	public void testSetParlamentar() {
		ParlamentarModel outroParlamentar = new ParlamentarModel();
		projetoModel.setParlamentar(outroParlamentar);
		assertEquals(outroParlamentar, projetoModel.getParlamentar());
	}

	@Test
	public void testToString() {
		ProjetoModel outroProjetoModel = new ProjetoModel("2013", "NomeProjeto", "PL", "16/10/2013", "66",
				"ExplicacaoProjeto", parlamentarModel);
		assertEquals(projetoModel.toString(), outroProjetoModel.toString());
	}
	
	@Test
	public void testSetThenGetId() {
		String esperado = "idset";
		projetoModel.setId(esperado);
		assertEquals(esperado, projetoModel.getId());

	}

	@Test
	public void testGetContId() {
		projetoModel.setId("qualquer coisa");
		assertEquals(1, projetoModel.getContId());
	}

	@Test
	public void testSetContId() {
		int esperado = 3;
		projetoModel.setContId(esperado);
		assertEquals(esperado, projetoModel.getContId());
	}

	@Test
	public void testSetCont() {
		int esperado = 5;
		projetoModel.setCont(esperado);
		assertEquals(esperado, projetoModel.getCont());
	}

	@Test
	public void testConstrutorVazioNaoNulo() {
		ProjetoModel projetoVazio = new ProjetoModel();
		assertNotNull(projetoVazio);
	}

	@Test
	public void testSetIdComContIdMaiorQueZero() {
		projetoModel.setContId(3);
		projetoModel.setId("IDZORDON");
		assertEquals(3, projetoModel.getContId());
	}

	@Test
	public void testSetNomeComContMaiorQueUm() {
		projetoModel.setCont(5);
		projetoModel.setNome("NOMEZORDON");
		assertEquals(6, projetoModel.getCont());
	}	

}
