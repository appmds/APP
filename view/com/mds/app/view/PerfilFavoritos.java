package com.mds.app.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mds.app.R;
import com.mds.app.persistencia.Persistencia;

public class PerfilFavoritos extends Activity {

	private TextView texto;
	String texto1 = Persistencia.readFromFile(Persistencia.getFileFavoritos());
	private ImageButton Favorito;
	private int contador = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfilfavoritos);
		texto = (TextView) findViewById(R.id.texto1);
		texto.setText(texto1);
		favoritar_addListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public TextView getTexto(){
		return texto;
	}
	
	private void favoritar_addListener() {
		Favorito = (ImageButton) findViewById(R.id.favoritos);
		Favorito.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (contador == 0) {
					Favorito.setImageResource(R.drawable.naofavorito);
					contador = 1;
					//deletar do arquivo
					Persistencia.writeToFile(Persistencia.getFileFavoritos(), "stringProjeto");
				}
				else {
					Favorito.setImageResource(R.drawable.favorito);
					contador = 0;
					//escrever no arquivo
				}
			}
		});
	}
}
