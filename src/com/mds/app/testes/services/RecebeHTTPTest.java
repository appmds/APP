package com.mds.app.testes.services;

import static org.junit.Assert.*;

import java.io.BufferedReader;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.services.RecebeHTTP;

public class RecebeHTTPTest {
	
	RecebeHTTP recebeHTTP;
	HttpGet httpGet;
	BufferedReader buffer;
	HttpClient httpClient;

	@Before
	public void setUp() throws Exception {
		
		recebeHTTP = new RecebeHTTP(){
		};
		
		System.out.println("Comecando o teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	/*
	@Test
	public void testInstance() {
		RecebeHTTP http = new RecebeHTTP();
		assertNotNull(http);
	}
	
	@Test
	public void testResposta() {
		String resposta = recebeHTTP.recebe("http://www.camara.gov.br");
		assertEquals(recebeHTTP.recebe("http://www.camara.gov.b"), 
				recebeHTTP.recebe("http://www.camara.gov.b"));
	}
	*/


}
