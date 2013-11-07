package com.mds.app.view;

import java.util.ArrayList;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mds.app.R;
import com.mds.app.controller.ListaController;
import com.mds.app.controller.ProposicaoController;
import com.mds.app.util.StableArrayAdapter;

public class Lista extends Activity {
	
	private ListaController listar;
	private ArrayList<String> stringProjetos;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ListView listview = new ListView(this);
		

		Intent intent = getIntent();
		intent.getExtras().getStringArrayList("PROJETOS");
		stringProjetos = intent.getStringArrayListExtra("PROJETOS");
		
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
		        android.R.layout.simple_list_item_1, stringProjetos);
		    listview.setAdapter(adapter);

		    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
		        final String item = (String) parent.getItemAtPosition(position);
		        view.animate().setDuration(2000).alpha(0)
		            .withEndAction(new Runnable() {
		              @Override
		              public void run() {
		            	  stringProjetos.remove(item);
		                adapter.notifyDataSetChanged();
		                view.setAlpha(1);
		              }
		            });
		      }
		    });

		setContentView(listview);

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
}