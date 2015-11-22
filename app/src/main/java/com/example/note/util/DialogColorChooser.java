package com.example.note.util;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.note.R;
import com.example.note.constant.Color;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by IAMONE on 11/18/2015.
 */
public class DialogColorChooser extends DialogFragment implements View.OnClickListener {

    public interface DialogColorChooserListener{
        public void onFinishColorDialog(int color);
    }

 public DialogColorChooser(){
     // empty constructure required
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


    void selectColor(int colorCode){
        DialogColorChooserListener activity = (DialogColorChooserListener) getActivity();
        activity.onFinishColorDialog(colorCode);
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
                selectColor(android.graphics.Color.parseColor(Color.COLOR_1));
                getDialog().dismiss();
                break;
            case R.id.color_choose_2:
                selectColor(android.graphics.Color.parseColor(Color.COLOR_2));
                getDialog().dismiss();
                break;
            case R.id.color_choose_3:
                selectColor(android.graphics.Color.parseColor(Color.COLOR_3));
                getDialog().dismiss();
                break;
            case R.id.color_choose_4:
                selectColor(android.graphics.Color.parseColor(Color.COLOR_4));
                getDialog().dismiss();
                break;
            case R.id.color_choose_5:
                selectColor(android.graphics.Color.parseColor(Color.COLOR_5));
                getDialog().dismiss();
                break;
        }
    }



}
