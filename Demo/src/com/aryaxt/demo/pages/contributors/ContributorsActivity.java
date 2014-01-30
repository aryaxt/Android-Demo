package com.aryaxt.demo.pages.contributors;

import java.util.List;

import com.aryaxt.demo.R;
import com.aryaxt.demo.helper.IAlertBuilder;
import com.aryaxt.demo.helper.IProgressBuilder;
import com.aryaxt.demo.service.interfaces.IGithubService;
import com.aryaxt.demo.service.models.Repository;
import com.aryaxt.demo.service.models.User;
import com.google.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectExtra;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.ListView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ContributorsActivity extends RoboActivity {
	
	@Inject IGithubService githubService;
	@Inject IAlertBuilder alertBuilder;
	@Inject IProgressBuilder progressBuilder;
	@Inject ContributorsAdapter contributorAdapter;
	@InjectView(R.id.listView) ListView listView;
	@InjectExtra("repository") Repository repository;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.contributors);
		
		progressBuilder.show("Loading", "Loading contributors please wait...");
		
		githubService.getContributors(repository.getOwner().getLogin(), repository.getName(), new Callback<List<User>>() {

			@Override
            public void failure(RetrofitError error) {
				progressBuilder.dismiss();
				alertBuilder.show("Error", error.getMessage());
            }

			@Override
            public void success(List<User> contributors, Response response) {
	        	progressBuilder.dismiss();
	        	
	        	contributorAdapter.setData(contributors);
	        	listView.setAdapter(contributorAdapter);
            }
		});
	} 
}
