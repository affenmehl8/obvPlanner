package com.example.obvplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    private ViewPager2 viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.viewpager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);



    }





    public void leftClick(View view) {
    }

    public void rightClick(View view) {

    }


    public void onClickAddQuest(View view) {
        startActivity(new Intent(MainActivity.this, AddQuestActivity.class));
    }

    public void onClickManageQuest(View view) {
        startActivity(new Intent(MainActivity.this, ManageQuestActivity.class));
    }
}


