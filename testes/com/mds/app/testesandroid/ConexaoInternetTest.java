package com.mds.app.testesandroid;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.os.AsyncTask;

import com.mds.app.util.CancelTaskOnCancelListener;
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
	public void testNomeClasse(){
		Assert.assertEquals("ConexaoInternet", conexaoInternet.getClass().getSimpleName());
	}
	@Test
	public void testChecarConexaoInternet() {
		fail();
	}

}
