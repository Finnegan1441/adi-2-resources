package gg.patrickcummins.notificationpractice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int NOTIFICATION_ID =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button_notification);

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 122121212, intent, 0);

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("A Notification");
        builder.setContentText("A Notification's Text");
        builder.setContentIntent(pendingIntent);
        builder.setPriority(Notification.PRIORITY_MAX);

        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(NOTIFICATION_ID, builder.build());

            }
        });
    }
}
