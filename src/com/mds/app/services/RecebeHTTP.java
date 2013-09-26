package com.mds.app.services;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
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
}