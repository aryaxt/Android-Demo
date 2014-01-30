package com.aryaxt.demo.pages.repositories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aryaxt.demo.R;
import com.aryaxt.demo.helper.AbstractAdapter;
import com.aryaxt.demo.service.models.Repository;
import com.google.inject.Inject;

public class RepositoriesAdapter extends AbstractAdapter<Repository> {

	@Inject
	public RepositoriesAdapter(Context context) {
		super(context);
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		view = this.getReusableView(view, R.layout.repository_row);
		
		Repository repository = getItemAtPosition(position);
		setText(repository.getName(), R.id.txtRepositoryName, view);
		setText(repository.getDescription(), R.id.txtRepositoryDescription, view);
		
		return view;
	}
}
