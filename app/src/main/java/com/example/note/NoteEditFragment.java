package com.example.note;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.note.constant.IntentKeys;
import com.example.note.data.MyOpenHelper;
import com.example.note.data.Note;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author nitinnatural@gmail.com
 */
public class NoteEditFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.ib_back)
    ImageButton btnBack;

    @Bind(R.id.proxy_toolbar)
    Toolbar proxyToolbar;

    @Bind(R.id.ll_root)
    LinearLayout llRoot;
    
    @Bind(R.id.ib_done)
    ImageButton btnDone;
    
    @Bind(R.id.ib_color) 
    ImageButton btnColor;

    EditText etTitle;
    EditText etContent;
    Note mNote;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_note, container, false);
        ButterKnife.bind(this, v);

        init();

        mNote = (Note) getActivity().getIntent().getSerializableExtra(IntentKeys.key_note);

        Log.d("noteDebug", "from fragment onCreateView"+ mNote.getTitle());

        etTitle = (EditText) v.findViewById(R.id.et_title);
        etContent = (EditText) v.findViewById(R.id.et_content);


        etTitle.setText(mNote.getTitle());
        etContent.setText(mNote.getContent());
        proxyToolbar.setBackgroundColor(mNote.getColor());
        llRoot.setBackgroundColor(mNote.getColor());

        return v;
    }

    void init(){
        setupView();
        btnColor.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnDone.setOnClickListener(this);
    }


    void updateNote(){
        MyOpenHelper helper = new MyOpenHelper(getActivity());
        mNote.setTitle(etTitle.getText().toString());
        mNote.setContent(etContent.getText().toString());
//        mNote.setColor();
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
            case R.id.ib_color:
                // TODO: 22/11/15 open the color chooser dialog
                break;
        }
    }

    void setupView(){
        btnDone.setVisibility(View.VISIBLE);
        btnColor.setVisibility(View.VISIBLE);
    }
}
