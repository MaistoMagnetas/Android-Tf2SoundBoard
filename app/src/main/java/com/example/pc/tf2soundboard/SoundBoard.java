package com.example.pc.tf2soundboard;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.MediaStore;
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
    private MediaPlayer mediaPlayer = new MediaPlayer();

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
                if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.release();
                    mediaPlayer.reset();
                }
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
                mediaPlayer.stop();
                mediaPlayer.reset();

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
                addSoldierSounds();
                addSoldierTitle();
                break;
            case "Pyro":
                relativeLayout.setBackgroundResource(R.drawable.pyrobgattempt);
                imageViewClassTitle.setImageResource(R.drawable.pyrotitle);
                //ADD sounds and titles to list
               addPyroitle();
               addPyroSounds();
                break;
            case "Demo":
                relativeLayout.setBackgroundResource(R.drawable.demobgattempt);
                imageViewClassTitle.setImageResource(R.drawable.demotitle);
                //ADD sounds and titles to list
                addDemoSounds();
                addDemoTitle();
                break;
            case  "Heavy":
                relativeLayout.setBackgroundResource(R.drawable.heavybgattempt);
                imageViewClassTitle.setImageResource(R.drawable.heavytitle);
                //ADD sounds and titles to list
                addHeavySounds();
                addHeavyTitle();
                break;
            case "Engi":
                relativeLayout.setBackgroundResource(R.drawable.engibgattempt);
                imageViewClassTitle.setImageResource(R.drawable.engititle);
                //ADD sounds and titles to list
                addEngiSounds();
                addEngiTitle();
                break;
            case "Medic":
                relativeLayout.setBackgroundResource(R.drawable.medicbgattempt);
                imageViewClassTitle.setImageResource(R.drawable.medictitle);
                //ADD sounds and titles to list
                addMedicSounds();
                addMedicTitle();
                break;
            case "Sniper":
                relativeLayout.setBackgroundResource(R.drawable.sniperbgattempt);
                imageViewClassTitle.setImageResource(R.drawable.snipertitle);
                //ADD sounds and titles to list
                addSniperSounds();
                addSniperTitle();
                break;
            case "Spy":
                relativeLayout.setBackgroundResource(R.drawable.spybgattempt);
                imageViewClassTitle.setImageResource(R.drawable.spytitle);
                //ADD sounds and titles to list
                addSpySounds();
                addSpyTitle();
                break;
        }
    }

    //Scout -- 35 sounds
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

    //Soldier - 36 sounds
    private void addSoldierSounds() {
        soundList.add(R.raw.soldier_bonvyagecroyton);
        soundList.add(R.raw.soldier_comecupcake);
        soundList.add(R.raw.soldier_comeheresweethearth);
        soundList.add(R.raw.soldier_criticaldeth);
        soundList.add(R.raw.soldier_dammitboys);
        soundList.add(R.raw.soldier_deployadispenserhere);
        soundList.add(R.raw.soldier_dominatedgreesemonkey);
        soundList.add(R.raw.soldier_eachandeveryoneofyou);
        soundList.add(R.raw.soldier_everyoneofyoudeserves);
        soundList.add(R.raw.soldier_evillaugh);
        soundList.add(R.raw.soldier_firefirefire);
        soundList.add(R.raw.soldier_getahaircuthippie);
        soundList.add(R.raw.soldier_happylauch);
        soundList.add(R.raw.soldier_iamonfire);
        soundList.add(R.raw.soldier_ifgotwantedyoutolive);
        soundList.add(R.raw.soldier_incoming);
        soundList.add(R.raw.soldier_kaboom);
        soundList.add(R.raw.soldier_lastonealivelockthedoors);
        soundList.add(R.raw.soldier_longlaugh);
        soundList.add(R.raw.soldier_maggots);
        soundList.add(R.raw.soldier_medic);
        soundList.add(R.raw.soldier_no);
        soundList.add(R.raw.soldier_nowthatsisiwannasee);
        soundList.add(R.raw.soldier_pain);
        soundList.add(R.raw.soldier_papow);
        soundList.add(R.raw.soldier_spy);
        soundList.add(R.raw.soldier_standonthepoint);
        soundList.add(R.raw.soldier_thankssoldier);
        soundList.add(R.raw.soldier_thatsniperisaspy);
        soundList.add(R.raw.soldier_thatwasanamazingkillingspree);
        soundList.add(R.raw.soldier_theburning);
        soundList.add(R.raw.soldier_thewormhasturned);
        soundList.add(R.raw.soldier_todayisagoodday);
        soundList.add(R.raw.soldier_yeah);
        soundList.add(R.raw.soldier_youareallweek);
        soundList.add(R.raw.soldier_youjustgotdominated);
    }
    private void addSoldierTitle(){
        titlesList.add(new Item("Bon voyage, crouton!"));
        titlesList.add(new Item("Come here, cupcake"));
        titlesList.add(new Item("Come here, sweethearth!"));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Dammit boys"));
        titlesList.add(new Item("Deploy a dispenser here!"));
        titlesList.add(new Item("Domminated greese monkey"));
        titlesList.add(new Item("Each and every one of you"));
        titlesList.add(new Item("Everyone deserves a medal"));
        titlesList.add(new Item("Evil laugh"));
        titlesList.add(new Item("Fire fire fire!"));
        titlesList.add(new Item("Get a haircut hippie"));
        titlesList.add(new Item("Ha-ha-ha"));
        titlesList.add(new Item("I am on fire!"));
        titlesList.add(new Item("If go wanted you to live.."));
        titlesList.add(new Item("Incoming"));
        titlesList.add(new Item("Kaboom!"));
        titlesList.add(new Item("Last one alive locl the door"));
        titlesList.add(new Item("Long laugh"));
        titlesList.add(new Item("Maggots"));
        titlesList.add(new Item("Medic"));
        titlesList.add(new Item("No"));
        titlesList.add(new Item("Now that is what I wanna see"));
        titlesList.add(new Item("Pain"));
        titlesList.add(new Item("Papow"));
        titlesList.add(new Item("Spy"));
        titlesList.add(new Item("Stand on the point maggots"));
        titlesList.add(new Item("Thanks soldier"));
        titlesList.add(new Item("That sniper is a spy"));
        titlesList.add(new Item("That was an amazing killing spree.."));
        titlesList.add(new Item("The burning"));
        titlesList.add(new Item("The worm has turned"));
        titlesList.add(new Item("Today is a good day"));
        titlesList.add(new Item("Yeah"));
        titlesList.add(new Item("You are all weak"));
        titlesList.add(new Item("You just got dominated"));
    }

    //Pyro -- 35
    private void addPyroSounds() {
        soundList.add(R.raw.pyro_activatecharge);
        soundList.add(R.raw.pyro_ahahah);
        soundList.add(R.raw.pyro_boo);
        soundList.add(R.raw.pyro_ciriticaldeath);
        soundList.add(R.raw.pyro_comestandonthepointyoumaggot);
        soundList.add(R.raw.pyro_evillaugh);
        soundList.add(R.raw.pyro_excellent);
        soundList.add(R.raw.pyro_firefire);
        soundList.add(R.raw.pyro_gogogo);
        soundList.add(R.raw.pyro_goodjob);
        soundList.add(R.raw.pyro_hahayeah);
        soundList.add(R.raw.pyro_happylauch);//sane as longlauch
        soundList.add(R.raw.pyro_heklpmecapture);
        soundList.add(R.raw.pyro_helpme);
        soundList.add(R.raw.pyro_hitme);
        soundList.add(R.raw.pyro_imonfirenow);
        soundList.add(R.raw.pyro_incoming);
        soundList.add(R.raw.pyro_letskillthemall);
        soundList.add(R.raw.pyro_longlauch);
        soundList.add(R.raw.pyro_medic);
        soundList.add(R.raw.pyro_moveup);
        soundList.add(R.raw.pyro_needadispenserhere);
        soundList.add(R.raw.pyro_needateleporterhere);
        soundList.add(R.raw.pyro_niceshot);
        soundList.add(R.raw.pyro_no);
        soundList.add(R.raw.pyro_sentryahead);
        soundList.add(R.raw.pyro_severepain);
        soundList.add(R.raw.pyro_thanksfortheheal);
        soundList.add(R.raw.pyro_thanksforthehelp);
        soundList.add(R.raw.pyro_thankyou);
        soundList.add(R.raw.pyro_thatisaspy);
        soundList.add(R.raw.pyro_theycangotohell);
        soundList.add(R.raw.pyro_uhhuh);
        soundList.add(R.raw.pyro_weareontheroll);
        soundList.add(R.raw.pyro_youfailed);
    }
    private void addPyroitle(){
        titlesList.add(new Item("Activate charge"));
        titlesList.add(new Item("Ahaha"));
        titlesList.add(new Item("Boo"));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Come here you maggot"));
        titlesList.add(new Item("Evil laugh"));
        titlesList.add(new Item("Excellent"));
        titlesList.add(new Item("Fire fire"));
        titlesList.add(new Item("Go go go"));
        titlesList.add(new Item("Good job"));
        titlesList.add(new Item("Ha ha yeah"));
        titlesList.add(new Item("Ha ha ha ha"));
        titlesList.add(new Item("Help me capture"));
        titlesList.add(new Item("Help me"));
        titlesList.add(new Item("Hit me"));
        titlesList.add(new Item("I am on fire"));
        titlesList.add(new Item("Lets kill them all"));
        titlesList.add(new Item("Long laugh")); // cahnge. this is same as hahaha
        titlesList.add(new Item("Medic"));
        titlesList.add(new Item("Move up"));
        titlesList.add(new Item("Need a dispenser here"));
        titlesList.add(new Item("Need a teleported here"));
        titlesList.add(new Item("Nice shot"));
        titlesList.add(new Item("No"));
        titlesList.add(new Item("Sentry ahed"));
        titlesList.add(new Item("Pain"));
        titlesList.add(new Item("Thanks for the heal"));
        titlesList.add(new Item("Thanks for the help"));
        titlesList.add(new Item("Thank you"));
        titlesList.add(new Item("That is a spy"));
        titlesList.add(new Item("They can go to hell"));
        titlesList.add(new Item("Uhuhuh"));
        titlesList.add(new Item("We are on the roll"));
        titlesList.add(new Item("You failed"));

    }
    //Demo -- 35
    private void addDemoSounds() {
        soundList.add(R.raw.demo_ahgno);
        soundList.add(R.raw.demo_bloodybriliant);
        soundList.add(R.raw.demo_bloodyspy);
        soundList.add(R.raw.demo_boo);
        soundList.add(R.raw.demo_ciriticaldeath);
        soundList.add(R.raw.demo_dominated);
        soundList.add(R.raw.demo_dontfretboyo);
        soundList.add(R.raw.demo_firefirefire);
        soundList.add(R.raw.demo_freedom);
        soundList.add(R.raw.demo_getthemboyos);
        soundList.add(R.raw.demo_giberish);
        soundList.add(R.raw.demo_gutsandglorylads);
        soundList.add(R.raw.demo_happylaugh);
        soundList.add(R.raw.demo_hititdoc);
        soundList.add(R.raw.demo_ididintneedyourhelp);
        soundList.add(R.raw.demo_ifiwasntaman);
        soundList.add(R.raw.demo_imburnin);
        soundList.add(R.raw.demo_imdrunk);
        soundList.add(R.raw.demo_inhell);
        soundList.add(R.raw.demo_kabluyey);
        soundList.add(R.raw.demo_kaboom);
        soundList.add(R.raw.demo_keepituplads);
        soundList.add(R.raw.demo_letsdoit);
        soundList.add(R.raw.demo_longlaugh);
        soundList.add(R.raw.demo_medic);
        soundList.add(R.raw.demo_nah);
        soundList.add(R.raw.demo_no);
        soundList.add(R.raw.demo_thanksmate);
        soundList.add(R.raw.demo_thatscoutisaspy);
        soundList.add(R.raw.demo_thatwillteachthem);
        soundList.add(R.raw.demo_theygonnaburryyouinsoupcan);
        soundList.add(R.raw.demo_timetogetblotered);
        soundList.add(R.raw.demo_ugh);
        soundList.add(R.raw.demo_whatjusthappened);
        soundList.add(R.raw.demo_youbleeding);
    }
    private void addDemoTitle(){
        titlesList.add(new Item("Ahh no"));
        titlesList.add(new Item("Bloody briliant"));
        titlesList.add(new Item("Bloody spy"));
        titlesList.add(new Item("Booo"));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Dominated"));
        titlesList.add(new Item("Dont fret boyo"));
        titlesList.add(new Item("Fire fire fire"));
        titlesList.add(new Item("Freedom"));
        titlesList.add(new Item("Get them boys"));
        titlesList.add(new Item("Giberish"));
        titlesList.add(new Item("Guts and glory lads"));
        titlesList.add(new Item("Happy laugh"));
        titlesList.add(new Item("Hit it Doc"));
        titlesList.add(new Item("I didint need your help"));
        titlesList.add(new Item("If I wasnt a man"));
        titlesList.add(new Item("I am burning"));
        titlesList.add(new Item("I am drunk"));
        titlesList.add(new Item("In hell"));
        titlesList.add(new Item("Kablueye"));
        titlesList.add(new Item("Kaboom"));
        titlesList.add(new Item("Keep it up lads"));
        titlesList.add(new Item("Leds do it"));
        titlesList.add(new Item("Long laugh"));
        titlesList.add(new Item("Medic"));
        titlesList.add(new Item("Nah"));
        titlesList.add(new Item("No"));
        titlesList.add(new Item("Thanks mate"));
        titlesList.add(new Item("That scout is a spy"));
        titlesList.add(new Item("That will teach them"));
        titlesList.add(new Item("They gonna burry whats left"));
        titlesList.add(new Item("Time to get blotered"));
        titlesList.add(new Item("Ugh"));
        titlesList.add(new Item("What just happened"));
        titlesList.add(new Item("You bleeding"));

    }
    //Heavy--35
    private void addHeavySounds() {
        soundList.add(R.raw.heavy_allofyouareababies);
        soundList.add(R.raw.heavy_allofyouaredead);
        soundList.add(R.raw.heavy_bolognahahaha);
        soundList.add(R.raw.heavy_chargenowdoctor);
        soundList.add(R.raw.heavy_criticaldeath);
        soundList.add(R.raw.heavy_crysomemore);
        soundList.add(R.raw.heavy_da);
        soundList.add(R.raw.heavy_entireteamisbabies);
        soundList.add(R.raw.heavy_getonpointstupid);
        soundList.add(R.raw.heavy_helpnow);
        soundList.add(R.raw.heavy_howcouldthishappen);
        soundList.add(R.raw.heavy_iambulletproof);
        soundList.add(R.raw.heavy_iamveryhappy);
        soundList.add(R.raw.heavy_ilovethisdoctor);
        soundList.add(R.raw.heavy_incoming);
        soundList.add(R.raw.heavy_iseespy);
        soundList.add(R.raw.heavy_isgood);
        soundList.add(R.raw.heavy_itsnotpossible);
        soundList.add(R.raw.heavy_kissme);
        soundList.add(R.raw.heavy_koroso);
        soundList.add(R.raw.heavy_manythanks);
        soundList.add(R.raw.heavy_medic);
        soundList.add(R.raw.heavy_nomnomnom);
        soundList.add(R.raw.heavy_notgood);
        soundList.add(R.raw.heavy_ohno);
        soundList.add(R.raw.heavy_ohthisisba);
        soundList.add(R.raw.heavy_putdispenserhere);
        soundList.add(R.raw.heavy_sharppain);
        soundList.add(R.raw.heavy_stupidstupidstupid);
        soundList.add(R.raw.heavy_thatwasdelicious);
        soundList.add(R.raw.heavy_yes);
        soundList.add(R.raw.heavy_youaredead);
        soundList.add(R.raw.heavy_youdidwell);
        soundList.add(R.raw.heavy_yourdoctorisdead);
        soundList.add(R.raw.heavy_youstupidhelpme);
    }
    private void addHeavyTitle(){
        titlesList.add(new Item("All of you are babies"));
        titlesList.add(new Item("All of you are dead"));
        titlesList.add(new Item("Bolognahaha"));
        titlesList.add(new Item("Charge now Doctor"));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Cry some more"));
        titlesList.add(new Item("Da"));
        titlesList.add(new Item("Entire team is babies"));
        titlesList.add(new Item("Get on the point stupid"));
        titlesList.add(new Item("Help me now"));
        titlesList.add(new Item("How could this happen"));
        titlesList.add(new Item("I am bullet proof"));
        titlesList.add(new Item("I am very happy"));
        titlesList.add(new Item("I love this doctor"));
        titlesList.add(new Item("Incoming"));
        titlesList.add(new Item("I see spy"));
        titlesList.add(new Item("Is good"));
        titlesList.add(new Item("It is not possible"));
        titlesList.add(new Item("Kiss me"));
        titlesList.add(new Item("Xoroso"));
        titlesList.add(new Item("Many thanks"));
        titlesList.add(new Item("Medic"));
        titlesList.add(new Item("Nom nom nom"));
        titlesList.add(new Item("Not good"));
        titlesList.add(new Item("Oh no"));
        titlesList.add(new Item("Oh this is bad"));
        titlesList.add(new Item("Put dispenser here"));
        titlesList.add(new Item("Sharp pain"));
        titlesList.add(new Item("Stupid stupid stupid"));
        titlesList.add(new Item("That was delicious"));
        titlesList.add(new Item("Yes"));
        titlesList.add(new Item("You are dead"));
        titlesList.add(new Item("You did well"));
        titlesList.add(new Item("Your doctor is dead"));
        titlesList.add(new Item("You stupid help me"));
    }
    //Engi--35
    private void addEngiSounds() {
        soundList.add(R.raw.engi_ahhell);
        soundList.add(R.raw.engi_alrightythen);
        soundList.add(R.raw.engi_bap);
        soundList.add(R.raw.engi_boo);
        soundList.add(R.raw.engi_buildingasentry);
        soundList.add(R.raw.engi_ciritcaldeath);
        soundList.add(R.raw.engi_dammitfellas);
        soundList.add(R.raw.engi_damndagnabit);
        soundList.add(R.raw.engi_darn);
        soundList.add(R.raw.engi_erectingadispenser);
        soundList.add(R.raw.engi_firefire);
        soundList.add(R.raw.engi_gotchafatboy);
        soundList.add(R.raw.engi_gottamovethatgearup);
        soundList.add(R.raw.engi_heckno);
        soundList.add(R.raw.engi_heckyes);
        soundList.add(R.raw.engi_heeheehewyaw);
        soundList.add(R.raw.engi_hellthatwaseasy);
        soundList.add(R.raw.engi_heyboysitsaspy);
        soundList.add(R.raw.engi_ibuildthat);
        soundList.add(R.raw.engi_itoldyoudonttouchthat);
        soundList.add(R.raw.engi_jipika);
        soundList.add(R.raw.engi_medic);
        soundList.add(R.raw.engi_nope);
        soundList.add(R.raw.engi_nowihaveseenevrything);
        soundList.add(R.raw.engi_pain);
        soundList.add(R.raw.engi_pow);
        soundList.add(R.raw.engi_sentrydown);
        soundList.add(R.raw.engi_sorrymam);
        soundList.add(R.raw.engi_spysappingmytele);
        soundList.add(R.raw.engi_spysappinmysentry);
        soundList.add(R.raw.engi_thatjustaintright);
        soundList.add(R.raw.engi_thatswhatyouget);
        soundList.add(R.raw.engi_weneedasentryrighthere);
        soundList.add(R.raw.engi_willyoulookatthat);
        soundList.add(R.raw.engi_wooheemakingbacon);
    }
    private void addEngiTitle(){
        titlesList.add(new Item("Ah hell"));
        titlesList.add(new Item("Alirithy then"));
        titlesList.add(new Item("Bap"));
        titlesList.add(new Item("Boo"));
        titlesList.add(new Item("Building sentry"));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Dammit fellas"));
        titlesList.add(new Item("Damndagnabit"));
        titlesList.add(new Item("Darn"));
        titlesList.add(new Item("Erecting a dispenser"));
        titlesList.add(new Item("Fire fire"));
        titlesList.add(new Item("Gotcha fat boy"));
        titlesList.add(new Item("Gotta move that gear up"));
        titlesList.add(new Item("Heck no"));
        titlesList.add(new Item("Heck yes"));
        titlesList.add(new Item("Heeheeheha"));
        titlesList.add(new Item("Hell that was easy"));
        titlesList.add(new Item("Hey boy it is a spy"));
        titlesList.add(new Item("I build that"));
        titlesList.add(new Item("I told you dont touch that"));
        titlesList.add(new Item("Jipika"));
        titlesList.add(new Item("Medic"));
        titlesList.add(new Item("Nope"));
        titlesList.add(new Item("Now I have seen everything"));
        titlesList.add(new Item("Pain"));
        titlesList.add(new Item("Pow"));
        titlesList.add(new Item("Sentry down"));
        titlesList.add(new Item("Sorry man"));
        titlesList.add(new Item("Spy sapping my tele"));
        titlesList.add(new Item("Spy sapping my sentry"));
        titlesList.add(new Item("Thats what you get"));
        titlesList.add(new Item("We need a dispenser right here"));
        titlesList.add(new Item("Will you look at that"));
        titlesList.add(new Item("Woohee making bacon"));

    }
    //Medic--35
    private void addMedicSounds() {
        soundList.add(R.raw.medic_actungspy);
        soundList.add(R.raw.medic_aufwiedersen);
        soundList.add(R.raw.medic_boo);
        soundList.add(R.raw.medic_chargemeherdoctor);
        soundList.add(R.raw.medic_criticaldeath);
        soundList.add(R.raw.medic_dankedunkofs);
        soundList.add(R.raw.medic_dankeherrdoctor);
        soundList.add(R.raw.medic_dumkofs);
        soundList.add(R.raw.medic_everyoneiamonfire);
        soundList.add(R.raw.medic_everyoneletmedown);
        soundList.add(R.raw.medic_fromnowonloosingisverboten);
        soundList.add(R.raw.medic_happylaugh);
        soundList.add(R.raw.medic_hellofreulens);
        soundList.add(R.raw.medic_iammelting);
        soundList.add(R.raw.medic_iamonfire);
        soundList.add(R.raw.medic_irequireassistance);
        soundList.add(R.raw.medic_ja);
        soundList.add(R.raw.medic_medic);
        soundList.add(R.raw.medic_moveshnell);
        soundList.add(R.raw.medic_nein);
        soundList.add(R.raw.medic_niceshotcommarade);
        soundList.add(R.raw.medic_ocktoberfest);
        soundList.add(R.raw.medic_papersplease);
        soundList.add(R.raw.medic_prepareforyourexamination);
        soundList.add(R.raw.medic_team);
        soundList.add(R.raw.medic_thanksengi);
        soundList.add(R.raw.medic_thankyouengineer);
        soundList.add(R.raw.medic_theengiisaspy);
        soundList.add(R.raw.medic_thensiperisaspy);
        soundList.add(R.raw.medic_thisisunaccpetable);
        soundList.add(R.raw.medic_wasistlost);
        soundList.add(R.raw.medic_welcometowelooseagianfest);
        soundList.add(R.raw.medic_wunderbach);
        soundList.add(R.raw.medic_youarestupid);
        soundList.add(R.raw.medic_youhavesecondtolive);
    }
    private void addMedicTitle(){
        titlesList.add(new Item("Achtung spy"));
        titlesList.add(new Item("Auf Wiedersehen"));
        titlesList.add(new Item("Boo"));
        titlesList.add(new Item("Charge me Herr Dcotor"));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Danke dumkofs"));
        titlesList.add(new Item("Danke Herr Doctor"));
        titlesList.add(new Item("Dumkofs"));
        titlesList.add(new Item("Everyone I am on fire"));
        titlesList.add(new Item("Everyone still alive has let me down"));
        titlesList.add(new Item("From now on loosing is verboten"));
        titlesList.add(new Item("Happy laugh"));
        titlesList.add(new Item("Hello Freulens"));
        titlesList.add(new Item("I am melting"));
        titlesList.add(new Item("I am on fire"));
        titlesList.add(new Item("I require assistance"));
        titlesList.add(new Item("Ja"));
        titlesList.add(new Item("Medic"));
        titlesList.add(new Item("Move schnell"));
        titlesList.add(new Item("Nein"));
        titlesList.add(new Item("Nice shot comrade"));
        titlesList.add(new Item("Okoberfest"));
        titlesList.add(new Item("Papers please"));
        titlesList.add(new Item("Prepare for your examination"));
        titlesList.add(new Item("Team"));
        titlesList.add(new Item("Danke engineer"));
        titlesList.add(new Item("Thank you enginneer"));
        titlesList.add(new Item("The engineer is a spy"));
        titlesList.add(new Item("The sniper is a spy"));
        titlesList.add(new Item("This is unacceptable"));
        titlesList.add(new Item("Was ist los"));
        titlesList.add(new Item("Welcome to we loose once again"));
        titlesList.add(new Item("Wunderbach"));
        titlesList.add(new Item("You are stupid"));
        titlesList.add(new Item("You have a second to live"));
    }
    //Sniper--35
    private void addSniperSounds() {
        soundList.add(R.raw.sniper_ahpiss);
        soundList.add(R.raw.sniper_alittlebitchopchop);
        soundList.add(R.raw.sniper_alright);
        soundList.add(R.raw.sniper_backstabthat);
        soundList.add(R.raw.sniper_bloddybogan);
        soundList.add(R.raw.sniper_criticaldeath);
        soundList.add(R.raw.sniper_firefirefire);
        soundList.add(R.raw.sniper_gauls);
        soundList.add(R.raw.sniper_goodsavethequeen);
        soundList.add(R.raw.sniper_goodshotmate);
        soundList.add(R.raw.sniper_happylaugh);
        soundList.add(R.raw.sniper_helpmedefend);
        soundList.add(R.raw.sniper_hollydooley);
        soundList.add(R.raw.sniper_imsorrymate);
        soundList.add(R.raw.sniper_incoming);
        soundList.add(R.raw.sniper_jarate);
        soundList.add(R.raw.sniper_letsgomates);
        soundList.add(R.raw.sniper_longlaugh);
        soundList.add(R.raw.sniper_medic);
        soundList.add(R.raw.sniper_needadispenserhere);
        soundList.add(R.raw.sniper_no);
        soundList.add(R.raw.sniper_nowdoctornow);
        soundList.add(R.raw.sniper_okaymate);
        soundList.add(R.raw.sniper_pissoff);
        soundList.add(R.raw.sniper_pissoffbighead);
        soundList.add(R.raw.sniper_spy);
        soundList.add(R.raw.sniper_stupidbloddyspies);
        soundList.add(R.raw.sniper_thanksmate);
        soundList.add(R.raw.sniper_thansforstandongstillwanker);
        soundList.add(R.raw.sniper_theheavyisaspy);
        soundList.add(R.raw.sniper_thescoutisaspy);
        soundList.add(R.raw.sniper_thisgonnabepissofpiece);
        soundList.add(R.raw.sniper_tooslowmedicinewoman);
        soundList.add(R.raw.sniper_wavegoodbyetoyourhead);
        soundList.add(R.raw.sniper_yes);
    }
    private void addSniperTitle(){
        titlesList.add(new Item("Ahh piss"));
        titlesList.add(new Item("A little bit chop chop"));
        titlesList.add(new Item("Alright"));
        titlesList.add(new Item("Back stab that"));
        titlesList.add(new Item("Bloody bogan"));
        titlesList.add(new Item("Critical death"));
        titlesList.add(new Item("Fire fire fire"));
        titlesList.add(new Item("Gauls"));
        titlesList.add(new Item("Good save the queen"));
        titlesList.add(new Item("Good shot mate"));
        titlesList.add(new Item("Happy laugh"));
        titlesList.add(new Item("Help me defend"));
        titlesList.add(new Item("Holly dooley"));
        titlesList.add(new Item("I am sorry mate"));
        titlesList.add(new Item("Incoming"));
        titlesList.add(new Item("Jarate"));
        titlesList.add(new Item("Lets go mates"));
        titlesList.add(new Item("Long laugh"));
        titlesList.add(new Item("Medic"));
        titlesList.add(new Item("Need a dispenser here"));
        titlesList.add(new Item("No"));
        titlesList.add(new Item("Now doctor"));
        titlesList.add(new Item("Okay mate"));
        titlesList.add(new Item("Piss off"));
        titlesList.add(new Item("Piss off bighead"));
        titlesList.add(new Item("Spy"));
        titlesList.add(new Item("Stupid bloody spies"));
        titlesList.add(new Item("Thanks mate"));
        titlesList.add(new Item("Thanks for standing still"));
        titlesList.add(new Item("The heavy is a spy"));
        titlesList.add(new Item("The scout is a spy"));
        titlesList.add(new Item("This gonna be a piss of piece"));
        titlesList.add(new Item("Too slow medicine woman"));
        titlesList.add(new Item("Wave goodbye to your head"));
        titlesList.add(new Item("Yes"));
    }
    //Spy--35
    private void addSpySounds() {
        soundList.add(R.raw.spy_butoffcourse);
        soundList.add(R.raw.spy_didyouforgetaboutme);
        soundList.add(R.raw.spy_excellent);
        soundList.add(R.raw.spy_exxcelent);
        soundList.add(R.raw.spy_gentleman);
        soundList.add(R.raw.spy_iamwaiting);
        soundList.add(R.raw.spy_idobelieveimonfire);
        soundList.add(R.raw.spy_ihateyou);
        soundList.add(R.raw.spy_iamwaiting);
        soundList.add(R.raw.spy_irequireassistance);
        soundList.add(R.raw.spy_ithinknot);
        soundList.add(R.raw.spy_itseemsinnottheonlyspy);
        soundList.add(R.raw.spy_jarateno);
        soundList.add(R.raw.spy_justlayyourweapons);
        soundList.add(R.raw.spy_kaboomindeed);
        soundList.add(R.raw.spy_kaboomtoyousir);
        soundList.add(R.raw.spy_longlaugh);
        soundList.add(R.raw.spy_magnificent);
        soundList.add(R.raw.spy_manythanks);
        soundList.add(R.raw.spy_mnissionaccomplishe);
        soundList.add(R.raw.spy_myappreciationamigo);
        soundList.add(R.raw.spy_naturally);
        soundList.add(R.raw.spy_no);
        soundList.add(R.raw.spy_peekaboo);
        soundList.add(R.raw.spy_placeadispenserhere);
        soundList.add(R.raw.spy_screams);
        soundList.add(R.raw.spy_slapmyhand);
        soundList.add(R.raw.spy_spygentleman);
        soundList.add(R.raw.spy_suprise);
        soundList.add(R.raw.spy_wellplayed);
        soundList.add(R.raw.spy_wellthiswasadisapointment);
        soundList.add(R.raw.spy_whatadisasteer);
        soundList.add(R.raw.spy_ye);
        soundList.add(R.raw.spy_youaresuchabaddoctor);
        soundList.add(R.raw.spy_yousuck);
    }
    private void addSpyTitle(){
        titlesList.add(new Item("But of course"));
        titlesList.add(new Item("Did you forget about me"));
        titlesList.add(new Item("Excellent"));
        titlesList.add(new Item("Excellent2"));
        titlesList.add(new Item("Gentlemen"));
        titlesList.add(new Item("I am waiting"));
        titlesList.add(new Item("I do elieve I am on fire"));
        titlesList.add(new Item("I hate you"));
        titlesList.add(new Item("I am afraid not"));
        titlesList.add(new Item("I require assistance"));
        titlesList.add(new Item("I think not"));
        titlesList.add(new Item("It seems I am not the only spy"));
        titlesList.add(new Item("Jarate NO"));
        titlesList.add(new Item("Just lay your weapons"));
        titlesList.add(new Item("Kaboom indeed"));
        titlesList.add(new Item("Kaboom to you Sir"));
        titlesList.add(new Item("Long laugh"));
        titlesList.add(new Item("Magnificent"));
        titlesList.add(new Item("Many thanks"));
        titlesList.add(new Item("Mission accomplished"));
        titlesList.add(new Item("My appreciation amigo"));
        titlesList.add(new Item("Naturally"));
        titlesList.add(new Item("No"));
        titlesList.add(new Item("Peekaboo"));
        titlesList.add(new Item("Place a dispenser here"));
        titlesList.add(new Item("Screams"));
        titlesList.add(new Item("Slap my hand"));
        titlesList.add(new Item("Spy gentlemen"));
        titlesList.add(new Item("Suprise"));
        titlesList.add(new Item("Well played"));
        titlesList.add(new Item("Well this was a disappointment"));
        titlesList.add(new Item("What a disaster"));
        titlesList.add(new Item("Ye"));
        titlesList.add(new Item("You such a bad doctor"));
        titlesList.add(new Item("You suck"));
    }
}
