package com.aryaxt.demo.helper;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;

public interface IIntentProxy {

	Intent getIntent(Class <? extends Activity> clazz);
	Intent getIntent(Class <? extends Activity> clazz, int intentFlag);
	Intent getIntent(Class <? extends Activity> clazz, String extraKey, Serializable serializable);
}
