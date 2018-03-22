package com.example.pc.tf2soundboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 3/21/2018.
 */

public class CustomAdapter extends ArrayAdapter{

    ArrayList<Item> soundsList = new ArrayList<Item>();

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
        return v;
    }
}
