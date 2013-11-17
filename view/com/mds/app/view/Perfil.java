package com.mds.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mds.app.R;
import com.mds.app.persistencia.Persistencia;

public class Perfil extends Activity {

	private String stringProjeto;
	private TextView texto;
	private ImageButton naoFavorito;
	private int contador = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);

		Intent intent = getIntent();
		intent.getExtras().getString("PROJETOS");
		stringProjeto = intent.getStringExtra("PROJETO");

		texto = (TextView) findViewById(R.id.texto);
		texto.setText(stringProjeto);
		favoritar_addListener();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void favoritar_addListener() {
		naoFavorito = (ImageButton) findViewById(R.id.naoFavorito);
		naoFavorito.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (contador == 0) {
					naoFavorito.setImageResource(R.drawable.favorito);
					contador = 1;
					Persistencia.writeToFile("favoritos", stringProjeto);
					System.out.println(Persistencia.readFromFile("favoritos"));
				}
				else {
					naoFavorito.setImageResource(R.drawable.naofavorito);
					contador = 0;
				}
			}
		});
	}

}
