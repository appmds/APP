package com.mds.app.view;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mds.app.R;
import com.mds.app.controller.ProjetoController;
import com.mds.app.model.ProjetoModel;
import com.mds.app.services.ProcuraProjeto;

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
		addListenerOnButtonOK();
		addListenerOnButtonVoltar();


	}
	
	private void addListenerOnButtonVoltar() {
		voltar = (ImageButton) findViewById(R.id.voltar);
		voltar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(Busca.this,
						"Voltar!", Toast.LENGTH_SHORT).show();
				
				Intent i = new Intent(Busca.this, MainActivity.class);
        		startActivity(i); 
				
			}
		});
	}

	private void addListenerOnButtonOK() {
		ok = (ImageButton) findViewById(R.id.okbutton);
		ok.setOnClickListener(new OnClickListener() {

			EditText textSigla = (EditText) findViewById(R.id.textSigla);
			EditText textAno = (EditText) findViewById(R.id.textAno);

			@Override
			public void onClick(View v) {
				Toast.makeText(Busca.this, "OK!", Toast.LENGTH_SHORT).show();

				final ProjetoController projC = new ProjetoController();
				projC.atualizarDadosDaPesquisa(textAno.getText().toString(), textSigla.getText().toString());
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

	public void longToast(CharSequence message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}

	private void executarPesquisa(String query) {

		progressDialog = ProgressDialog.show(Busca.this, "Please wait...", "Retrieving data...", true, true);

		PerformMovieSearchTask task = new PerformMovieSearchTask();
		task.execute(query);
		progressDialog.setOnCancelListener(new CancelTaskOnCancelListener(task));

	}

	private class CancelTaskOnCancelListener implements OnCancelListener {
		private AsyncTask<?, ?, ?> task;

		public CancelTaskOnCancelListener(AsyncTask<?, ?, ?> task) {
			this.task = task;
		}

		@Override
		public void onCancel(DialogInterface dialog) {
			if (task != null) {
				task.cancel(true);
			}
		}
	}

	private class PerformMovieSearchTask extends AsyncTask<String, Void, List<ProjetoModel>> {

		@Override
		protected List<ProjetoModel> doInBackground(String... params) {
			String query = params[0];
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
							longToast(projeto.getExplicacao() + " - " + projeto.getNumero());
						}
					}
					else {
						System.out.println("Nao retornou nada!");
					}
				}
			});
		}

	}

}
