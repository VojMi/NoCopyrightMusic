package com.example.vojmi.nocopyrightmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class House extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.song_list));


        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Awakening", "Defqwop", R.raw.hs1));
        songs.add(new Song("Feel again", "Culture code", R.raw.hs2));
        songs.add(new Song("Imagine", "Jim Yosef", R.raw.hs3));
        songs.add(new Song("Mates", "Weero", R.raw.hs4));
        songs.add(new Song("Thrill is gone", "Kovan", R.raw.hs5));

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
                mMediaPlayer = MediaPlayer.create(House.this, song.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}