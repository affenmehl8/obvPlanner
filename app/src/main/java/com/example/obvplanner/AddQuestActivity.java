package com.example.obvplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import static com.example.obvplanner.MainActivity.ADDLOCATION_REQUEST;


public class AddQuestActivity extends AppCompatActivity {

    TextView longitude;
    TextView latitude;
    double dblLongitude = 0;
    double dblLatitude = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quest);

        longitude = (TextView) findViewById(R.id.longitude);
        latitude = (TextView) findViewById(R.id.latitude);

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDLOCATION_REQUEST) {
            if(resultCode == RESULT_OK) {


                dblLongitude = data.getDoubleExtra("longitude", 0);
                dblLatitude = data.getDoubleExtra("latitude", 0);

                longitude.setText(Double.toString(dblLongitude));
                latitude.setText(Double.toString(dblLatitude));

            }
        }
        }


    public void onClickAddQuest(View view) {
    }

    public void openPicker(View view) {
        Intent intent = new Intent(AddQuestActivity.this, AddQuestLocationActivity.class);
        AddQuestActivity.this.startActivityForResult(intent,ADDLOCATION_REQUEST);



    }

}