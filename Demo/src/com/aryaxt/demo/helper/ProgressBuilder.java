package com.aryaxt.demo.helper;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressBuilder implements IProgressBuilder {

	private ProgressDialog progressDialog;

	@Inject
	public ProgressBuilder(Provider<Context> contextProvider) {
		progressDialog = new ProgressDialog(contextProvider.get());
	}

	public void show() {
		show("Loading...", null);
	}

	public void show(String title) {
		this.show(title, null);
	}

	public void show(String title, String message) {
		progressDialog.setTitle(title);
		progressDialog.setMessage(message);
		progressDialog.show();
	}

	public void dismiss() {
		progressDialog.dismiss();
	}
}
