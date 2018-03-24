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

    String tf2class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        //Get intent extra
        Intent intent = getIntent();
        tf2class = intent.getExtras().getString("chosenClass");
        //Init grid view and items
        //3x for testing aka Scrolling
        makeGridItems();
        makeGridItems();
        makeGridItems();

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),R.layout.grid_view_items,soundList);
        gridView.setAdapter(customAdapter);

        //Find layout to change its background accordingly to class selected
        relativeLayout = (RelativeLayout) findViewById(R.id.soundBoardBG);
        changeBackgroundForClass();


        //Information about which class was selected in MainActivity


    }

    private void makeGridItems(){//Simple funciton CHange later?
        gridView = (GridView) findViewById(R.id.gridView);
        for(int i = 0; i<=5;i++){//TO-DO ilgi pakeisti i tiek kiek yra garsu
            soundList.add(new Item(tf2class));
        }
    }

    private void changeBackgroundForClass(){ // Works like a charm.  COuld be nicer though
        switch (tf2class){
            case "Scout":
                relativeLayout.setBackgroundResource(R.drawable.scoutbgattempt);
                break;
            case "Soldier":
                relativeLayout.setBackgroundResource(R.drawable.soldierbgattempt);
                break;
            case "Pyro":
                relativeLayout.setBackgroundResource(R.drawable.pyrobgattempt);
                break;
            case "Demo":
                relativeLayout.setBackgroundResource(R.drawable.demobgattempt);
                break;
            case  "Heavy":
                relativeLayout.setBackgroundResource(R.drawable.heavybgattempt);
                break;
            case "Engi":
                relativeLayout.setBackgroundResource(R.drawable.engibgattempt);
                break;
            case "Medic":
                relativeLayout.setBackgroundResource(R.drawable.medicbgattempt);
                break;
            case "Sniper":
                relativeLayout.setBackgroundResource(R.drawable.sniperbgattempt);
                break;
            case "Spy":
                relativeLayout.setBackgroundResource(R.drawable.spybgattempt);
                break;
        }

    }
}
