/*  
 *	LoginActivityTest.java
 * 	AtlasMobileTest
 *
 * 	Created by Aryan Ghassemi on Nov 19, 2013.
 *	Copyright (c) 2013 NuVasive. All rights reserved.
 */

package com.aryaxt.demo.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import retrofit.Callback;

import com.aryaxt.demo.helper.IActivityStarter;
import com.aryaxt.demo.helper.IAlertBuilder;
import com.aryaxt.demo.helper.IIntentProxy;
import com.aryaxt.demo.helper.IProgressBuilder;
import com.aryaxt.demo.pages.repositories.RepositoriesActivity;
import com.aryaxt.demo.pages.repositories.RepositoriesAdapter;
import com.aryaxt.demo.service.interfaces.IGithubService;
import com.aryaxt.demo.service.models.Repository;
import com.aryaxt.demo.test.helpers.BaseTest;
import com.google.inject.Inject;

public class RepositoriesActivityTest extends BaseTest {
	
	@Inject IGithubService githubService;
	@Inject IAlertBuilder alertBuilder;
	@Inject IProgressBuilder progressBuilder;
	@Inject IIntentProxy intentProxy;
	@Inject IActivityStarter activityStarter;
	@Inject RepositoriesAdapter repositoriesAdapter;
	
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@After
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void verifyProgressBuilderShouldShowOnInitialLoad() {
		
		// This builds activity and calls onCretae, so we can verify code in that method
		getActivity(RepositoriesActivity.class);
		Mockito.verify(progressBuilder).show(Mockito.anyString(), Mockito.anyString());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void verifyCorrectUsernameIsPassedWhenFetchingRepositories() {
		
		// This builds activity and calls onCretae, so we can verify code in that method
		getActivity(RepositoriesActivity.class);
		
		ArgumentCaptor<String> usernameArg = ArgumentCaptor.forClass(String.class);
		@SuppressWarnings("unchecked")
		ArgumentCaptor<Callback<List<Repository>>> callBackArg = ArgumentCaptor.forClass((Class) Callback.class);
		Mockito.verify(githubService).getRepositories(usernameArg.capture(), callBackArg.capture());
		assertTrue(usernameArg.getValue().equals("JakeWharton"));
	}
}
