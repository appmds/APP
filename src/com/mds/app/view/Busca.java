package com.mds.app.view;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mds.app.R;
import com.mds.app.controller.ProjetoController;
import com.mds.app.model.ProjetoModel;
import com.mds.app.services.ProcuraProjeto;
import com.mds.app.util.CancelTaskOnCancelListener;

public class Busca extends Activity {

	ProgressDialog progressDialog;
	ImageButton ok;
	ImageButton voltar;

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

			EditText textSigla = (EditText) findViewById(R.id.textSigla);
			EditText textNumero = (EditText) findViewById(R.id.textNumero);
			EditText textAno = (EditText) findViewById(R.id.textAno);
			EditText textDataIni = (EditText) findViewById(R.id.textDataIni);
			EditText textDataFinal = (EditText) findViewById(R.id.textDataFinal);
			EditText textAutor = (EditText) findViewById(R.id.textAutor);
			EditText textNomeAutor = (EditText) findViewById(R.id.textNomeAutor);
			EditText textSiglaPartido = (EditText) findViewById(R.id.textSiglaPartido);
			EditText textUF = (EditText) findViewById(R.id.textUF);

			@Override
			public void onClick(View v) {
				Toast.makeText(Busca.this, "OK!", Toast.LENGTH_SHORT).show();

				final ProjetoController projC = new ProjetoController();
				projC.atualizarDadosDaPesquisa(textAno.getText().toString(), textSigla.getText().toString(),
						textNumero.getText().toString(), textDataIni.getText().toString(), textDataFinal.getText()
								.toString(), textAutor.getText().toString(), textNomeAutor.getText().toString(),
						textSiglaPartido.getText().toString(), textUF.getText().toString());
				executarPesquisa("");

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void executarPesquisa(String query) {

		progressDialog = ProgressDialog.show(Busca.this, "Aguarde...", "Recebendo dados...", true, true);

		PesquisarProjetoTask task = new PesquisarProjetoTask();
		task.execute(query);

		progressDialog.setOnCancelListener(new CancelTaskOnCancelListener(task));

	}

	private class PesquisarProjetoTask extends AsyncTask<String, Void, List<ProjetoModel>> {

		@Override
		protected List<ProjetoModel> doInBackground(String... params) {
			// String query = params[0];
			ProcuraProjeto procuraProjeto = new ProcuraProjeto();
			return procuraProjeto.procurar();
		}

		@Override
		protected void onPostExecute(final List<ProjetoModel> result) {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					if (progressDialog != null) {
						progressDialog.dismiss();
						progressDialog = null;
					}
					if (result != null) {
						for (ProjetoModel projeto : result) {
							CharSequence mensagem = projeto.getExplicacao() + " - " + projeto.getNumero();
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
