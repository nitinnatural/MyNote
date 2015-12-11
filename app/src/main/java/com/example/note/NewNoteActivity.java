package com.example.note;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;


/**
 * @author nitinnatural@gmail.com
 * */

public class NewNoteActivity extends AppCompatActivity {

	FragmentManager mFm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blank);
		ButterKnife.bind(this);

		mFm = getSupportFragmentManager();
		Fragment fragment = mFm.findFragmentById(R.id.container);

		if (fragment==null){
			fragment = new NewNoteFragment();
			mFm.beginTransaction()
					.add(R.id.container, fragment)
					.commit();
		}

	}

	@Override
	protected void onResume() {
		super.onResume();
		//opening transition animations
		overridePendingTransition(R.anim.open_translate, R.anim.close_translate);
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		//closing transition animations
		overridePendingTransition(R.anim.open_scale, R.anim.close_translate);
	}



}
