package com.mds.app.view;

import com.mds.app.R;
import com.mds.app.R.layout;
import com.mds.app.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		EditText textSigla = new EditText(this);
		EditText textAno = new EditText(this);
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
        
        Dialog d = new Dialog(this);
        
        button.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View arg0) {
        		
        	}
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
