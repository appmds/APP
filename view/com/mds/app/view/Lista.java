package com.mds.app.view;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mds.app.R;
import com.mds.app.controller.ListaController;
import com.mds.app.util.StableArrayAdapter;

public class Lista extends Activity {

	private ListaController listaController;
	private ArrayList<String> stringProjetos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ListView listView = new ListView(this);
		listaController = new ListaController();

		stringProjetos = listaController.transformarLista();
		Log.i("LISTA", stringProjetos.toString());

		final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1,
				stringProjetos);

		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
				view.animate().setDuration(1).alpha(1).withEndAction(new Runnable() {
					@Override
					public void run() {
						if (!stringProjetos.get(position).equals("Nada encontrado.")) {
							ListaController.setProjetoAtual(ListaController.getListaProjetos().get(position));
							Intent i = new Intent(Lista.this, Perfil.class);
							startActivity(i);
						}
						else {
							longToast("Nenhuma proposicao encontrada.");
						}
					}
				});
			}
		});

		listView.setBackgroundResource(R.drawable.app_bg);

		setContentView(listView);

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(Lista.this, Busca.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void longToast(CharSequence message) {
		Toast.makeText(Lista.this, message, Toast.LENGTH_LONG).show();
	}

}