package com.mds.app.teste.copy;

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
		System.out.println("Comecando...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testFail() {
		fail("implementar testes");
	}
	
	@Test
	public void testInstance(){
		assertNotNull(persistencia);
	}

}
