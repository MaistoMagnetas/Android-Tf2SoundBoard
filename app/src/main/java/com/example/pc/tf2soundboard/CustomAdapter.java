package com.example.pc.tf2soundboard;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by PC on 3/21/2018.
 */

public class CustomAdapter extends ArrayAdapter{

    ArrayList<Item> soundsList = new ArrayList<Item>();
    int[] colorList = {R.color.gridItem3,R.color.gridItem4,R.color.gridItem5,
            R.color.gridItem6,R.color.gridItem7};
    RelativeLayout relativeLayout;

    int gradientMapInteger = 0;
    int colorPosition = 0;

    public CustomAdapter(Context context, int resource, ArrayList soundsList) {
        super(context, resource, soundsList);
        this.soundsList = soundsList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_view_items, null);
        TextView textView = (TextView) v.findViewById(R.id.itemTextView);
        textView.setText(soundsList.get(position).getTitle());

        //Randomlly colors grid view items
//        relativeLayout = (RelativeLayout) v.findViewById(R.id.relativegriditem);
//        Random rand = new Random();
//        relativeLayout.setBackgroundResource(colorList[rand.nextInt(colorList.length)]);

        //Sets gridview item colors gradient map method
        relativeLayout = (RelativeLayout) v.findViewById(R.id.relativegriditem);


        return v;

    }

    //Not in Use..
    private void grandientMapBGonItems(){ // sets bg for grid view items - like gradient map
        gradientMapInteger++; //acts as constructor ID - kelinta karta kviecia metoda
        int colorNum = colorList.length; // =5
        int maxNum = 20; //TO-DO sound items array.
        int eachColor = (maxNum/colorNum); // 20/5 == 4
        if(gradientMapInteger>eachColor){
            colorPosition++;
        }
        relativeLayout.setBackgroundResource(colorList[colorPosition]);

    }
}
