package com.mds.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mds.app.R;

public class MainActivity extends Activity {
	
	ImageButton busca;
	ImageButton sobre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnButtonBusca();
		addListenerOnButtonSobre();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void addListenerOnButtonBusca() {
		busca = (ImageButton) findViewById(R.id.imgbutton_busca);
		busca.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this,
						"Busca!", Toast.LENGTH_SHORT).show();
				
				Intent i = new Intent(MainActivity.this, Busca.class);
        		startActivity(i); 
				
			}
		});
	}
	
	private void addListenerOnButtonSobre() {
		sobre = (ImageButton) findViewById(R.id.imgbutton_sobre);
		sobre.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this,
						"Sobre!", Toast.LENGTH_SHORT).show();
				
				Intent i = new Intent(MainActivity.this, Sobre.class);
        		startActivity(i); 
				
			}
		});
	}

}
