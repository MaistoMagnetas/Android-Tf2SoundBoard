package com.example.pc.tf2soundboard;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class SoundBoard extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ImageView imageViewClassTitle;
    private GridView gridView;
    private ArrayList<Item> titlesList;
    private ArrayList<Integer> soundList;
    private MediaPlayer mediaPlayer;

    private String tf2class;

//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mediaPlayer.release();
//    }
//
//    //Overide method for mediaPlayer release after stop
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mediaPlayer.release();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        //Initialize XML items
        initXMLitems();
        //Create arrays for sounds and title
        titlesList = new ArrayList<Item>();
        soundList = new ArrayList<Integer>();

        //Get intent extra and knows chosen class
        Intent intent = getIntent();
        tf2class = intent.getExtras().getString("chosenClass");

        //Adds items to list for testing aka Scrolling
        //makeGridItems();
        //Takes list and layouts - makes grid view
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),R.layout.grid_view_items,titlesList);
        gridView.setAdapter(customAdapter);

        //Play sound then clicked on item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(SoundBoard.this, position+"", Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(SoundBoard.this,soundList.get(position));
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release();
                    }
                });

            }
        });
        //Find layout to change its background accordingly to class selected
        changeBackgroundForClass();



    }



    private void initXMLitems(){
        gridView = (GridView) findViewById(R.id.gridView);
        imageViewClassTitle = (ImageView) findViewById(R.id.imageViewClassTitle);
        relativeLayout = (RelativeLayout) findViewById(R.id.soundBoardBG);

    }

    private void changeBackgroundForClass(){ // Works like a charm.  COuld be nicer though
        switch (tf2class){
            case "Scout":
                relativeLayout.setBackgroundResource(R.drawable.scoutbgattempt);
                imageViewClassTitle.setImageResource(R.drawable.scouttitle);
                //ADD sounds and titles to list
                addScoutSounds();
                addScoutTitle();
                break;
            case "Soldier":
                relativeLayout.setBackgroundResource(R.drawable.soldierbgattempt);
                imageViewClassTitle.setImageResource(R.drawable.soldiertitle);
                //ADD sounds and titles to list
                break;
            case "Pyro":
                relativeLayout.setBackgroundResource(R.drawable.pyrobgattempt);
                imageViewClassTitle.setImageResource(R.drawable.pyrotitle);
                //ADD sounds and titles to list
                soundList.add(R.raw.pyro_happylauch);
                soundList.add(R.raw.pyro_helpme);
                soundList.add(R.raw.pyro_medic);
                titlesList.add(new Item("Happy launch"));
                titlesList.add(new Item("Help me"));
                titlesList.add(new Item("Medic!"));
                break;
            case "Demo":
                relativeLayout.setBackgroundResource(R.drawable.demobgattempt);
                imageViewClassTitle.setImageResource(R.drawable.demotitle);
                //ADD sounds and titles to list

                break;
            case  "Heavy":
                relativeLayout.setBackgroundResource(R.drawable.heavybgattempt);
                imageViewClassTitle.setImageResource(R.drawable.heavytitle);
                //ADD sounds and titles to list

                break;
            case "Engi":
                relativeLayout.setBackgroundResource(R.drawable.engibgattempt);
                imageViewClassTitle.setImageResource(R.drawable.engititle);
                //ADD sounds and titles to list

                break;
            case "Medic":
                relativeLayout.setBackgroundResource(R.drawable.medicbgattempt);
                imageViewClassTitle.setImageResource(R.drawable.medictitle);
                //ADD sounds and titles to list

                break;
            case "Sniper":
                relativeLayout.setBackgroundResource(R.drawable.sniperbgattempt);
                imageViewClassTitle.setImageResource(R.drawable.snipertitle);
                //ADD sounds and titles to list

                break;
            case "Spy":
                relativeLayout.setBackgroundResource(R.drawable.spybgattempt);
                imageViewClassTitle.setImageResource(R.drawable.spytitle);
                //ADD sounds and titles to list

                break;
        }
    }

    private void addScoutSounds(){
        soundList.add(R.raw.scout_ahcrap);
        soundList.add(R.raw.scout_areyougonnacry);
        soundList.add(R.raw.scout_boink);
        soundList.add(R.raw.scout_boomimback);
        soundList.add(R.raw.scout_carcrash);
        soundList.add(R.raw.scout_criticaldeath);
        soundList.add(R.raw.scout_diagnosis);
        soundList.add(R.raw.scout_dingdong);
        soundList.add(R.raw.scout_doccmon);
        soundList.add(R.raw.scout_dumbass);
        soundList.add(R.raw.scout_firefirefire);
        soundList.add(R.raw.scout_heavyspy);
        soundList.add(R.raw.scout_iamowningyou);
        soundList.add(R.raw.scout_ibrokeyourstupidcrap);
        soundList.add(R.raw.scout_ididintmeantohityou);
        soundList.add(R.raw.scout_ilovemyball);
        soundList.add(R.raw.scout_imburning);
        soundList.add(R.raw.scout_imrunningcirclesaroundya);
        soundList.add(R.raw.scout_laughyeahyeah);
        soundList.add(R.raw.scout_needadispenserhere);
        soundList.add(R.raw.scout_ohyeah);
        soundList.add(R.raw.scout_repeatafterme);
        soundList.add(R.raw.scout_todayaintyourday);
        soundList.add(R.raw.scout_uhno);
        soundList.add(R.raw.scout_wanana);
        soundList.add(R.raw.scout_wearescrewed);
        soundList.add(R.raw.scout_what);
        soundList.add(R.raw.scout_whatsthematter);
        soundList.add(R.raw.scout_whostoppedpushing);
        soundList.add(R.raw.scout_woo);
        soundList.add(R.raw.scout_wthcrap);
        soundList.add(R.raw.scout_yeahyeahyeah);
        soundList.add(R.raw.scout_yougonnacry);
        soundList.add(R.raw.scout_youknucleheads);
        soundList.add(R.raw.scout_yousuck);
    }

    private void addScoutTitle(){
        titlesList.add(new Item("Ahh crap!"));
        titlesList.add(new Item("Are you gonna cry now?"));
        titlesList.add(new Item("Boink"));
        titlesList.add(new Item("Boom. I'm back"));
        titlesList.add(new Item("You're like a car crash in slowmotion."));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Diagnosis? You suck."));
        titlesList.add(new Item("Ding dong"));
        titlesList.add(new Item("Doc, cmon man"));
        titlesList.add(new Item("Dumbass"));
        titlesList.add(new Item("Fire fire fire"));
        titlesList.add(new Item("Heavy is a spy"));
        titlesList.add(new Item("I'm owning you"));
        titlesList.add(new Item("I broke your stupid crap morron"));
        titlesList.add(new Item("Oh I'm sorry"));
        titlesList.add(new Item("I love my ball"));
        titlesList.add(new Item("Oh I'm burning"));
        titlesList.add(new Item("I'm running circles aorund ya"));
        titlesList.add(new Item("Yeah yeah yeah"));
        titlesList.add(new Item("Need a dispenser here"));
        titlesList.add(new Item("Oh yeah"));
        titlesList.add(new Item("Repeat after me"));
        titlesList.add(new Item("Today aint your day"));
        titlesList.add(new Item("Uh, NO!"));
        titlesList.add(new Item("Wa-na-na-na"));
        titlesList.add(new Item("We are screwed"));
        titlesList.add(new Item("What?!"));
        titlesList.add(new Item("Whats the matter?"));
        titlesList.add(new Item("Who stopped pushing the cart?"));
        titlesList.add(new Item("Woooo!"));
        titlesList.add(new Item("What the hell was that crap?"));
        titlesList.add(new Item("Yeah Yeah Yeah"));
        titlesList.add(new Item("You gonna cry now?"));
        titlesList.add(new Item("You knuckleheads"));
        titlesList.add(new Item("You SUCK."));
    }
}
