package com.aryaxt.demo.helper;

public interface IProgressBuilder {
	
	void show();
	void show(String message);
	void show(String title, String message);
	void dismiss();
}
