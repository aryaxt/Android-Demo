package com.aryaxt.demo.service.implementations;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

import com.aryaxt.demo.service.interfaces.IRestServiceProvider;
import com.squareup.okhttp.HttpResponseCache;
import com.squareup.okhttp.OkHttpClient;

public class RestServiceProvider implements IRestServiceProvider {

	public <T> T getService(Class<T> clazz) {
		OkHttpClient okHttpClient = new OkHttpClient();
	    File cacheDir = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString());
		
		try {
			okHttpClient.setResponseCache(new HttpResponseCache(cacheDir, 1024));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    RestAdapter restAdapter = new RestAdapter.Builder()
        	.setClient(new OkClient(okHttpClient))
        	.setServer("https://api.github.com")
        	.build();
	    
	    return restAdapter.create(clazz);
	}
}
