package com.mds.app.view;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.mds.app.R;
import com.mds.app.controller.BuscaController;
import com.mds.app.controller.ListaController;
import com.mds.app.model.ProjetoModel;
import com.mds.app.util.CancelTaskOnCancelListener;
import com.mds.app.util.ConexaoInternet;

public class Busca extends Activity {

	private ProgressDialog progressDialog;
	private ImageButton botaoPesquisar;
	private BuscaController buscaController;
	private ConexaoInternet conexao;

	public Busca() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
		StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.activity_busca);

		buscaController = new BuscaController();
		conexao = new ConexaoInternet(this);

		botaoPesquisar_addListener();

		if (conexao.ChecarConexaoInternet()) {
			buscaController.setTemConexao(true);
		}
		else {
			/* implementar nova persistencia */
		}
	}

	private void botaoPesquisar_addListener() {
		botaoPesquisar = (ImageButton) findViewById(R.id.okbutton);
		botaoPesquisar.setOnClickListener(new OnClickListener() {

			Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
			Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
			EditText numeroTexto = (EditText) findViewById(R.id.textNumero);
			EditText anoTexto = (EditText) findViewById(R.id.textAno);
			EditText dataInicialTexto = (EditText) findViewById(R.id.textDataIni);
			EditText nomeAutorTexto = (EditText) findViewById(R.id.textNomeAutor);
			EditText siglaPartidoTexto = (EditText) findViewById(R.id.textSiglaPartido);

			@Override
			public void onClick(View v) {

				boolean validacao = buscaController.atualizarDadosDaPesquisa(anoTexto.getText().toString(),
						String.valueOf(spinner1.getSelectedItem()), numeroTexto.getText().toString(),
						dataInicialTexto.getText().toString(), nomeAutorTexto.getText().toString(),
						siglaPartidoTexto.getText().toString(), String.valueOf(spinner2.getSelectedItem()));
				if (validacao) {
					new PesquisarProjetoTask().execute();
				}
				else {
					Toast.makeText(Busca.this, "Dados Invalidos", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class PesquisarProjetoTask extends AsyncTask<Void, Void, List<ProjetoModel>> {

		@Override
		protected void onPreExecute() {

			progressDialog = ProgressDialog.show(Busca.this, "Aguarde...", "Recebendo dados", true, true);
			progressDialog.setOnCancelListener(new CancelTaskOnCancelListener(this));

		}

		@Override
		protected List<ProjetoModel> doInBackground(Void... params) {
			Log.i("LOGGER", "Starting...doInBackground loadList");
			return buscaController.procurar();
		}

		@Override
		protected void onPostExecute(final List<ProjetoModel> result) {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					ListaController.setListaProjetos(result);
					Intent intent = new Intent(Busca.this, Lista.class);
					startActivity(intent);
				}
			});
		}

	}
}
