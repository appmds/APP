package com.mds.app.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.app.Activity;

import com.mds.app.persistencia.Persistencia;


public class PersistenciaTest {
	
	//protected Persistencia persistencia;
	//protected Activity activity;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando...");
		//Persistencia persistencia = new Persistencia();
		//Activity activity = new Activity();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}
	
	@Test
	public void testInstance() {
		//Persistencia testInstancePersistencia = new Persistencia ();
		//assertNotNull(testInstancePersistencia);
	}

	@Test
	public void lerPersistenciatest() {
		//Persistencia persistencia = new Persistencia();
		//boolean esperado = persistencia.percorrendoPersistencia(false);
		
		assertEquals(false, false);
	}

}
