package com.aryaxt.demo.service.implementations;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.Path;
import com.aryaxt.demo.service.interfaces.IGithubService;
import com.aryaxt.demo.srrvice.models.User;
import com.aryaxt.demo.srrvice.models.Repository;
import com.google.inject.Inject;
import com.squareup.okhttp.HttpResponseCache;
import com.squareup.okhttp.OkHttpClient;

public class GithubService implements IGithubService {
	
	private IGithubService service;
	
	@Inject
	public GithubService() {
		
		try {
			OkHttpClient okHttpClient = new OkHttpClient();
		    File cacheDir = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString());
			okHttpClient.setResponseCache(new HttpResponseCache(cacheDir, 1024));
			
		    RestAdapter restAdapter = new RestAdapter.Builder()
		        .setClient(new OkClient(okHttpClient))
		        .setServer("https://api.github.com")
		        .build();
		    
		    service = restAdapter.create(IGithubService.class);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void GetContributors(String username, String repo, Callback<List<User>> callBack) {
		service.GetContributors(username, repo, callBack);
	}
	
	public void GetRepositories(@Path("user") String username, Callback<List<Repository>> callBack) {
		service.GetRepositories(username, callBack);
	}
}
