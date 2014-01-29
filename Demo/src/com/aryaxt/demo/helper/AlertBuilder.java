package com.aryaxt.demo.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.InputType;
import android.widget.EditText;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class AlertBuilder implements IAlertBuilder {

	private AlertDialog alertDialog;
	private String title;
	private String message;
	private boolean showInput;
	private ButtonInfo positiveButtonInfo;
	private ButtonInfo negativeButtonInfo;
	private EditText input;
	private Context context;
	
	@Inject
	public AlertBuilder(Provider<Context> contextProvider) {
		this.context = contextProvider.get();
	}
	
	public void show(String title, String message) {
		this.title = title;
		this.message = message;
		
		show();
	}
	
	public void showWithInput(String title, String message) {
		this.showInput = true;
		
		show(title, message);
	}
	
	public void setPositiveButton(String title, DialogInterface.OnClickListener onClickListener) {
		positiveButtonInfo = new ButtonInfo(title, onClickListener);
	}
	
	public void setNegativeButton(String title, DialogInterface.OnClickListener onClickListener) {
		negativeButtonInfo = new ButtonInfo(title, onClickListener);
	}
	
	public void dismiss() {
		if (alertDialog != null)
			alertDialog.dismiss();
	}
	
	public String getInputText() {
		return input.getText().toString();
	}
	
	private void show() {
		AlertDialog.Builder alertBuilder =  new AlertDialog.Builder(context);
		
		alertBuilder.setTitle(title);
		alertBuilder.setMessage(message);
		
		if (showInput) {
			this.input = new EditText(context);
			this.input.setInputType(InputType.TYPE_CLASS_TEXT);
			alertBuilder.setView(input);
		}
		
		if (positiveButtonInfo != null) 
			alertBuilder.setPositiveButton(positiveButtonInfo.title, positiveButtonInfo.onClickListener);
		
		if (negativeButtonInfo != null) 
			alertBuilder.setNegativeButton(negativeButtonInfo.title, negativeButtonInfo.onClickListener);
		
		if (positiveButtonInfo == null && negativeButtonInfo == null) {
			alertBuilder.setPositiveButton("Ok", new OnClickListener() {
				@Override
                public void onClick(DialogInterface arg0, int arg1) {
					alertDialog.dismiss();
                }
			});
		}
			
		alertDialog = alertBuilder.create();
		alertBuilder.show();
	}
	
	private class ButtonInfo {
		
		private String title;
		private DialogInterface.OnClickListener onClickListener;
		
		public ButtonInfo(String title, DialogInterface.OnClickListener onClickListener)
		{
			this.title = title;
			this.onClickListener = onClickListener;
		}
	}
}
