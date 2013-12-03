package com.mds.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.util.ConexaoInternet;

public class ConexaoInternetTest extends AndroidTestCase {

	ConexaoInternet conexaoInternet;

	@Before
	public void setUp() throws Exception {
		conexaoInternet = new ConexaoInternet(mContext);
	}

	@After
	public void tearDown() throws Exception {
		conexaoInternet = null;
	}

	@Test
	public void testInstancia() {
		assertNotNull(conexaoInternet);
	}

	@Test
	public void testInstanciaConstrutorVazio() {
		ConexaoInternet conexaoInternetConstrutorVazio = new ConexaoInternet();
		assertNotNull(conexaoInternetConstrutorVazio);
	}

	@Test
	public void testGetContext() {
		assertEquals(mContext, conexaoInternet.getContext());
	}

	@Test
	public void testNomeClasse() {
		assertEquals("ConexaoInternet", conexaoInternet.getClass().getSimpleName());
	}

	@Test
	public void testChecarConexaoInternet() {
		boolean conexao = conexaoInternet.ChecarConexaoInternet();
		assertTrue(conexao);
	}

}
