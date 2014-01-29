package com.aryaxt.demo.helper;

import java.util.ArrayList;
import java.util.Collection;

import com.google.inject.Inject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public abstract class AbstractAdapter<T> extends ArrayAdapter<T> {

	@Inject
	private LayoutInflater layoutInflater;
	private ArrayList<T> items;

	public AbstractAdapter(Context context) {
		super(context, 0);
	}
	
	public T getItemAtPosition(int position) {
		return items.get(position);
	}

	protected void setText(String text, int labelId, View view) {
		setText(text, "", labelId, view);
	}
	
	protected void setText(String text, String defaultText, int labelId, View view) {
		TextView textView = (TextView) view.findViewById(labelId);
		textView.setText((text == null || text.length() == 0) ? defaultText : text);
	}
	
	protected View getReusableView(View view, int viewId) {
		if (view != null)
			return view;
		
		return layoutInflater.inflate(viewId, null);
	}

	@SuppressLint("NewApi")
    public void setData(Collection<? extends T> collection) {
		this.items = new ArrayList<T>(collection);
		super.clear();
		super.addAll(collection);
	}
}
