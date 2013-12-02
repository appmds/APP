package com.mds.app.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;

public class CancelTaskOnCancelListener implements OnCancelListener {

	private AsyncTask<?, ?, ?> task;

	public CancelTaskOnCancelListener(AsyncTask<?, ?, ?> task) {
		this.task = task;
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		if (task != null) {
			task.cancel(true);
		}
	}

}