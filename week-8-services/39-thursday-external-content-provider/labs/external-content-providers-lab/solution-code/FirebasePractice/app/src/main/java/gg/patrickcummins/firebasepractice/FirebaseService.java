package gg.patrickcummins.firebasepractice;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.os.Build.VERSION_CODES.N;

/**
 * Created by patrickcummins on 7/29/16.
 */

public class FirebaseService extends FirebaseMessagingService {
    String TAG = "FirebaseService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i(TAG, "onMessageReceived: " + remoteMessage.getFrom());;
        Log.i(TAG, "onMessageReceived: body " + remoteMessage.getNotification().getBody());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("THIS IS A TITLE");
        builder.setContentText("THIS IS TEXT");
        builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(1, builder.build());
    }
}
