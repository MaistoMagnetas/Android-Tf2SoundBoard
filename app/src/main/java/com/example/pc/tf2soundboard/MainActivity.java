package com.example.pc.tf2soundboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Menu for classes
    ImageView imageView;

    Button btnScout, btnSoldier, btnPyro, btnDemo, btnHeavy, btnEngi, btnMedic, btnSniper, btnSpy;
    int images[] = {R.drawable.scout,R.drawable.soldier,R.drawable.pyro,R.drawable.demo,R.drawable.heavy,
        R.drawable.engi,R.drawable.medic,R.drawable.sniper,R.drawable.spy};

    //Submit btn for next intent
    Button btnSubmit;
    int classPosition ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Choose class
        imageView = (ImageView) findViewById(R.id.imageView);
        btnScout = (Button) findViewById(R.id.btnScout);
        btnSoldier = (Button) findViewById(R.id.btnSoldier);
        btnPyro = (Button) findViewById(R.id.btnPyro);
        btnDemo = (Button) findViewById(R.id.btnDemo);
        btnHeavy = (Button) findViewById(R.id.btnHeavy);
        btnEngi = (Button) findViewById(R.id.btnEngi);
        btnMedic = (Button) findViewById(R.id.btnMedic);
        btnSniper = (Button) findViewById(R.id.btnSniper);
        btnSpy = (Button) findViewById(R.id.btnSpy);

        //Btn for next intent
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

//        //Listeners for changing background really not nice style.
//        btnScout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[0]);
//                tf2class = "scout";
//            }
//        });
//
//        btnSoldier.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[1]);
//                tf2class = "soldier";
//            }
//        });
//
//        btnPyro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[2]);
//                tf2class = "pyro";
//            }
//        });
//
//        btnDemo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[3]);
//                tf2class = "demo";
//            }
//        });
//
//        btnHeavy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[4]);
//                tf2class = "heavy";
//            }
//        });
//
//        btnEngi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[5]);
//                tf2class = "engi";
//            }
//        });
//
//        btnMedic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[6]);
//                tf2class = "medic";
//            }
//        });
//
//        btnSniper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[7]);
//                tf2class = "sniper";
//            }
//        });
//
//        btnSpy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource(images[8]);
//                tf2class = "spy";
//            }
//        });

        // btn submit on click listener

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SoundBoard.class);
                String tf2class =  getClassName(classPosition);
                intent.putExtra("chosenClass",tf2class);
                startActivity(intent);
            }
        });

        imageView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeRight(){
                if(classPosition != 8){
                    classPosition++;
                }
                imageView.setImageResource(drawClassImage(classPosition));
                //Toast.makeText(MainActivity.this, "Swipe right", Toast.LENGTH_SHORT).show();

            }

            public void onSwipeLeft(){
                if(classPosition != 0){
                    classPosition--;
                }
                imageView.setImageResource(drawClassImage(classPosition));
                //Toast.makeText(MainActivity.this, "Swipe left", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private int drawClassImage(int position){
        switch (position){
            case 0:
                return R.drawable.scout;
            case 1:
                return R.drawable.soldier;
            case 2:
                return R.drawable.pyro;
            case 3:
                return R.drawable.demo;
            case 4:
                return R.drawable.heavy;
            case 5:
                return R.drawable.engi;
            case 6:
                return R.drawable.medic;
            case 7:
                return R.drawable.sniper;
            case 8:
                return R.drawable.spy;
            default:
                return R.drawable.scout;
        }
    }

    private String getClassName(int position){
        String chosenClass = "";
        if(classPosition == 0){
            chosenClass = "Scout";
        }else if(classPosition == 1){
            chosenClass = "Soldier";
        }else if(classPosition == 2){
            chosenClass = "Pyro";
        }else if(classPosition == 3) {
            chosenClass = "Demo";
        }else if(classPosition == 4) {
            chosenClass = "Heavy";
        }else if(classPosition == 5) {
            chosenClass = "Engi";
        }else if(classPosition == 6) {
            chosenClass = "Medic";
        }else if(classPosition == 7) {
            chosenClass = "Sniper";
        }else if(classPosition == 8) {
            chosenClass = "Spy";
        }else{
            chosenClass = "Scout";
        }
        return chosenClass;
    }
}
