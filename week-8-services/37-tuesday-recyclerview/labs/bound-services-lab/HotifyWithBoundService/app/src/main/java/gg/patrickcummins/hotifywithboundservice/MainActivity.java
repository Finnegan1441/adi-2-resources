package gg.patrickcummins.hotifywithboundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play, pause, stop;
    SongBoundService myService;
    boolean isBound = false;

    private ServiceConnection myConnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SongBoundService.myBinder binder = (SongBoundService.myBinder) iBinder;
            myService = binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound=false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, SongBoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
        setViews();
        setOnClicks();
    }

    private void setOnClicks() {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myService.playMedia();

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myService.pauseMedia();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myService.stopMedia();
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        if(isBound) {
            unbindService(myConnection);
        }

    }

    private void setViews() {
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);

    }
}
