package com.example.vojmi.nocopyrightmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class Dubstep extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.song_list));

        // Finds the 'BACK TO GENRES' button.
        Button back = (Button) findViewById(R.id.back);

        // Sets the click listener to that button
        back.setOnClickListener(new View.OnClickListener() {
            // After clicking on this category, the method will be executed
            @Override
            public void onClick(View view) {
                // Create a new intent to open MainActivity
                Intent dnbIntent = new Intent(Dubstep.this, MainActivity.class);
                // Starts that new activity
                startActivity(dnbIntent);
            }
        });

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Heavens gate", "Anikdote x Absent faith", R.raw.dbs1));
        songs.add(new Song("Perseus", "Unknown Brain", R.raw.dbs2));
        songs.add(new Song("Somebody", "Sekai", R.raw.dbs3));
        songs.add(new Song("The Wizard", "SKYL1NK", R.raw.dbs4));
        songs.add(new Song("Watch the World Burn", "Paul Flint", R.raw.dbs5));

        // Creates a SongAdapter based on the list of songs
        SongAdapter adapter = new SongAdapter(this, songs);
        // Finding of XML object to which the list of songs will be put
        ListView listView = (ListView) findViewById(R.id.list_of_songs);
        //Setting of that adapter
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = songs.get(i);

                mMediaPlayer = MediaPlayer.create(Dubstep.this, song.getmAudioResourceId());
                    mMediaPlayer.start();
            }
        });
    }
}