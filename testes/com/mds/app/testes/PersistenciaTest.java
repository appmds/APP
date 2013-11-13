package com.mds.app.testes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.persistencia.Persistencia;

public class PersistenciaTest {

	Persistencia persistencia;

	@Before
	public void setUp() throws Exception {
		persistencia = new Persistencia();
	}

	@After
	public void tearDown() throws Exception {
		persistencia = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(persistencia);
	}

	@Test
	public void testFail() {
		fail("implementar testes");
	}

}
