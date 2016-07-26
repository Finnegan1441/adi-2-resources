package gg.patrickcummins.hotify;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by patrickcummins on 7/25/16.
 */

public class SongService extends Service {

    MediaPlayer mediaPlayer = new MediaPlayer();
    String url;
    boolean isPrepared = false;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final String userinput = intent.getStringExtra("userinput");
        if (intent.getStringExtra("songUrl") == null){
            url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";

        }else {
            url = intent.getStringExtra("songUrl");

        }



        new Thread(new Runnable() {
            @Override
            public void run() {
                if (isPrepared) {
                    if (userinput.equals("play")){
                        mediaPlayer.start();
                    } else if (userinput.equals("pause")){
                        mediaPlayer.pause();
                    }else if (userinput.equals("stop")){
                        mediaPlayer.stop();
                    }


                }else{
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mediaPlayer.setDataSource(url);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            isPrepared = true;
                            Log.i("SONG SERVICE", "IS PREPARED IS TRUE");
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            stopSelf();
                        }
                    });
                    isPrepared=true;
                }
            }
        }).run();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        isPrepared = false;
        stopForeground(true);


        super.onDestroy();
    }
}
