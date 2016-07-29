package com.example.hollis.notificationjobscheduler;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.support.v4.app.NotificationCompat;


/**
 * Created by hollis on 7/13/16.
 */
@TargetApi(21)
public class NotificationJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        //TODO: CREATE YOUR NOTIFICATION!
        android.support.v7.app.NotificationCompat.Builder builder = new android.support.v7.app.NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);
        builder.setContentTitle("A notification");
        builder.setContentText("A notification's text");
        builder.setPriority(Notification.PRIORITY_MAX);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, builder.build());
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
