package com.aryaxt.demo.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ActivityStarter implements IActivityStarter {

	private Context context;
	private IIntentProxy intentProxy;
	
	@Inject
	public ActivityStarter(Provider<Context> contextProvider, IIntentProxy intentProxy) {
		this.context = contextProvider.get();
		this.intentProxy = intentProxy;
	}
	
	public void startActivity(Class <? extends Activity> clazz) {
		Intent intent = intentProxy.getIntent(clazz);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
	
	public void startActivity(Intent intent) {
		context.startActivity(intent);
	}
}
