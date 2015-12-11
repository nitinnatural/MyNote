package com.example.note;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.note.data.MyOpenHelper;
import com.example.note.data.Note;
import com.example.note.util.DialogColorChooser;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author nitinnatural@gmail.com
 */
public class NewNoteFragment extends Fragment implements View.OnClickListener {

    public static final String INTENT_COLOR_EXTRA = "color_extra";
    private static final int COLOR_RQST_CODE = 9001;


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

    @Bind(R.id.et_title)
    EditText etTitle;

    @Bind(R.id.et_content)
    EditText etContent;

    int mColor = -3285959;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_note, container, false);
        ButterKnife.bind(this, v);

        init();

        return v;
    }

    void init(){
        setupView();
        btnColor.setOnClickListener(this);
        btnDone.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.ib_done:
                if (etTitle.getText().length()==0 || etContent.getText().length()==0){
                    Toast.makeText(getActivity(), "Note cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                MyOpenHelper helper = new MyOpenHelper(getActivity());
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();

                Note note = new Note(content, title, mColor);
                helper.addNewTodo(note);
                getActivity().finish();
                break;
            case R.id.ib_back:
                getActivity().finish();
                break;

            case R.id.ib_color:
                DialogColorChooser dialogColorChooser = new DialogColorChooser();
                dialogColorChooser.setTargetFragment(NewNoteFragment.this, 9001);
                dialogColorChooser.show(getActivity().getSupportFragmentManager(),"dialog_color_chooser");
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == COLOR_RQST_CODE){
            mColor = data.getIntExtra(INTENT_COLOR_EXTRA, -1);
            updateBackground(mColor);
        }
    }
}
