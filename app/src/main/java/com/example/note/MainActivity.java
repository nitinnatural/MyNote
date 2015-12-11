package com.example.note;

import java.util.ArrayList;
import java.util.List;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.note.constant.IntentKeys;
import com.example.note.data.Note;
import com.example.note.data.MyOpenHelper;
import com.example.note.util.util;

/**
 * @author nitinnatural@gmail.com
 * */

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


		mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
			int mLastFirstVisibleItem = 0;

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if (view.getId() == mListView.getId()) {
					final int currentFirstVisibleItem = mListView.getFirstVisiblePosition();

					if (currentFirstVisibleItem > mLastFirstVisibleItem) {
//						 getSherlockActivity().getSupportActionBar().hide();
//						getSupportActionBar().hide();

						//mToolbar.setVisibility(View.GONE);
						btnAdd.animate().translationX(btnAdd.getWidth()+50).setInterpolator(new AccelerateInterpolator(2)).start();
//						btnAdd.animate().translationY(400f).setInterpolator(new AccelerateInterpolator(2)).start();
					} else if (currentFirstVisibleItem < mLastFirstVisibleItem) {
//						getSupportActionBar().show();
						//mToolbar.setVisibility(View.VISIBLE);
						btnAdd.animate().translationX(0).setInterpolator(new AccelerateInterpolator(2)).start();
//						btnAdd.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
					}

					mLastFirstVisibleItem = currentFirstVisibleItem;
				}
			}
		});



		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				FrameLayout layout = (FrameLayout) view.findViewById(R.id.ll_root);


				Note n = (Note) parent.getItemAtPosition(position);
				Intent i = new Intent(MainActivity.this, DetailActivity.class);

				Pair<View, String> p1 = Pair.create((View) layout, "note");
				ActivityOptionsCompat options = ActivityOptionsCompat.
						makeSceneTransitionAnimation(MainActivity.this, p1);

				i.putExtra(IntentKeys.key_note, n);
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
					startActivity(i, options.toBundle());
				} else {
					startActivity(i);
				}
			}
		});

	}



	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.close_translate, R.anim.open_translate);
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
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					btnAdd.setElevation(10);
				}
				startActivity(new Intent(this, NewNoteActivity.class));
				break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		//opening transition animations
		overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

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
				convertView = getLayoutInflater().inflate(R.layout.list_item_row, parent, false);
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

