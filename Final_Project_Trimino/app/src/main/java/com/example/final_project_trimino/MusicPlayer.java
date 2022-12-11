package com.example.final_project_trimino;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MusicPlayer {

    public static MediaPlayer mediaPlayer;


    public static void playAudio(Context c){

        if(mediaPlayer==null){
            mediaPlayer = MediaPlayer.create(c, R.raw.song);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
        mediaPlayer.start();
    }


    public static void stopAudio(Context c){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
            Toast.makeText(c,"Muted", Toast.LENGTH_SHORT).show();
        }
    }
}
