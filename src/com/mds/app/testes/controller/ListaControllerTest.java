package com.mds.app.testes.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ListaController;
import com.mds.app.view.Lista;

public class ListaControllerTest {

	ListaController listaController;

	@Before
	public void setUp() throws Exception {
		listaController = new ListaController("teste");
		System.out.println("Comecando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando");
	}
	
	@Test
	public void testGetLista() {
		assertEquals("", listaController.getLista(""));
	}
	
	@Test
	public void testSetLista() {

		listaController.setLista("Copa 2014");
		assertEquals("", listaController.getLista(""));
	}
	
	
	@Test
	public void testTransformarLista() {
		
		//O método é o tipo void, como testar?
	}
	
	@Test
	public void testInstance() {
		ListaController listaController = new ListaController("");
		assertNotNull(listaController);
	}
	
	@Test
	public void testInstance2() { //Com parametro
		ListaController listaController = new ListaController("lista");
		assertNotNull(listaController);
	}

}
