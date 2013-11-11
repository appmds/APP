package com.mds.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.mds.app.R;

public class Perfil extends Activity {

	String stringProjeto;
	TextView texto;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);

		Intent intent = getIntent();
		intent.getExtras().getString("PROJETOS");
		stringProjeto = intent.getStringExtra("PROJETO");

		texto = (TextView) findViewById(R.id.texto);
		texto.setText(stringProjeto);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
