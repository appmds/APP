package com.mds.app.testesandroid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.util.ConexaoInternet;

public class ConexaoInternetTest extends AndroidTestCase {

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
	public void testNomeClasse() {
		assertEquals("ConexaoInternet", conexaoInternet.getClass().getSimpleName());
	}

	@Test
	public void testChecarConexaoInternet() {
		fail();
	}

}
