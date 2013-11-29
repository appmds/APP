package com.mds.app.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.mds.app.R;
import com.mds.app.controller.FavoritosController;
import com.mds.app.controller.HistoricoController;
import com.mds.app.controller.ListaController;
import com.mds.app.persistencia.Persistencia;

public class MenuPrincipal extends Activity {

	Context context = this;
	ImageButton busca;
	ImageButton sobre;
	Button favoritos;
	Button historico;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_principal);

		Persistencia persistencia = new Persistencia(context);
		String conteudoHistorico = persistencia.lerDoArquivo(Persistencia.getFileNameHistorico());
		String conteudoFavoritos = persistencia.lerDoArquivo(Persistencia.getFileNameFavoritos());

		FavoritosController favoritosController = new FavoritosController(context);
		favoritosController.popularProjetos(conteudoFavoritos);

		HistoricoController historicoController = new HistoricoController(context);
		historicoController.popularProjetos(conteudoHistorico);

		busca_addListener();
		sobre_addListener();
		favoritos_addListener();
		historico_addListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void busca_addListener() {
		busca = (ImageButton) findViewById(R.id.imgbutton_busca);
		busca.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuPrincipal.this, Busca.class);
				startActivity(i);
			}
		});
	}

	private void sobre_addListener() {
		sobre = (ImageButton) findViewById(R.id.imgbutton_sobre);
		sobre.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuPrincipal.this, Sobre.class);
				startActivity(i);
			}
		});
	}

	private void favoritos_addListener() {
		favoritos = (Button) findViewById(R.id.favoritos);
		favoritos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Persistencia persistencia = new Persistencia(context);

				String strConteudoFavoritos = persistencia.lerDoArquivo(Persistencia.getFileNameFavoritos());
				Log.i("LOGGER", "Conteudo historico: " + strConteudoFavoritos);

				ListaController.setListaProjetos(FavoritosController.getProjetosFavoritados());
				Log.i("ADDL-F", FavoritosController.getProjetosFavoritados().toString());
				Log.i("ADDL-F", ListaController.getListaProjetos().toString());
				Intent i = new Intent(MenuPrincipal.this, Lista.class);
				startActivity(i);
			}
		});
	}

	private void historico_addListener() {
		historico = (Button) findViewById(R.id.historico);
		historico.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Persistencia persistencia = new Persistencia(context);

				String strConteudoHistorico = persistencia.lerDoArquivo(Persistencia.getFileNameHistorico());
				Log.i("LOGGER", "Conteudo historico: " + strConteudoHistorico);

				ListaController.setListaProjetos(HistoricoController.getProjetosHistorico());
				Intent i = new Intent(MenuPrincipal.this, Lista.class);
				startActivity(i);
			}
		});
	}

}
