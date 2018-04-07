package com.example.vojmi.nocopyrightmusic;

/**
 * The class Song represents a song, it contains the song title and artists name.
 */
public class Song {

    /**
     * Name of the song
     */
    private String mSongTitle;
    /**
     * Artist's name
     */
    private String mArtistName;
    /**
     * Audio file assigned to every song.
     */
    private int mAudioResourceId;

    /**
     * Creates a new object Song.
     *
     * @param songName   is the name of the song
     * @param artistName is the author of the song
     */


    public Song(String songName, String artistName, int audioResourceId) {
        mSongTitle = songName;
        mArtistName = artistName;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the song name.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the artist's name.
     */
    public String getArtistName() {
        return mArtistName;
    }
    /**
     * Get the song"s ID.
     */
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

}
