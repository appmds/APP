package com.mds.app.testes;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class ProjetoModelTest extends TestCase {

	private ProjetoModel projetoModel;
	private ParlamentarModel parlamentarModel;

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");

		parlamentarModel = new ParlamentarModel();

		projetoModel = new ProjetoModel("2013", 77, "PL", "16/10/2013", parlamentarModel);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testGetAno() {
		assertEquals("2013 ", projetoModel.getAno());
	}
	
	@Test
	public void testGetId(){
		assertEquals(77, projetoModel.getId());
	}
	
	@Test
	public void testGetSigla(){
		assertEquals("PL", projetoModel.getSigla());
	}
	
	@Test
	public void testGetData(){
		assertEquals("16/10/2013", projetoModel.getData());
	}
	
	@Test
	public void testGetParlamentar(){
		//ParlamentarModel outroParlamentar = new ParlamentarModel();
		assertEquals(parlamentarModel, projetoModel.getParlamentar());
	}

}
