package com.mds.app.persistencia;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

public class Persistencia extends Activity {

	/*
	 * Pra ler a persistencia:
	 * 
	 * Persistencia persistencia = new Persistencia();
	 * persistencia.lerPersistencia(NomeDaClasse.this);
	 * String conteudoTxt = persistencia.getTxtContent();
	 */

	private String txtContent;

	public Persistencia() {
		txtContent = "";
	}

	public void lerPersistencia(Context context) {
		final String txtPersistencia = "PL2013.txt";
		byte[] buffer = null;
		InputStream is;
		AssetManager manager;

		try {
			manager = context.getAssets();
			is = manager.open(txtPersistencia);
			int size = is.available(); // tamanho do arquivo em bytes
			buffer = new byte[size];
			is.read(buffer);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String str_data = new String(buffer);

		this.setTxtContent(str_data);
	}

	public String getTxtContent() {
		return txtContent;
	}

	public void setTxtContent(String txtContent) {
		this.txtContent = txtContent;
	}

}