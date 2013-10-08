package com.mds.app.view;

import java.util.List;

import com.mds.app.R;
import com.mds.app.R.layout;
import com.mds.app.R.menu;
import com.mds.app.controller.ProjetoController;
import com.mds.app.model.ProjetoModel;
import com.mds.app.services.ProcuraProjeto;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder() .detectAll().penaltyLog().build();	
		StrictMode.setThreadPolicy(policy);
		final EditText textSigla = new EditText(this);
		final EditText textAno = new EditText(this);
		textSigla.setHint("Insira um tipo de projeto");
		textAno.setHint("Insira um ano");
		Button button = new Button(this);
		button.setWidth(100);
		button.setHeight(50);
		button.setText("Procurar");
        LinearLayout layout = new LinearLayout(this);
        layout.addView(textSigla);
        layout.addView(textAno);
        layout.addView(button);
       
        setContentView(layout);
        
        final ProjetoController projC = new ProjetoController();
        
        button.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View arg0) {
        		projC.atualizaDadosPesquisa(textAno.getText().toString(),
        				textSigla.getText().toString());
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
	        
		   progressDialog = ProgressDialog.show(MainActivity.this,
	        		"Please wait...", "Retrieving data...", true, true);
	    	
	      
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
	    		if (task!=null) {
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
			    		if (progressDialog!=null) {
			    			progressDialog.dismiss();
			    			progressDialog = null;
			    		}
			    		if (result!=null) {
							for (ProjetoModel projeto : result) {
								longToast(projeto.getNome() + " - " + projeto.getNumero());
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
	

