package com.example.note;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.note.data.Note;
import com.example.note.data.MyOpenHelper;
import com.example.note.util.DialogColorChooser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewNoteActivity extends AppCompatActivity implements View.OnClickListener, DialogColorChooser.DialogColorChooserListener {

	EditText etTitle;
	EditText etContent;

	@Bind(R.id.ll_root)
	LinearLayout llRoot;

	@Bind(R.id.proxy_toolbar)
	Toolbar mToolbar;

	@Bind(R.id.ib_done)
	ImageButton btnDone;

	@Bind(R.id.ib_color)
	ImageButton btnColor;

	@Bind(R.id.ib_back)
	ImageButton btnBack;

	int mColor = -3285959;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_todo);
		ButterKnife.bind(this);
		init();
	}

	void init(){
		setupView();
		btnColor.setOnClickListener(this);
		btnDone.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		etTitle = (EditText) findViewById(R.id.et_title);
		etContent = (EditText) findViewById(R.id.et_content);
	}
	
	public void onClick(View v){
		switch (v.getId()){
			case R.id.ib_done:
				if (etTitle.getText().length()==0 || etContent.getText().length()==0){
					Toast.makeText(this, "Note cannot be empty", Toast.LENGTH_SHORT).show();
					return;
				}
				MyOpenHelper helper = new MyOpenHelper(this);
				String title = etTitle.getText().toString();
				String content = etContent.getText().toString();

				Note note = new Note(content, title, mColor);
				helper.addNewTodo(note);
				finish();
				break;
			case R.id.ib_back:
				finish();
				break;

			case R.id.ib_color:
				DialogColorChooser dialogColorChooser = new DialogColorChooser();
				dialogColorChooser.show(getSupportFragmentManager(),"color_chooser");
				break;
		}

	}

	void setupView(){
		btnDone.setVisibility(View.VISIBLE);
		btnColor.setVisibility(View.VISIBLE);
	}

	void updateBackground(int color){
		llRoot.setBackgroundColor(color);
		mToolbar.setBackgroundColor(color);
	}

	@Override
	public void onFinishColorDialog(int color) {
		mColor = color;
		updateBackground(color);
		Toast.makeText(this, "color: "+ color, Toast.LENGTH_SHORT).show();
	}
}
