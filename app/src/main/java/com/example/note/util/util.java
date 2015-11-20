package com.example.note.util;

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
}
