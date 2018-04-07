/**
 * This App is a project showing the transition from one activity (and screen) to another one.
 * Various types of Views are used in user interface. It works perfectly in both screen orientations.
 * The implementation of Audio playback is very basic for now.
 */
// TODO: 07.04.2018  Stop the song before playing another one.
package com.example.vojmi.nocopyrightmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets the content of the activity to the activity_main.xml
        setContentView(R.layout.activity_main);



        // Finds the View showing the D'n'B music style
        TextView dnb = (TextView) findViewById(R.id.dnb);

        // Sets the click listener to that View
        dnb.setOnClickListener(new View.OnClickListener() {
            // After clicking on this category, the method will be executed
            @Override
            public void onClick(View view) {
                // Create a new intent to open DnB activity
                Intent dnbIntent = new Intent(MainActivity.this, DnB.class);
                // Starts that new activity
                startActivity(dnbIntent);
            }
        });
        // Finds the View showing the Dubstep music style
        TextView dubstep = (TextView) findViewById(R.id.dubstep);

        // Sets the click listener to that View
        dubstep.setOnClickListener(new View.OnClickListener() {
            // After clicking on this category, the method will be executed
            @Override
            public void onClick(View view) {
                // Create a new intent to open Dubstep activity
                Intent dubstepIntent = new Intent(MainActivity.this, Dubstep.class);
                // Starts that new activity
                startActivity(dubstepIntent);
            }
        });
        // Finds the View showing the House music style
        TextView house = (TextView) findViewById(R.id.house);

        // Sets the click listener to that View
        house.setOnClickListener(new View.OnClickListener() {
            // After clicking on this category, the method will be executed
            @Override
            public void onClick(View view) {
                // Create a new intent to open House activity
                Intent houseIntent = new Intent(MainActivity.this, House.class);
                // Starts that new activity
                startActivity(houseIntent);
            }
        });
    }
}
