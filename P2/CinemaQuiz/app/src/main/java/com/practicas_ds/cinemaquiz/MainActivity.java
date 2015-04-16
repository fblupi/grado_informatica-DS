package com.practicas_ds.cinemaquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button btNewGame = (Button) findViewById(R.id.new_game);
        Button btResults = (Button) findViewById(R.id.results);
        Button btOtherGames = (Button) findViewById(R.id.other_games);

        btNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent siguiente = new Intent(this, GameActivity.class);
                //startActivity(siguiente);
            }
        });

        btResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btOtherGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
