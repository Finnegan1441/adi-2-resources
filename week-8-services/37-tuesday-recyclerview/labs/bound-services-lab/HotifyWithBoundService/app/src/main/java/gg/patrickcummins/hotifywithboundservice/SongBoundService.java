package gg.patrickcummins.hotifywithboundservice;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by patrickcummins on 7/26/16.
 */

public class SongBoundService extends Service {
    private final IBinder iBinder = new myBinder();
    MediaPlayer mediaPlayer = new MediaPlayer();
    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
    boolean isPrepared = false;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return iBinder;
    }

    public void playMedia(){
        if (isPrepared){
            mediaPlayer.start();
        }else {
            prepareMedia();
        }
    }

    private void prepareMedia() {
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPrepared =true;
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopSelf();
            }
        });
    }

    public void pauseMedia(){
        if (isPrepared) {
            mediaPlayer.pause();
        }
    }
    public void stopMedia(){
        if (isPrepared) {
            mediaPlayer.stop();
            isPrepared = false;
        }
    }


    public class myBinder extends Binder {
        SongBoundService getService() {
            return SongBoundService.this;
        }
    }
}
