package com.okanisik.a2ndgradeenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WordsMenu extends AppCompatActivity {


    ImageView resimiki,resimbir;
    MediaPlayer mp,cardresim;
    TextView repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_menu);

        cardresim = MediaPlayer.create(getApplicationContext(),R.raw.kiraz);
        cardresim.start();

        repeat = findViewById(R.id.repeat);

        resimbir = findViewById(R.id.resimbir);
        resimiki = findViewById(R.id.resimiki);




        resimbir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordsMenu.this,MainActivity.class);
                startActivity(intent);
            }
        });


        resimiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordsMenu.this,Wordsiki.class);
                startActivity(intent);
            }
        });






        repeat.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                stopPlayign();
                mp = MediaPlayer.create(WordsMenu.this,R.raw.kiraz);
                mp.start();
                return false;
            }
        });








    }




    private void stopPlayign() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();














    }




}

