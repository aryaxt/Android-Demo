package com.aryaxt.demo.service.implementations;

import java.util.List;
import retrofit.Callback;
import com.aryaxt.demo.service.interfaces.IGithubService;
import com.aryaxt.demo.service.interfaces.IRestServiceProvider;
import com.aryaxt.demo.service.models.Repository;
import com.aryaxt.demo.service.models.User;
import com.google.inject.Inject;

public class GithubService implements IGithubService {
	
	private IGithubService service;
	
	@Inject
	public GithubService(IRestServiceProvider restServiceProvider) {
		service = restServiceProvider.getService(IGithubService.class);
	}
	
	public void getContributors(String username, String repo, Callback<List<User>> callBack) {
		service.getContributors(username, repo, callBack);
	}
	
	public void getRepositories(String username, Callback<List<Repository>> callBack) {
		service.getRepositories(username, callBack);
	}
}
