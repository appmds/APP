package com.mds.app.testes.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.mds.app.services.RecebeHTTP;

public class RecebeHTTPTest {
		
	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}	
	@Test
	public void testInstance(){
		//RecebeHTTP http = new RecebeHTTP();
		//assertNotNull(http);
	}
	

}
