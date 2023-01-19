package com.example.smartpilow.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.smartpilow.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*


class FirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("TAG",message.data.toString())
        Log.d("TAG",message.senderId.toString())
        Log.d("TAG",message.rawData.toString())

        var customData = message.data

        showNotification(customData["title"].toString(),customData["subtitle"].toString())
        super.onMessageReceived(message)
    }

    override fun onNewToken(token: String) {
        Log.d("TAG",token)
        super.onNewToken(token)
    }


    private fun showNotification(title: String, body: String) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val NOTIFICATION_CHANNEL_ID = "example.myapplication.service.test"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID, "Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationChannel.description = "Team Tarang"
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableLights(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        notificationBuilder.setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)
            .setWhen(System.currentTimeMillis())
            .setContentTitle(title)
            .setContentText(body)
            .setContentInfo("Info")
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
        notificationManager.notify(Random().nextInt(), notificationBuilder.build())
    }

}