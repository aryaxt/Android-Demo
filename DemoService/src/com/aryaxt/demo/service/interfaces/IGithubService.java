package com.aryaxt.demo.service.interfaces;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import com.aryaxt.demo.srrvice.models.User;
import com.aryaxt.demo.srrvice.models.Repository;

public interface IGithubService {

	@GET("/repos/{user}/{repo}/contributors")
	void GetContributors(@Path("user") String username, @Path("repo") String repo, Callback<List<User>> callBack);
	
	@GET("/users/{user}/repos")
	void GetRepositories(@Path("user") String username, Callback<List<Repository>> callBack);
}
