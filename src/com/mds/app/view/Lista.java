package com.mds.app.view;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mds.app.R;
import com.mds.app.controller.ListaController;
import com.mds.app.controller.ProposicaoController;
import com.mds.app.model.ProjetoModel;

public class Lista extends Activity {
	ArrayList<ListElement> elementos = new ArrayList<ListElement>();
	private ScrollView MainView;
	private LinearLayout ViewLayout;
	private LinearLayout ViewText;
	private ProposicaoController pesquisa;
	private ListaController listar;
	private ArrayList<String> stringProjetos;
	private ArrayList<TextView> textViews = new ArrayList<TextView>();

	public Lista() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MainView = new ScrollView(this);
		ViewLayout = new LinearLayout(this);
		ViewLayout.setOrientation(LinearLayout.VERTICAL);
		ViewText = new LinearLayout(this);
		ViewText.setOrientation(LinearLayout.VERTICAL);

		Intent intent = getIntent();
		intent.getExtras().getStringArrayList("PROJETOS");
		stringProjetos = intent.getStringArrayListExtra("PROJETOS");

		for (int i = 0; i < 9; i++) {
			if (i % 2 == 0) {
				elementos.add(new ListElement(this, "YELLOW"));
			}
			else {
				elementos.add(new ListElement(this, "BLUE"));
			}
			elementos.get(i).setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 100));
		}

		for (int i = 0; i < stringProjetos.size(); i++) {
			TextView text = new TextView(this);
			text.setY(i * 50);
			text.setText(stringProjetos.get(i));
			textViews.add(text);
		}

		for(int i = 0; i<textViews.size(); i++){
			ViewText.addView(textViews.get(i));
		}

		for (int i = 0; i < 9; i++) {
			ViewLayout.addView(elementos.get(i));
		}

		ViewLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		ViewLayout.requestLayout();
		// ViewText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		ViewText.requestLayout();

		MainView.addView(ViewText);
		setContentView(MainView);

	}

	class ListElement extends View {
		public ListElement(Context context, String TypeName) {
			super(context);

			if (TypeName.compareTo("YELLOW") == 0) {
				this.setBackgroundColor(Color.YELLOW);
			}

			if (TypeName.compareTo("BLUE") == 0) {
				this.setBackgroundColor(Color.BLUE);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void longToast(CharSequence message) {
		Toast.makeText(Lista.this, message, Toast.LENGTH_LONG).show();
	}

	public ListaController getListaController() {
		return listar;
	}

	public void setListaController(ListaController listar) {
		this.listar = listar;
	}
}