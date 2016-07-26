package com.example.jeanweatherwax.boundservicepractice;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    //create instance of your BoundService and set isBound to False


    //make a ServiceConnection called myConnection and implement the
    //onServiceConnected and onServiceDisconnected methods.
    // You should set isBound to the appropriate value in each method.
    // Yo should also set your binder in onServiceConnected.
    // Show a Toast in each.
    BoundService service;
    boolean mBound;
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundService.MyLocalBinder localBinder = (BoundService.MyLocalBinder) iBinder;
            service = localBinder.getService();
            mBound = true;
            Toast.makeText(MainActivity.this, "Bound", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound  = false;
            Toast.makeText(MainActivity.this, "Un-Bound", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        Button showTimeButton = (Button) findViewById(R.id.showTimeButton);
        final TextView timeTextView = (TextView) findViewById(R.id.myTextView);

        final Intent intent = new Intent(this, BoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);


        //set an onClickListened for the button to show the time
        showTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime(timeTextView);
            }
        });


    }


    //unbind the service here in onStop
    @Override
    public void onStop() {
        super.onStop();
        if (mBound){
            unbindService(myConnection);
        }
    }


    //in this method, get the current time using your service, and display it in the Textview.
    public void showTime(View view)
    {
        TextView timeTextview = (TextView) view;
        timeTextview.setText(service.getCurrentTime());

    }
}
