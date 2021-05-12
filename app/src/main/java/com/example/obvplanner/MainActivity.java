package com.example.obvplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    FragmentManager fm = getFragmentManager();
    QuestsFragment questsFragment = new QuestsFragment();
    ManageFragment manageFragment = new ManageFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fm.beginTransaction()

    }





    public void leftClick(View view) {
    }

    public void rightClick(View view) {

    }
}