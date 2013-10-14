package com.mds.app.testes;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;

public class ParlamentarModelTest extends TestCase{
	
	private ParlamentarModel parlamentarModel;
	private PartidoModel partidoModel;

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");
		
		partidoModel = new PartidoModel("PMDS", "DF");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testGetNome() {
		parlamentarModel = new ParlamentarModel("NomeParlamentar", partidoModel);
		assertEquals("NomeParlamentar", parlamentarModel.getNome());
	}

}