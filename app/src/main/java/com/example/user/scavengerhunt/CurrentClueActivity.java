package com.example.user.scavengerhunt;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.scavengerhunt.DataObjects.Clue;

public class CurrentClueActivity extends AppCompatActivity {

    TextView mClueTextView;
    TextView mProgressTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_clue);
        SharedPreferences sharedPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        int indexOfClueIWantToSee=sharedPrefs.getInt("userCurrentClue",0);
        Clue[] clues1=((MyApplication)getApplication()).getClues();
        Clue clue=clues1[indexOfClueIWantToSee];

        mClueTextView=(TextView) findViewById(R.id.clue_text_view);
        mProgressTextView=(TextView) findViewById(R.id.progress_text_view);
        mClueTextView.setText(clue.getClue());
        mProgressTextView.setText(clue.getId()+"/2 Completed");
    }

}
