package com.example.note;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.note.constant.IntentKeys;
import com.example.note.data.MyOpenHelper;
import com.example.note.data.Note;
import com.example.note.util.util;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author nitinnatural@gmail.com
 */
public class NoteDetailFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.proxy_toolbar)
    Toolbar proxyToolbar;

    @Bind(R.id.ll_root)
    LinearLayout llRoot;

    @Bind(R.id.ib_back)
    ImageButton btnBack;

    @Bind(R.id.ib_done)
    ImageButton btnDone;

    @Bind(R.id.ib_delete)
    ImageButton btnDelete;

    @Bind(R.id.ib_edit)
    ImageButton btnEdit;

    Note mNote;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_detail, container, false);
        ButterKnife.bind(this, v);
        init();

        mNote = (Note) getActivity().getIntent().getSerializableExtra(IntentKeys.key_note);

        Log.d("noteDebug", "from fragment onCreateView" + mNote.getTitle());

        TextView tvTitle = (TextView) v.findViewById(R.id.tv_title);
        TextView tvContent = (TextView) v.findViewById(R.id.tv_content);
        TextView tvDate = (TextView) v.findViewById(R.id.tv_date);


        tvTitle.setText(mNote.getTitle());
        tvContent.setText(mNote.getContent());
        tvDate.setText(util.readableDate(mNote.getCreatedAt()));
        proxyToolbar.setBackgroundColor(mNote.getColor());
        llRoot.setBackgroundColor(mNote.getColor());


        return v;
    }

    void init(){
        setupView();

        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_edit:
                getActivity().getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.fragment_fade_in, R.anim.fragment_fade_out)
                        .add(R.id.container, new NoteEditFragment(), "").addToBackStack(null).commit();
                break;

            case R.id.ib_delete:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle(R.string.dilaog_title);

                alertDialogBuilder
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MyOpenHelper openHelper = new MyOpenHelper(getActivity());
                                openHelper.deleteTodo(mNote.getId());
                                getActivity().finish();
                            }
                        })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

                alertDialogBuilder.create().show();
                break;
            case R.id.ib_back:
                getActivity().finish();
                break;
        }
    }


    void setupView(){
        btnDelete.setVisibility(View.VISIBLE);
        btnEdit.setVisibility(View.VISIBLE);

        btnDone.setVisibility(View.GONE);
    }
}
