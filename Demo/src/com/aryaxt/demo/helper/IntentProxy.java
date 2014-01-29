package com.aryaxt.demo.helper;

import java.io.Serializable;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class IntentProxy implements IIntentProxy {

	private Context context;
	
	@Inject
	public IntentProxy(Provider<Context> contextProvider) {
		context = contextProvider.get();
	}
	
	public Intent getIntent(Class <? extends Activity> clazz) {
		return new Intent(context, clazz);
	}
	
	public Intent getIntent(Class <? extends Activity> clazz, int intentFlag) {
		Intent intent = getIntent(clazz);
		intent.setFlags(intentFlag);
		
		return intent;
	}
	
	public Intent getIntent(Class <? extends Activity> clazz, String extraKey, Serializable serializable) {
		Intent intent = getIntent(clazz);
		intent.putExtra(extraKey, serializable);
		
		return intent;
	}
}
