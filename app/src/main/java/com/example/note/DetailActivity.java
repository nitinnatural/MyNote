package com.example.note;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.note.R;

public class DetailActivity extends AppCompatActivity {
    android.app.FragmentManager mFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        mFm = getFragmentManager();
        Fragment fragment = mFm.findFragmentById(R.id.container);

        if (fragment==null){
            fragment = new NoteDetailFragment();
            Log.d("noteDebug", "from detailActivity");
            mFm.beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }


}
