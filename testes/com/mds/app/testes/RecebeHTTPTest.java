package com.mds.app.testes;

import static org.junit.Assert.fail;

import java.io.BufferedReader;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.services.RecebeHTTP;

public class RecebeHTTPTest {

	public RecebeHTTP recebeHTTP;
	public HttpGet httpGet;
	public BufferedReader buffer;
	public HttpClient httpClient;

	@Before
	public void setUp() throws Exception {
		recebeHTTP = new RecebeHTTP() {
		};
	}

	@After
	public void tearDown() throws Exception {
		recebeHTTP = null;
	}
	
	@Test
	public void testRecebe(){
		recebeHTTP.recebe(null);
		fail("implementar");
	}

	@Test
	public void testFail() {
		fail("implementar testes");
	}

}
