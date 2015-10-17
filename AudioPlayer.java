package com.example.mtzat.happybirthday;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by mtzat on 10/17/2015.
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;

    public void stop() {
        if (mPlayer !=null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.birthday_song);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion (MediaPlayer mp){
                stop();
            }
        });
        mPlayer.start();
    }
}
