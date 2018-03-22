package com.example.pc.tf2soundboard;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class SoundBoard extends AppCompatActivity {

    RelativeLayout relativeLayout;

    GridView gridView;
    ArrayList soundList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        //Get intent extra
        Intent intent = getIntent();
        String tf2class = intent.getExtras().getString("chosenClass");

        //Init grid view and items
        gridView = (GridView) findViewById(R.id.gridView);
        for(int i = 0; i<=5;i++){
            soundList.add(new Item(tf2class));
        }
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),R.layout.grid_view_items,soundList);
        gridView.setAdapter(customAdapter);

        //Find layout to change its background accordingly to class selected
        relativeLayout = (RelativeLayout) findViewById(R.id.soundBoardBG);

        //Information about which class was selected in MainActivity



        gridView = (GridView) findViewById(R.id.gridView);
        for(int i = 0; i<=5;i++){
            soundList.add(new Item(tf2class));
        }



    }
}
