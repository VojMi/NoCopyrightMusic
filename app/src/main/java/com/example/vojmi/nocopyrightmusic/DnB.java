package com.example.vojmi.nocopyrightmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DnB extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.song_list));


        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("VIP", "bvd kult", R.raw.dnb1));
        songs.add(new Song("Story", "Rameses B", R.raw.dnb2));
        songs.add(new Song("Reflections", "Kasger", R.raw.dnb3));
        songs.add(new Song("Happy", "Bob Gasser", R.raw.dnb4));
        songs.add(new Song("Green Lights", "Mekanism", R.raw.dnb5));

        // Creates a SongAdapter based on the list of songs
        SongAdapter adapter = new SongAdapter(this, songs);
        // Finding of XML object to which the list of songs will be put
        ListView listView = (ListView) findViewById(R.id.list_of_songs);
        //Setting of that adapter
        listView.setAdapter(adapter);
        /**
         * This method plays the specified song after clicking the specified AdapterView.
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = songs.get(i);
                mMediaPlayer = MediaPlayer.create(DnB.this, song.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}