package com.mds.app.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.mds.app.R;
import com.mds.app.persistencia.Persistencia;

public class Favoritos extends Activity {

	private TextView texto;
	String texto1 = Persistencia.readFromFile("favoritos");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favoritos);
		texto = (TextView) findViewById(R.id.texto1);
		texto.setText(texto1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
