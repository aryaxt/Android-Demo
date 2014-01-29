package com.aryaxt.demo.test.helpers;

import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import roboguice.RoboGuice;
import android.app.Activity;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

@RunWith(RobolectricTestRunner.class)
public abstract class BaseTest {

	protected Injector injector;

    public void setUp() {

		MockitoAnnotations.initMocks(this);
		
		RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new DemoTestModule()));
		injector = RoboGuice.getInjector(Robolectric.application);
    	injector.injectMembers(this);
	}
	
	public void tearDown() {
		
	}
	
	protected <T extends Activity> T getActivity(Class<T> clazz) {
		return Robolectric.buildActivity(clazz).create().get();
	}
}
