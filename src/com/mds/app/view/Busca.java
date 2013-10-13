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
import android.widget.Toast;

import com.mds.app.R;
import com.mds.app.controller.BuscaController;
import com.mds.app.model.ProjetoModel;
import com.mds.app.util.CancelTaskOnCancelListener;

public class Busca extends Activity {

	ProgressDialog dialogoProgresso;
	ImageButton ok;
	ImageButton voltar;
	BuscaController pesquisa = new BuscaController();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
		StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.activity_busca);

		ok_addListener();
		voltar_addListener();

	}

	private void voltar_addListener() {
		voltar = (ImageButton) findViewById(R.id.voltar);
		voltar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(Busca.this, "Voltar!", Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Busca.this, MenuPrincipal.class);
				startActivity(i);

			}
		});
	}

	private void ok_addListener() {
		ok = (ImageButton) findViewById(R.id.okbutton);
		ok.setOnClickListener(new OnClickListener() {

			EditText siglaTexto = (EditText) findViewById(R.id.textSigla);
			EditText numeroTexto = (EditText) findViewById(R.id.textNumero);
			EditText anoTexto = (EditText) findViewById(R.id.textAno);
			EditText dataInicialTexto = (EditText) findViewById(R.id.textDataIni);
			EditText nomeAutorTexto = (EditText) findViewById(R.id.textNomeAutor);
			EditText siglaPartidoTexto = (EditText) findViewById(R.id.textSiglaPartido);
			EditText UFTexto = (EditText) findViewById(R.id.textUF);

			@Override
			public void onClick(View v) {
				Toast.makeText(Busca.this, "OK!", Toast.LENGTH_SHORT).show();
				
				pesquisa.atualizarDadosDaPesquisa(anoTexto.getText().toString(), siglaTexto.getText().toString(),
						numeroTexto.getText().toString(), dataInicialTexto.getText().toString(), nomeAutorTexto.getText().toString(),
								siglaPartidoTexto.getText().toString(), UFTexto.getText().toString());
				executarPesquisa();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void executarPesquisa() {

		new PesquisarProjetoTask().execute();

	}

	private class PesquisarProjetoTask extends AsyncTask<Void, Void, List<ProjetoModel>> {

		protected void onPreExecute(){
			
			dialogoProgresso = ProgressDialog.show(Busca.this, "Aguarde...", "Recebendo dados", true, true);
			dialogoProgresso.setOnCancelListener(new CancelTaskOnCancelListener(this));
			
		}
		@Override
		protected List<ProjetoModel> doInBackground(Void... params) {
			//String query = params[0];
			Log.i("LOGGER", "Starting...doInBackground loadList"); 
			return pesquisa.procurar();
		}
		
		@Override
		protected void onPostExecute(final List<ProjetoModel> result) {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					if (dialogoProgresso != null) {
						dialogoProgresso.dismiss();
						dialogoProgresso = null;
					}
					if (result != null) {
						for (int i = 0; i<result.size(); i++) {
							CharSequence mensagem = result.get(i).getExplicacao() + " - " + result.get(i).getNumero() + " - " + result.get(i).getNome();
							longToast(mensagem);
						}
					}
					else {
						CharSequence mensagem = "Nenhum projeto encontrado.";
						longToast(mensagem);
					}
				}
			});
		}

		private void longToast(CharSequence message) {
			Toast.makeText(Busca.this, message, Toast.LENGTH_LONG).show();
		}

	}

}
