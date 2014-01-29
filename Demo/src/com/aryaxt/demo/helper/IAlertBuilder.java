package com.aryaxt.demo.helper;

import android.content.DialogInterface;

public interface IAlertBuilder {
	
	void dismiss();
	String getInputText();
	void show(String title, String message);
	void showWithInput(String title, String message);
	void setPositiveButton(String title, DialogInterface.OnClickListener onClickListener);
	void setNegativeButton(String title, DialogInterface.OnClickListener onClickListener);
}
