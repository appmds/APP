package com.mds.app.testesandroid;

import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.persistencia.Persistencia;

public class PersistenciaTest extends AndroidTestCase {

	Persistencia persistencia;

	public PersistenciaTest() {
		super();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		persistencia = new Persistencia(mContext);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		persistencia = null;
	}
	
	@Test
	public void testGetContext() {
		assertEquals(mContext, persistencia.getContext());
	}

	@Test
	public void testArquivoFavoritosComNomeCerto(){
		String esperado = Persistencia.getFileNameFavoritos();
		String retornado = persistencia.getFileFavoritos().getName();
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void testArquivoHistoricoComNomeCerto(){
		String esperado = Persistencia.getFileNameHistorico();
		String retornado = persistencia.getFileHistorico().getName();
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void testGetFileNameFavoritos() {
		String esperado = "favoritos";
		String retornado = Persistencia.getFileNameFavoritos();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testGetFileNameHistorico() {
		String esperado = "historico";
		String retornado = Persistencia.getFileNameHistorico();
		assertEquals(esperado, retornado);
	}

}
