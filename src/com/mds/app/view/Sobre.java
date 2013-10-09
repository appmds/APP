package com.mds.app.view;

import com.mds.app.R;
import com.mds.app.R.layout;
import com.mds.app.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Sobre extends Activity {
	
	ImageButton voltar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobre);
		addListenerOnButtonVoltar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sobre, menu);
		return true;
	}
	
	private void addListenerOnButtonVoltar() {
		voltar = (ImageButton) findViewById(R.id.voltar);
		voltar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(Sobre.this,
						"Voltar!", Toast.LENGTH_SHORT).show();
				
				Intent i = new Intent(Sobre.this, MainActivity.class);
        		startActivity(i); 
				
			}
		});
	}

}
