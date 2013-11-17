package com.mds.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RecebeHTTP {

	public RecebeHTTP() {
	}

	public String recebe(String url) {

		BufferedReader inputStream = null;
		String dado = null;
		HttpClient cliente = new DefaultHttpClient();
		HttpGet requisicao = null;
		HttpResponse resposta = null;
		URI website = null;
		StringBuffer dadoStringBuffer = null;
		String anexar = null;

		try {
			website = new URI(url);
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}

		requisicao = new HttpGet();
		requisicao.setURI(website);

		try {
			resposta = cliente.execute(requisicao);
		} catch (ClientProtocolException cpe) {
			cpe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			inputStream = new BufferedReader(new InputStreamReader(resposta.getEntity().getContent()));
		} catch (IllegalStateException ise) {
			ise.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		dadoStringBuffer = new StringBuffer("");
		anexar = "";
		try {
			while ((anexar = inputStream.readLine()) != null) {
				dadoStringBuffer.append(anexar);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				//
			}
		}

		dado = dadoStringBuffer.toString();

		return dado;
	}
}
