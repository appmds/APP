package com.mds.app.util;

import android.content.Context;
import android.net.ConnectivityManager;

public abstract class ConexaoInternet {

	public boolean ChecarConexaoInternet(Context context) {
		ConnectivityManager conexao = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo wifi = conexao.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		android.net.NetworkInfo mobile = conexao.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		if (wifi.isConnected() || mobile.isConnected()) {
			return true;
		}
		return false;
	}
}
