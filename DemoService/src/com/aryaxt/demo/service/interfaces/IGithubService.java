package com.aryaxt.demo.service.interfaces;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import com.aryaxt.demo.service.models.Repository;
import com.aryaxt.demo.service.models.User;

public interface IGithubService {

	@GET("/repos/{user}/{repo}/contributors")
	void getContributors(@Path("user") String username, @Path("repo") String repo, Callback<List<User>> callBack);
	
	@GET("/users/{user}/repos")
	void getRepositories(@Path("user") String username, Callback<List<Repository>> callBack);
}
