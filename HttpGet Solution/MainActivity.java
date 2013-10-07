package com.example.httptest;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView httpStuff;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Criando permissão para a thread, para poder usar a internet
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder() .detectAll().penaltyLog().build();	
		StrictMode.setThreadPolicy(policy);
		
		setContentView(R.layout.activity_main);
		httpStuff = (TextView) findViewById(R.id.texto);
        
        GetMethodEx g = new GetMethodEx();
		String retorno;
		try {
			retorno = g.getInternetData();
			httpStuff.setText(retorno);
		}
		catch(Exception e){	
			e.printStackTrace();
		}
	}

	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
