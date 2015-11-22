package com.example.note.util;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by IAMONE on 11/14/2015.
 */
public class util {

    public static String readableDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM HH:mm", Locale.US);
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public static GradientDrawable createOvalShape(String strokeColor){
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.OVAL);
//        gd.setColor(fillColor);
//        gd.setCornerRadius(roundRadius);
        gd.setStroke(10, Color.parseColor(strokeColor));
        return gd;
    }
}
