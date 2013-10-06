package com.mds.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class RecebeHTTP {

	private DefaultHttpClient cliente = new DefaultHttpClient();

	public String recebe(String url) {

		HttpGet getRequisicao = new HttpGet(url);

		try {

			HttpResponse getResponse = cliente.execute(getRequisicao);
			final int estadoCodigo = getResponse.getStatusLine().getStatusCode();

			if (estadoCodigo != HttpStatus.SC_OK) {
				Log.w(getClass().getSimpleName(), "Error " + estadoCodigo + " for URL " + url);
				return null;
			}

			HttpEntity getEntidadeResponsavel = getResponse.getEntity();

			if (getEntidadeResponsavel != null) {
				return EntityUtils.toString(getEntidadeResponsavel);
			}

		} catch (IOException e) {
			getRequisicao.abort();
			Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
		}

		return null;

	}
	
	//outro exemplo de httpget
	public String httpget(String url) throws URISyntaxException, ClientProtocolException, IOException{
	BufferedReader in = null;
	String dados = null;
	try{
		URI website = new URI("http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx/ListarProposicoes?sigla=PL&numero=&ano=2011&datApresentacaoIni=14/11/2011&datApresentacaoFim=16/11/2011&autor=&parteNomeAutor=&siglaPartidoAutor=&siglaUFAutor=&generoAutor=&codEstado=&codOrgaoEstado=&emTramitacao=");
		HttpGet request = new HttpGet();
		request.setURI(website);
		HttpResponse response = cliente.execute(request);
		in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer sb = new StringBuffer("");
		String linha = "";
		String PularLinha = System.getProperty("line.separator");
		while((linha = in.readLine()) !=null){
			sb.append(linha + PularLinha);
		}
		in.close();
		dados = sb.toString();
		return dados;
	}finally{
		if(in != null){
			try{
				in.close();
				return dados;
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
	
}