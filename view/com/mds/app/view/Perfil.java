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
import com.mds.app.controller.FavoritosController;
import com.mds.app.persistencia.Persistencia;

public class Perfil extends Activity {

	private String stringProjeto;
	private TextView texto;
	private ImageButton naoFavorito;
	private boolean favoritado = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);

		Intent intent = getIntent();
		intent.getExtras().getString("PROJETOS");
		stringProjeto = intent.getStringExtra("PROJETO");

		texto = (TextView) findViewById(R.id.texto);
		texto.setText(stringProjeto);
		favoritar_addListener();

		// if tamanho menor que 10, gravar na primeira linha
		// else gravar na primeira linha e apagar a ultima
		// manipular arquivo
		Persistencia.writeToFile(Persistencia.getFileHistorico(), stringProjeto);

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
				
				FavoritosController favoritosController = new FavoritosController();
				
				if (!favoritado) {
					naoFavorito.setImageResource(R.drawable.favorito);
					favoritado = true;
					favoritosController.adicionarFavorito(stringProjeto);
				}
				else {
					naoFavorito.setImageResource(R.drawable.naofavorito);
					favoritado = false;
					favoritosController.removerFavorito(stringProjeto);
				}
			}
		});
	}

}
