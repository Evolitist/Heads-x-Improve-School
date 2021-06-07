package com.example.pushtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FireBaseService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        sendBroadcast(Intent(FILTER_TOKEN_ACTIVITY).putExtra(TOKEN, token))
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val messageBody = remoteMessage.notification?.body?: "Entry"
        val messageTitle = remoteMessage.notification?.title?: "Entry"

        createNotificationChannel()

        val intent = Intent(applicationContext, BroadcastReceiverNotification::class.java).apply {
            putExtra(NOTIFICATION_MESSAGE_BODY, messageBody)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val remoteInput = RemoteInput.Builder(KEY_QUICK_REPLY_TEXT)
            .setLabel("Quick reply")
            .build()

        val action = NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground, "Reply", pendingIntent)
            .addRemoteInput(remoteInput)
            .build()

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(messageTitle)
            .setContentText(messageBody)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(action)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            notify(MESSAGE_ID, builder.build())
        }

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "Main Notification"
        const val KEY_QUICK_REPLY_TEXT = "quick_reply"
        const val NOTIFICATION_MESSAGE_BODY = "TO_ACTIVITY_MESSAGE"
        const val FILTER_TOKEN_ACTIVITY = "TOKEN_TO_ACTIVITY_FILTER"
        const val TOKEN = "TOKEN_FB"
        const val MESSAGE_ID = 69
    }

}