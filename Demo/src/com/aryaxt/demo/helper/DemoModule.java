package com.aryaxt.demo.helper;

import com.aryaxt.demo.service.implementations.GithubService;
import com.aryaxt.demo.service.implementations.RestServiceProvider;
import com.aryaxt.demo.service.interfaces.IGithubService;
import com.aryaxt.demo.service.interfaces.IRestServiceProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class DemoModule extends AbstractModule {

	@Override
	protected void configure() {
		
		// Helpers
		bind(IAlertBuilder.class).to(AlertBuilder.class);
		bind(IProgressBuilder.class).to(ProgressBuilder.class);
		bind(IActivityStarter.class).to(ActivityStarter.class);
		bind(IIntentProxy.class).to(IntentProxy.class);
		
		// Services
		bind(IRestServiceProvider.class).to(RestServiceProvider.class).in(Singleton.class);
		bind(IGithubService.class).to(GithubService.class);
	}
}
