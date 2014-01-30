package com.aryaxt.demo.service.interfaces;

public interface IRestServiceProvider {

	<T> T getService(Class<T> clazz);
}
