package com.mds.app.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class ConexaoInternet {

	private Context context;

	public ConexaoInternet(Context context) {
		this.context = context;
	}

	public boolean ChecarConexaoInternet() {
		ConnectivityManager conexao = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo wifi = conexao.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		android.net.NetworkInfo mobile = conexao.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		if (wifi.isConnected() || mobile.isConnected()) {
			System.out.println("thjktyejytj tem net");
			return true;
		}
		return false;
	}
}
