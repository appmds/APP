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

			requisicao = new HttpGet();
			requisicao.setURI(website);

			resposta = cliente.execute(requisicao);

			inputStream = new BufferedReader(new InputStreamReader(resposta.getEntity().getContent()));

			dadoStringBuffer = new StringBuffer("");
			anexar = "";
			while ((anexar = inputStream.readLine()) != null) {
				dadoStringBuffer.append(anexar);
			}

			dado = dadoStringBuffer.toString();

		} catch (URISyntaxException urise) {
			//
		} catch (ClientProtocolException cpe) {
			//
		} catch (Exception e) {
			//
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					//
				}
			}
			else {
				//
			}
		}

		return dado;
	}
}
