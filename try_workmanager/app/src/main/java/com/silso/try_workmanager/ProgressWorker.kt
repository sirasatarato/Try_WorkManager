package com.silso.try_workmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class ProgressWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    private val CHANNEL_ID: String = "WORKER_CHANNEL"
    private var notificationManager: NotificationManager

    init {
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel()
    }

    override fun doWork(): Result {
        try {
            for (i in 0..100) {
                showNotification(i)
                Thread.sleep(100)
            }
        } catch (e: Exception) {
            return Result.failure()
        }

        return Result.success()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val name: CharSequence = "worker channel"
            val description = "worker channel"
            val importance: Int = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description

            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification(progress: Int) {
        val notification: Notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("It is WorkManager")
            .setProgress(100, progress, false)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

        notificationManager.notify(4, notification)
    }
}