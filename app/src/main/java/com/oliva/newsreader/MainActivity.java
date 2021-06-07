package com.oliva.newsreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.oliva.newsreader.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.main, new MainFragment());
        ft.commit();
    }
}