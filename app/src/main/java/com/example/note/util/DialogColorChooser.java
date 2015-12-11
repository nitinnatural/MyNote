package com.example.note.util;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.note.NewNoteFragment;
import com.example.note.R;
import com.example.note.constant.Color;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author nitinnatural@gmail.com
 */


public class DialogColorChooser extends DialogFragment implements View.OnClickListener {


 public DialogColorChooser(){
//      empty constructor required
 }


    @Bind(R.id.color_choose_1)
    ImageButton color1;

    @Bind(R.id.color_choose_2)
    ImageButton color2;

    @Bind(R.id.color_choose_3)
    ImageButton color3;

    @Bind(R.id.color_choose_4)
    ImageButton color4;

    @Bind(R.id.color_choose_5)
    ImageButton color5;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_color_chooser, container, false);
        ButterKnife.bind(this, v);
        init();
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        return v;
    }



    void init(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            color1.setBackground(util.createOvalShape(Color.COLOR_1));
            color2.setBackground(util.createOvalShape(Color.COLOR_2));
            color3.setBackground(util.createOvalShape(Color.COLOR_3));
            color4.setBackground(util.createOvalShape(Color.COLOR_4));
            color5.setBackground(util.createOvalShape(Color.COLOR_5));
        }

        color1.setOnClickListener(this);
        color2.setOnClickListener(this);
        color3.setOnClickListener(this);
        color4.setOnClickListener(this);
        color5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.color_choose_1:
                sendResult(android.graphics.Color.parseColor(Color.COLOR_1));
                getDialog().dismiss();
                break;
            case R.id.color_choose_2:
                sendResult(android.graphics.Color.parseColor(Color.COLOR_2));
                getDialog().dismiss();
                break;
            case R.id.color_choose_3:
                sendResult(android.graphics.Color.parseColor(Color.COLOR_3));
                getDialog().dismiss();
                break;
            case R.id.color_choose_4:
                sendResult(android.graphics.Color.parseColor(Color.COLOR_4));
                getDialog().dismiss();
                break;
            case R.id.color_choose_5:
                sendResult(android.graphics.Color.parseColor(Color.COLOR_5));
                getDialog().dismiss();
                break;
        }
    }




    void sendResult(int colorCode){
        if (getTargetFragment()==null)
            return;
        Intent i = new Intent();
        i.putExtra(NewNoteFragment.INTENT_COLOR_EXTRA, colorCode);
        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
    }

}
