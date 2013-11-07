package com.mds.app.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class ConexaoInternet {

	private Context context;

	public ConexaoInternet(Context context) {
		this.context = context;
	}

	public boolean ChecarConexaoInternet() {
		boolean hasConnection = false;

		ConnectivityManager conexao = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo wifi = conexao.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		android.net.NetworkInfo mobile = conexao.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		if (wifi.isConnected() || mobile.isConnected()) {
			System.out.println("TEM CONEXAO COM A INTERNET");
			hasConnection = true;
		}
		else {
			System.out.println("DESCONECTADO DA INTERNET");
			hasConnection = false;
		}

		return hasConnection;
	}
}
