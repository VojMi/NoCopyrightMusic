package com.example.vojmi.nocopyrightmusic;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class DnbFragment extends Fragment {
    public DnbFragment() {

    }
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView=inflater.inflate(R.layout.song_list,container,false);
        mAudioManager=(AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Finds the 'BACK TO GENRES' button.
        Button back = (Button) rootView.findViewById(R.id.back);

        // Sets the click listener to that button
        back.setOnClickListener(new View.OnClickListener() {
            // After clicking on this category, the method will be executed
            @Override
            public void onClick(View view) {
                // Create a new intent to open MainActivity
                Intent mainIntent = new Intent(getActivity(), MainActivity.class);
                // Starts that new activity
                startActivity(mainIntent);
                // Stops music
                releaseMediaPlayer();
            }
        });

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("VIP", "bvd kult", R.raw.dnb1));
        songs.add(new Song("Story", "Rameses B", R.raw.dnb2));
        songs.add(new Song("Reflections", "Kasger", R.raw.dnb3));
        songs.add(new Song("Happy", "Bob Gasser", R.raw.dnb4));
        songs.add(new Song("Green Lights", "Mekanism", R.raw.dnb5));

        // Creates a SongAdapter based on the list of songs
        SongAdapter adapter = new SongAdapter(getActivity(), songs);
        // Finding of XML object to which the list of songs will be put
        ListView listView = (ListView) rootView.findViewById(R.id.list_of_songs);
        //Setting of that adapter
        listView.setAdapter(adapter);
        /**
         * This method plays the specified song after clicking the specified AdapterView.
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = songs.get(i);
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(getActivity(), song.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
        return rootView;
    }
    /**
     * Cleaning of media resources (stopping one file before playing another)
     */
    private void releaseMediaPlayer(){

        if (mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }
}