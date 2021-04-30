package com.example.pushtest

import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat
import com.example.pushtest.FireBaseService.Companion.KEY_QUICK_REPLY_TEXT
import com.example.pushtest.FireBaseService.Companion.MESSAGE_ID
import com.example.pushtest.FireBaseService.Companion.NOTIFICATION_MESSAGE_BODY

class BroadcastReceiverNotification : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val results = RemoteInput.getResultsFromIntent(intent)
        if (results != null) {
            val quickReplyResult = results.getCharSequence(KEY_QUICK_REPLY_TEXT).toString()
            val messageNotification = intent?.getStringExtra(NOTIFICATION_MESSAGE_BODY)

            context.sendBroadcast(
                Intent(FILTER_RECEIVER_MAIN).apply {
                    putExtra(REMOVE_INPUT_BROADCAST_RECEIVER_MESSAGE, quickReplyResult)
                    putExtra(NOTIFICATION_MESSAGE, messageNotification)
                }
            )
            val mNotificationManager = NotificationManagerCompat.from(context.applicationContext)
            mNotificationManager.cancel(MESSAGE_ID)
        }
    }

    companion object {
        const val FILTER_RECEIVER_MAIN = "TO_ACTIVITY_MAIN"
        const val REMOVE_INPUT_BROADCAST_RECEIVER_MESSAGE = "TO_ACTIVITY_REMOTE_MESSAGE"
        const val NOTIFICATION_MESSAGE = "BROADCAST_TO_ACTIVITY"
    }

}