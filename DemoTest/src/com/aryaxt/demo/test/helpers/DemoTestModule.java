package com.aryaxt.demo.test.helpers;

import org.mockito.Mockito;
import com.aryaxt.demo.helper.IActivityStarter;
import com.aryaxt.demo.helper.IAlertBuilder;
import com.aryaxt.demo.helper.IIntentProxy;
import com.aryaxt.demo.helper.IProgressBuilder;
import com.aryaxt.demo.service.interfaces.IGithubService;
import com.google.inject.AbstractModule;

public class DemoTestModule extends AbstractModule {
	
    @Override
	protected void configure() {

    	// Helpers
    	bind(IAlertBuilder.class).toInstance(Mockito.mock(IAlertBuilder.class));
    	bind(IProgressBuilder.class).toInstance(Mockito.mock(IProgressBuilder.class));
    	bind(IActivityStarter.class).toInstance(Mockito.mock(IActivityStarter.class));
    	bind(IIntentProxy.class).toInstance(Mockito.mock(IIntentProxy.class));
		
		// Services
		bind(IGithubService.class).toInstance(Mockito.mock(IGithubService.class));
	}
}
