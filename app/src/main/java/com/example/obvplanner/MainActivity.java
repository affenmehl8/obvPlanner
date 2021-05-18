package com.example.obvplanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    public static final int ADDLOCATION_REQUEST = 1;
    public static final int ADDQUEST_REQUEST = 2;
    private static final String FILE_NAME = "save.dat";


    private ViewPager2 viewPager;
    private static int itemcnt;
    private static int itemmax;

    public static List<Quest> questList;

    private TextView tvTopText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.viewpager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setUserInputEnabled(false);
        itemmax = viewPagerAdapter.getItemCount();

        tvTopText = findViewById(R.id.topText);

        questList = new ArrayList<Quest>();

        //Load questList from File
        try {
            FileInputStream fis = new FileInputStream(new File(getFilesDir(),FILE_NAME));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Quest quest = null;

            while((quest = (Quest) ois.readObject()) != null)
                questList.add(quest);
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            Log.e("error", "onCreate: "+e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("error", "onCreate: "+e.toString());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.e("error", "onCreate: "+e.toString());
            e.printStackTrace();
        }
        //for testing
        Quest f1 = new Quest("finito","",0,0);
        Quest f2 = new Quest("mikele","",0,0);
        f1.active = false;
        f2.active = false;
        questList.add(f1);
        questList.add(f2);



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if(requestCode == ADDQUEST_REQUEST) {
                String title = data.getStringExtra("title");
                String description = data.getStringExtra("description");
                double longitude = data.getDoubleExtra("longitude", 0);
                double latitude = data.getDoubleExtra("latitude",0);

               //arbeiten mit den Daten: in Array packen und in file saven
                Quest quest = new Quest(title, description, longitude, latitude);
                questList.add(quest);
                try {

                    File f = new File(getFilesDir(), FILE_NAME);
                    if(f.exists()) { Log.e("error", "AppendingObjectOutputStream");
                        FileOutputStream fos  = new FileOutputStream(f, true);
                        AppendingObjectOutputStream oos = new AppendingObjectOutputStream(fos);
                        oos.writeObject(quest);
                        oos.close();
                        fos.close();
                    }
                    else { Log.e("error", "ObjectOutputStream");
                        FileOutputStream fos  = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(quest);
                        oos.close();
                        fos.close();
                    }
                } catch (FileNotFoundException e) {
                    Log.e("error","log: "+e.toString());
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("error", "log: "+e.toString());
                    e.printStackTrace();
                }
            }
        }

        }

    public void leftClick(View view) {
        if(itemcnt==0){
            itemcnt=(itemmax-1);
            viewPager.setCurrentItem(itemcnt,true);
        }
        else {
            itemcnt--;
            viewPager.setCurrentItem(itemcnt,true);
        }
        setText(itemcnt,tvTopText);
    }

    public void rightClick(View view) {
        if(itemcnt==(itemmax-1)){
            itemcnt=0;
            viewPager.setCurrentItem(itemcnt,true);
        }
        else {
            itemcnt++;
            viewPager.setCurrentItem(itemcnt,true);
        }
        setText(itemcnt,tvTopText);
    }

    public static void setText(int cnt, TextView textView) {

        switch (itemcnt) {
            case 0: textView.setText("Quests"); break;
            case 1: textView.setText("Manage"); break;
            case 2:textView.setText("Map"); break;
            default:textView.setText("Quests"); break;
        }
    }

    public void onClickAddQuest(View view) {
        Intent intent = new Intent(MainActivity.this, AddQuestActivity.class);
        startActivityForResult(intent, ADDQUEST_REQUEST);
    }

    public void onClickManageQuest(View view) {
        Log.e("itemcount","Questlist size:"+questList.size());
        //startActivity(new Intent(MainActivity.this, ManageQuestActivity.class));
    }
    
    public static ArrayList<Quest> getQuestListActive(){
        ArrayList<Quest> questArrayList = new ArrayList<>();
        for (Quest q:questList) {
            if(q.active == true)
                questArrayList.add(q);
        }
        return questArrayList;
    }

    public static ArrayList<Quest> getQuestListFinished(){
        ArrayList<Quest> questArrayList = new ArrayList<>();
        for (Quest q:questList) {
            if(q.active == false)
                questArrayList.add(q);
        }
        return questArrayList;
    }
}


