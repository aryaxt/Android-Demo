package com.aryaxt.demo.pages.contributors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aryaxt.demo.R;
import com.aryaxt.demo.helper.AbstractAdapter;
import com.aryaxt.demo.service.models.User;
import com.google.inject.Inject;
import com.squareup.picasso.Picasso;

public class ContributorsAdapter extends AbstractAdapter<User> {

	@Inject
	public ContributorsAdapter(Context context) {
		super(context);
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		view = this.getReusableView(view, R.layout.contributor_row);
		
		User contributor = getItemAtPosition(position);
		
		setText(contributor.getLogin(), R.id.txtUsername, view);
		ImageView imageView = (ImageView) view.findViewById(R.id.imgAvatar);
		imageView.setImageResource(R.drawable.ic_launcher);
		Picasso.with(getContext()).load(contributor.getAvatar_url()).into(imageView);
		
		return view;
	}
}

