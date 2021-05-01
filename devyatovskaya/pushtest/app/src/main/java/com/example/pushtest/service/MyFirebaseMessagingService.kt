package com.example.pushtest.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import androidx.core.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.pushtest.R
import com.example.pushtest.models.RegisterToken
import com.example.pushtest.models.SendToRandom
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val notificationManager by lazy {
        NotificationManagerCompat.from(this)
    }

    @Inject
    lateinit var api: ServicePost

    override fun onCreate() {
        super.onCreate()
        registerReceiver(receiver, IntentFilter(ACTION_SEND))
    }

    override fun onNewToken(token: String) {
        GlobalScope.launch {
            api.registerToken(RegisterToken("Alex", token))
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        remoteMessage.notification?.let {
            sendNotification(it.title!!, it.body!!)
        }
    }

    private fun sendNotification(title: String, messageBody: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }

        val intent = Intent(ACTION_SEND).apply {
            putExtra(NOTIFICATION_MESSAGE_BODY, messageBody)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val remoteInput = RemoteInput.Builder(KEY_QUICK_REPLY_TEXT)
            .setLabel("Reply")
            .build()

        val action = NotificationCompat.Action.Builder(
            R.drawable.ic_launcher_foreground,
            "Reply",
            pendingIntent
        )
            .addRemoteInput(remoteInput)
            .build()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(messageBody)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(action)
            .setAutoCancel(true)

        notificationManager.notify(MESSAGE_ID, notification.build())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel() {
        val name = getString(R.string.channel_name)
        val descriptionText = getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
        mChannel.description = descriptionText

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(mChannel)
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val results = RemoteInput.getResultsFromIntent(intent)
            results.getCharSequence(KEY_QUICK_REPLY_TEXT)?.let {
                GlobalScope.launch {
                    api.postRand(SendToRandom("Alex", it.toString()))
                    notificationManager.cancel(MESSAGE_ID)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    companion object {
        const val CHANNEL_ID = "channel"
        const val NOTIFICATION_MESSAGE_BODY = "TO_ACTIVITY_MESSAGE"
        const val ACTION_SEND = "action.SEND"
        const val KEY_QUICK_REPLY_TEXT = "quick_reply"
        const val MESSAGE_ID = 17
    }
}