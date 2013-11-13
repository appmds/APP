package com.mds.app.testes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.util.ConexaoInternet;

public class ConexaoInternetTest {

	public ConexaoInternet conexaoInternet;

	@Before
	public void setUp() throws Exception {
		conexaoInternet = new ConexaoInternet();
	}

	@After
	public void tearDown() throws Exception {
		conexaoInternet = null;
	}

	@Test
	public void testInstancia() {
		conexaoInternet = new ConexaoInternet();
		assertNotNull(conexaoInternet);
	}

	@Test
	public void testChecarConexaoInternet() {
		fail("Implementar");
	}

}
