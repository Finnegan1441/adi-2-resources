package ly.generalassemb.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by patrickcummins on 7/25/16.
 */

public class CustomIntentService extends IntentService {
    public CustomIntentService() {
        super("Custom Intenet Service");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("CUSTOM INTENT SERVICE", "Service Created");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("CUSTOM INTENT SERVICE", "Service Destroyed");
    }
}
