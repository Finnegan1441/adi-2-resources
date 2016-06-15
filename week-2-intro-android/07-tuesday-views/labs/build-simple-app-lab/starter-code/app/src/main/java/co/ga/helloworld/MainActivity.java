package co.ga.helloworld;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static co.ga.helloworld.R.id.blueButton;
import static co.ga.helloworld.R.id.grayButton;
import static co.ga.helloworld.R.id.purpleButton;
import static co.ga.helloworld.R.id.textView;

public class MainActivity extends AppCompatActivity {
    boolean textViewisClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewisClicked = false;
        final TextView myTextView = (TextView) findViewById(textView);
        final Button blueButton = (Button) findViewById(R.id.blueButton);
        final Button grayButton = (Button) findViewById(R.id.grayButton);
        final Button purpleButton = (Button) findViewById(R.id.purpleButton);

        View.OnClickListener onBlueClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setTextColor(Color.BLUE);
                myTextView.setText("BLUE");
            }
        };
        View.OnClickListener onPurpleClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setTextColor(Color.MAGENTA);
                myTextView.setText("PURPLE");
            }
        };
        View.OnClickListener onGrayClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setTextColor(Color.GRAY);
                myTextView.setText("GRAY");
            }
        };
        myTextView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myTextView.getText().equals("BLUE")){
                    blueButton.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
                    purpleButton.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
                    grayButton.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
               }
                else if(myTextView.getText().equals("GRAY")) {
                    blueButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    purpleButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    grayButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);


                } else if (myTextView.getText().equals("PURPLE")){
                    blueButton.getBackground().setColorFilter(Color.MAGENTA, PorterDuff.Mode.MULTIPLY);
                    purpleButton.getBackground().setColorFilter(Color.MAGENTA, PorterDuff.Mode.MULTIPLY);
                    grayButton.getBackground().setColorFilter(Color.MAGENTA, PorterDuff.Mode.MULTIPLY);
                }

            }
        });

        blueButton.setOnClickListener(onBlueClick);
        grayButton.setOnClickListener(onGrayClick);
        purpleButton.setOnClickListener(onPurpleClick);

    }





}
