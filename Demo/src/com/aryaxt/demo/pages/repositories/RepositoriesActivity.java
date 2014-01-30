package com.aryaxt.demo.pages.repositories;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.aryaxt.demo.R;
import com.aryaxt.demo.helper.IActivityStarter;
import com.aryaxt.demo.helper.IAlertBuilder;
import com.aryaxt.demo.helper.IIntentProxy;
import com.aryaxt.demo.helper.IProgressBuilder;
import com.aryaxt.demo.pages.contributors.ContributorsActivity;
import com.aryaxt.demo.service.interfaces.IGithubService;
import com.aryaxt.demo.service.models.Repository;
import com.google.inject.Inject;

public class RepositoriesActivity extends RoboActivity {
	
	@Inject IGithubService githubService;
	@Inject IAlertBuilder alertBuilder;
	@Inject IProgressBuilder progressBuilder;
	@Inject IIntentProxy intentProxy;
	@Inject IActivityStarter activityStarter;
	@Inject RepositoriesAdapter repositoriesAdapter;
	@InjectView(R.id.listView) ListView listView;
	static String USERNAME = "JakeWharton";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.repositories);
		
		progressBuilder.show("Loading", "Loading repositories please wait...");
		
		githubService.getRepositories(USERNAME, new Callback<List<Repository>>() {

			@Override
            public void failure(RetrofitError error) {
				progressBuilder.dismiss();
				alertBuilder.show("Error", error.getMessage());
            }

			@Override
            public void success(List<Repository> repository, Response response) {
	        	progressBuilder.dismiss();
	        	
	        	repositoriesAdapter.setData(repository);
	        	listView.setAdapter(repositoriesAdapter);
            }
		});
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Repository repository = (Repository) listView.getItemAtPosition(position);
				Intent intent = intentProxy.getIntent(ContributorsActivity.class);
				intent.putExtra("repository", repository);
				activityStarter.startActivity(intent);
            }
		});
	} 
}
