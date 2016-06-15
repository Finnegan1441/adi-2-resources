package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button buyButton = (Button) findViewById(R.id.buyButton);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button sendButton = (Button) findViewById(R.id.sendButton);
        Button likeButton = (Button) findViewById(R.id.likeButton);

        View.OnClickListener buyClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ToastActivity.this, "You Bought Something", Toast.LENGTH_SHORT).show();

            }
        };
        View.OnClickListener saveClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "You Saved Something", Toast.LENGTH_SHORT).show();

            }
        };
        View.OnClickListener likeClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "You Liked Something", Toast.LENGTH_SHORT).show();

            }
        };
        View.OnClickListener sendClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "You Sent Something", Toast.LENGTH_SHORT).show();

            }
        };

        buyButton.setOnClickListener(buyClickListener);
        saveButton.setOnClickListener(saveClickListener);
        likeButton.setOnClickListener(likeClickListener);
        sendButton.setOnClickListener(sendClickListener);
    }



}
