package com.mds.app.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import com.mds.app.R;
import com.mds.app.controller.FavoritosController;
import com.mds.app.controller.HistoricoController;
import com.mds.app.controller.ListaController;
import com.mds.app.model.ProjetoModel;

public class Perfil extends Activity {

	private ListaController listaController;
	private ProjetoModel projetoAtual;
	private String stringProjetoCompleto;
	private TextView texto1;
	private TextView texto2;
	private TextView texto3;
	private TextView texto4;
	private TextView texto5;
	private ImageButton estrelaFavorito;
	private ImageButton botaoFacebook;
	private boolean favoritado;
	Context context = this;
	private boolean isResumed = false;

	private UiLifecycleHelper uiHelper;
	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state, Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);

		uiHelper = new UiLifecycleHelper(this, callback);
		uiHelper.onCreate(savedInstanceState);

		facebook_addListener();

		projetoAtual = ListaController.getProjetoAtual();
		listaController = new ListaController();

		stringProjetoCompleto = listaController.getStringCompletaParaPerfil();

		texto1 = (TextView) findViewById(R.id.textoTipoProjeto);
		texto1.setText(projetoAtual.getNome());
		texto2 = (TextView) findViewById(R.id.textoCarcteristicasProjeto);
		texto2.setText("Número: " + projetoAtual.getNumero() + "\n" + "Ano: " + projetoAtual.getAno() + "\n" + "Sigla: "+ projetoAtual.getSigla() + "\n" + "Data de Apresentação: " + "\n" + projetoAtual.getData());
		texto3 = (TextView) findViewById(R.id.textoDescricao);
		texto3.setText("\n" + "\n" + "Descrição:" + "\n" + projetoAtual.getExplicacao());
		texto4 = (TextView) findViewById(R.id.textoParlamentar);
		texto4.setText("Parlamentar");
		texto5 = (TextView) findViewById(R.id.textoCarcteristicasParlamentar);
		texto5.setText("Nome: " + "\n" + projetoAtual.getParlamentar().getNome() + "\n" + "Partido: " + "\n" + projetoAtual.getParlamentar().getPartido().getSiglaPartido());

		favoritar_addListener();

		final int projetosNoHistorico = HistoricoController.getNumeroDeProjetosNoHistorico();
		final int maxProjetos = HistoricoController.getMaxProjetos();
		String stringProjetoParaHistorico = listaController.getStringCompletaParaArquivo();
		HistoricoController historicoController = new HistoricoController(context);

		/*
		 * Arrumar a remocao, se acima do limite permitido na
		 * HistoricoController. E nao adicionar dois projetos iguais
		 */
		if (projetosNoHistorico < maxProjetos) {
			historicoController.adicionar(projetoAtual, stringProjetoParaHistorico);
		}
		else {
			Log.i("LOGGER", "Removendo do historico: " + HistoricoController.getProjetoMaisVelho().getNumero());
			historicoController.remover(HistoricoController.getProjetoMaisVelho(),
					HistoricoController.getStringProjetoMaisVelho());
			historicoController.adicionar(projetoAtual, stringProjetoParaHistorico);
		}
		Log.i("LOGGER", "Adicionando ao historico: " + projetoAtual.getNumero());

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
			@Override
			public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
				Log.e("Activity", String.format("Error: %s", error.toString()));
			}

			@Override
			public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
				Log.i("Activity", "Success!");
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void facebook_addListener() {
		final Activity activity = this;
		botaoFacebook = (ImageButton) findViewById(R.id.logoFacebook);

		botaoFacebook.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(activity).setLink(
						"https://www.google.com").build();
				uiHelper.trackPendingDialogCall(shareDialog.present());
			}
		});

	}

	private void favoritar_addListener() {
		estrelaFavorito = (ImageButton) findViewById(R.id.naoFavorito);

		String stringProjetoParaFavorito = listaController.getStringCompletaParaArquivo();
		if (FavoritosController.getProjetosFavoritadosCompletoStr().contains(stringProjetoParaFavorito)) {
			estrelaFavorito.setImageResource(R.drawable.favorito);
			favoritado = true;
		}
		else {
			estrelaFavorito.setImageResource(R.drawable.naofavorito);
			favoritado = false;
		}

		estrelaFavorito.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				FavoritosController favoritosController = new FavoritosController(context);
				String stringProjetoParaFavorito = listaController.getStringCompletaParaArquivo();

				if (!favoritado) {
					estrelaFavorito.setImageResource(R.drawable.favorito);
					favoritado = true;
					favoritosController.adicionar(projetoAtual, stringProjetoParaFavorito);
					Log.i("LOGGER", "Favoritando: " + projetoAtual.getNumero());
				}
				else {
					estrelaFavorito.setImageResource(R.drawable.naofavorito);
					favoritado = false;
					favoritosController.remover(projetoAtual, stringProjetoParaFavorito);
					Log.i("LOGGER", "Desfavoritando: " + projetoAtual.getNumero());
				}
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		uiHelper.onResume();
		isResumed = true;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
		isResumed = false;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
		if (isResumed) {
			if (exception != null && !(exception instanceof FacebookOperationCanceledException)) {
				Toast.makeText(this, "ERRO!", Toast.LENGTH_SHORT).show();
				return;
			}
		}
	}

}
