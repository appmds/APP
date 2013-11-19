package com.mds.app.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mds.app.R;
import com.mds.app.controller.FavoritosController;
import com.mds.app.controller.ListaController;
import com.mds.app.model.ProjetoModel;
import com.mds.app.persistencia.Persistencia;

public class Perfil extends Activity {

	private ListaController listaController;
	private ProjetoModel projetoAtual;
	private String stringProjetoCompleto;
	private TextView texto;
	private ImageButton estrelaFavorito;
	private boolean favoritado;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);

		projetoAtual = ListaController.getProjetoAtual();
		listaController = new ListaController();

		stringProjetoCompleto = listaController.getStringCompletaParaPerfil();

		texto = (TextView) findViewById(R.id.texto);
		texto.setText(stringProjetoCompleto);

		favoritar_addListener();

		// if tamanho menor que 10, gravar na primeira linha
		// else gravar na primeira linha e apagar a ultima
		// manipular arquivo
		Persistencia.writeToFile(Persistencia.getFileHistorico(), stringProjetoCompleto);

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void favoritar_addListener() {
		estrelaFavorito = (ImageButton) findViewById(R.id.naoFavorito);

		if (FavoritosController.getProjetosFavoritadosCompletoStr().contains(stringProjetoCompleto)) {
			estrelaFavorito.setImageResource(R.drawable.favorito);
			favoritado = true;
		}
		else {
			estrelaFavorito.setImageResource(R.drawable.naofavorito);
			favoritado = false;
		}

		estrelaFavorito.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				FavoritosController favoritosController = new FavoritosController();
				String stringProjetoParaFavorito = listaController.getStringCompletaParaFavoritos();

				if (!favoritado) {
					estrelaFavorito.setImageResource(R.drawable.favorito);
					favoritado = true;
					favoritosController.adicionarFavorito(projetoAtual, stringProjetoParaFavorito);
				}
				else {
					estrelaFavorito.setImageResource(R.drawable.naofavorito);
					favoritado = false;
					favoritosController.removerFavorito(projetoAtual, stringProjetoParaFavorito);
				}
			}
		});
	}

}
