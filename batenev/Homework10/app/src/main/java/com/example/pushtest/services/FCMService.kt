package com.example.pushtest.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.core.os.bundleOf
import com.example.pushtest.R
import com.example.pushtest.data.MessageData
import com.example.pushtest.network.Api
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.*

class FCMService : FirebaseMessagingService() {

    private var notificationID = 0
    private val notificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    private val replyReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let {
                if (it.action == REPLY_INTENT_ACTION) {
                    val id = it.getIntExtra(NOTIFICATION_ID_KEY, 0)
                    val message = RemoteInput.getResultsFromIntent(intent)
                        .getCharSequence(REMOTE_INPUT_RESULT_KEY) ?: "Empty message"
                    serviceScope.launch {
                        Api.apiService.sendMessage(
                            MessageData(
                                "Kakava",
                                message.toString()
                            )
                        )
                    }
                    //Эта штука не работает. Никак. Решение не нагуглил :0
                    notificationManager.cancel(NOTIFICATION_TAG, id)
                }
            }
        }
    }


    override fun onCreate() {
        super.onCreate()

        registerReceiver(replyReceiver, IntentFilter(REPLY_INTENT_ACTION))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(
            "FCMService",
            "FROM : ${remoteMessage.from}, BODY : ${remoteMessage.notification?.body ?: "No Body"}"
        )
        remoteMessage.notification?.let {
            showMessageNotification(
                it.title ?: "No title",
                it.body ?: "No message"
            )
        }
    }

    private fun showMessageNotification(title: String, text: String) {
        val remoteInput = RemoteInput.Builder(REMOTE_INPUT_RESULT_KEY)
            .setLabel("Reply")
            .build()

        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            Intent(REPLY_INTENT_ACTION).putExtras(
                bundleOf(
                    NOTIFICATION_ID_KEY to notificationID + 1
                )
            ),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val replyAction = NotificationCompat.Action.Builder(
            R.drawable.ic_launcher_foreground,
            "Reply",
            pendingIntent
        ).run {
            addRemoteInput(remoteInput)
        }.build()

        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(replyAction)
            .setAutoCancel(false)
            .build()

        notificationManager.notify(NOTIFICATION_TAG, notificationID++, notification)
    }

    override fun onDestroy() {
        serviceScope.cancel()
        super.onDestroy()
    }

    companion object {
        //Можно было вынести в ресурсы, знаю
        private const val NOTIFICATION_CHANNEL_ID = "FCM_NOTIFICATION_CHANNEL_ID"
        private const val NOTIFICATION_CHANNEL_NAME = "FCM_NOTIFICATION_CHANNEL_NAME"

        private const val REMOTE_INPUT_RESULT_KEY = "REMOTE_INPUT_RESULT_KEY"
        private const val NOTIFICATION_ID_KEY = "NOTIFICATION_ID_KEY"
        private const val REPLY_INTENT_ACTION = "REPLY_INTENT_ACTION"
        private const val NOTIFICATION_TAG = "NOTIFICATION_TAG"
    }
}