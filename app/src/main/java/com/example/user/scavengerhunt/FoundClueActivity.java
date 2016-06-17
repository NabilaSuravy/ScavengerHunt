package com.example.user.scavengerhunt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.scavengerhunt.DataObjects.Clue;

public class FoundClueActivity extends AppCompatActivity {

    SharedPreferences mSharedPref;
    String lastPath;
    int currentClue;
    int searchClue;
    TextView textMsg;
    Clue[] clues1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_clue);
        mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Intent intent = getIntent();
        Uri uri = intent.getData();                 // retrieve a Uri object instance or
        lastPath = uri.getLastPathSegment();  // retrieve the string representation of the URI
        textMsg = (TextView) findViewById(R.id.found_clue_num);
        currentClue=Integer.parseInt(lastPath);
        searchClue = mSharedPref.getInt("userCurrentClue",0);
        if(currentClue==searchClue){


            if(currentClue==searchClue){
                textMsg.setText("Found the correct Clue");
            }
            else {
                textMsg.setText("You have already tapped it");
            }
        }
        else if(currentClue> searchClue){
            textMsg.setText("Found the clue too early");
        }
        else{
            textMsg.setText("This clue has already been found");
        }

    }

    public void findClue(View v){
        String[] clues = getResources().getStringArray(R.array.clues);
        int n=clues.length;
        if (currentClue==2 && searchClue==2){
            Intent i = new Intent(this,WinActivity.class);
            startActivity(i);
        }
        else if(currentClue==searchClue){
            Intent i = new Intent(this,CurrentClueActivity.class);
            SharedPreferences.Editor editor = mSharedPref.edit();
            editor.putInt("userCurrentClue", searchClue+1);
            editor.commit();
            startActivity(i);
        }
        else{
            Intent i = new Intent(this,CurrentClueActivity.class);
            startActivity(i);
        }
    }

}
