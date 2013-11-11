package com.mds.app.testes.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.util.ConexaoInternet;

public class ConexaoInternetTest {

	ConexaoInternet conexaoInternet;

	@Before
	public void setUp() throws Exception {

		conexaoInternet = new ConexaoInternet();

		System.out.println("Começando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando");
	}

	@Test
	public void testaInstancia() {
		ConexaoInternet conexao = new ConexaoInternet();
		assertNotNull(conexao);
	}

	@Test
	public void testaChecarConexaoInternet() {

		ConexaoInternet conexao = new ConexaoInternet();
		boolean resposta = conexao.ChecarConexaoInternet2();

		assertEquals(false, resposta);
	}

}
