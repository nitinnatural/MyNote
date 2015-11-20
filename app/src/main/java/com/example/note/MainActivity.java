package com.example.note;

import java.util.ArrayList;
import java.util.List;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.note.constant.IntentKeys;
import com.example.note.data.Note;
import com.example.note.data.MyOpenHelper;
import com.example.note.util.util;
import com.parse.ParseException;
import com.parse.SaveCallback;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickListener{


	private ImageButton btnAdd;
	private Toolbar mToolbar;
	private  ListView mListView;
	CustomAdapter mAdapter;
	public  MyOpenHelper mOpenHelper;
	List<Note> mNoteList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();

		setSupportActionBar(mToolbar);

		updateAdapter();

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//				TransitionManager.beginDelayedTransition((ViewGroup)view);
//				int finalRadius = Math.max(view.getWidth(), view.getHeight()) / 2;
//				Animator anim = ViewAnimationUtils.createCircularReveal(
//						view, (int) view.getWidth()/2, (int)view.getHeight()/2, 0, finalRadius);
//
//				anim.start();

				Note n = (Note) parent.getItemAtPosition(position);
				Intent i = new Intent(MainActivity.this, DetailActivity.class);
				i.putExtra(IntentKeys.key_note, n);
				startActivity(i);
			}
		});

	}

	void updateAdapter(){
		mOpenHelper = new MyOpenHelper(this);
		mNoteList = mOpenHelper.readAllTodo();
		mAdapter = new CustomAdapter(this, mNoteList);
		mListView.setAdapter(mAdapter);
	}

	void init(){
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mListView = (ListView) findViewById(R.id.listView);
		btnAdd = (ImageButton) findViewById(R.id.btn_add_new_note);
		btnAdd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btn_add_new_note:
				startActivity(new Intent(this, NewNoteActivity.class));
				break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		updateAdapter();
		if (mAdapter!=null)
			mAdapter.notifyDataSetChanged();
	}


	class CustomAdapter extends BaseAdapter {
		Context context;
		List notelist = new ArrayList();

		public CustomAdapter(Context ctx, List<Note> objects) {
			this.notelist = objects;
			this.context = ctx;
		}


		@Override
		public int getCount() {
			return notelist.size();
		}

		@Override
		public Object getItem(int position) {
			return notelist.get(position);
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder h;

			if (convertView == null){
				convertView = getLayoutInflater().inflate(R.layout.row, parent, false);
				h = new ViewHolder(convertView);
				convertView.setTag(h);
			} else {
				h = (ViewHolder) convertView.getTag();
			}

			Note n = (Note) getItem(position);

			h.tvTitle.setText(n.getTitle());
			h.tvContent.setText(n.getContent());
			h.tvCreatedAt.setText(util.readableDate(n.getCreatedAt()));
			h.llRoot.setBackgroundColor(n.getColor());


			return convertView;
		}

	}

	static class ViewHolder{
		public TextView tvTitle;
		public TextView tvContent;
		public TextView tvCreatedAt;
		public FrameLayout llRoot;

		public ViewHolder(View view){
			this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
			this.tvContent = (TextView) view.findViewById(R.id.tv_content);
			this.tvCreatedAt = (TextView) view.findViewById(R.id.tv_created_at);
			this.llRoot = (FrameLayout) view.findViewById(R.id.ll_root);
		}
	}



}

