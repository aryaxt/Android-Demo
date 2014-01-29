package com.aryaxt.demo.helper;

import android.app.Activity;
import android.content.Intent;

public interface IActivityStarter {

	void startActivity(Class <? extends Activity> clazz);
	void startActivity(Intent intent);
}
