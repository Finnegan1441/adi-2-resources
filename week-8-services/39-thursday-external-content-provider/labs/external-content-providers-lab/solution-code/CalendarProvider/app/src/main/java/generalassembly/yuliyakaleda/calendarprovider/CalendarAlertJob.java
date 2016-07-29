package generalassembly.yuliyakaleda.calendarprovider;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.NotificationCompat;

/**
 * Created by patrickcummins on 7/29/16.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class CalendarAlertJob extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        PersistableBundle bundle = params.getExtras();
        String event = bundle.getString("event");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("You have an event coming up soon");
        builder.setContentText(event + " is coming up soon");
        builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);

        NotificationManager manager  = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
