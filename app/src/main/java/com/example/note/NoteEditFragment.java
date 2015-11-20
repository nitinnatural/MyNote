package com.example.note;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.note.constant.IntentKeys;
import com.example.note.data.MyOpenHelper;
import com.example.note.data.Note;
import com.example.note.util.util;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by IAMONE on 11/14/2015.
 */
public class NoteEditFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.ib_back)
    ImageButton btnBack;

    @Bind(R.id.proxy_toolbar)
    Toolbar proxyToolbar;

    @Bind(R.id.ib_done)
    ImageButton btnDone;

    EditText etTitle;
    EditText etContent;
    Note mNote;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_add_todo, container, false);
        ButterKnife.bind(this, v);

        init();

        mNote = (Note) getActivity().getIntent().getSerializableExtra(IntentKeys.key_note);

        Log.d("noteDebug", "from fragment onCreateView"+ mNote.getTitle());

        etTitle = (EditText) v.findViewById(R.id.et_title);
        etContent = (EditText) v.findViewById(R.id.et_content);


        etTitle.setText(mNote.getTitle());
        etContent.setText(mNote.getContent());

        return v;
    }

    void init(){
        setupView();

        btnBack.setOnClickListener(this);
        btnDone.setOnClickListener(this);
    }


    void updateNote(){
        MyOpenHelper helper = new MyOpenHelper(getActivity());
        mNote.setTitle(etTitle.getText().toString());
        mNote.setContent(etContent.getText().toString());
        helper.updateTodo(mNote);
        getActivity().finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_done:
                updateNote();
                break;
            case  R.id.ib_back:
                getActivity().finish();
                break;
        }
    }

    void setupView(){
        btnDone.setVisibility(View.VISIBLE);
    }
}
