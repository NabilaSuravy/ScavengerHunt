package com.example.user.scavengerhunt.DataObjects;

/**
 * Created by User on 6/11/2016.
 */
public class Clue {
    private String mClue;
    private int mId;

    public Clue(String mClue, int mId){
        this.mClue=mClue;
        this.mId=mId;
    }
    public String getClue(){
        return mClue;
    }
    public int getId(){
        return mId;
    }
}
