package com.example.pc.tf2soundboard;

/**
 * Created by PC on 3/21/2018.
 */

public class Item {

    String title;
    int sound;

    public Item(String title ) {
        this.title = title;
    }

    public Item(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
