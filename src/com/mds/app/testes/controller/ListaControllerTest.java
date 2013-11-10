package com.mds.app.testes.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ListaController;

public class ListaControllerTest {

	private ListaController listaController;
	
	@Before
	public void setUp() throws Exception {
		listaController = new ListaController(null);
		System.out.println("Comecando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando");
	}

}
