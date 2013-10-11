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

	public String recebe(String url) {

		BufferedReader inputStream = null;
		String data = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpRequest = null;
		HttpResponse httpResponse = null;
		URI website = null;
		StringBuffer dataStringBuffer = null;
		String toAppend = null;

		try {
			website = new URI(url);
			//website = new URI("http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx/ListarProposicoes?sigla=PL&numero=&ano=2011&datApresentacaoIni=14/11/2011&datApresentacaoFim=16/11/2011&autor=&parteNomeAutor=&siglaPartidoAutor=&siglaUFAutor=&generoAutor=&codEstado=&codOrgaoEstado=&emTramitacao=");
			
			httpRequest = new HttpGet();
			httpRequest.setURI(website);
			
			httpResponse = httpClient.execute(httpRequest);
			
			inputStream = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			
			dataStringBuffer = new StringBuffer("");
			toAppend = "";
			while ((toAppend = inputStream.readLine()) != null) {
				dataStringBuffer.append(toAppend);
			}
			
			data = dataStringBuffer.toString();

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

		return data;
	}
}
