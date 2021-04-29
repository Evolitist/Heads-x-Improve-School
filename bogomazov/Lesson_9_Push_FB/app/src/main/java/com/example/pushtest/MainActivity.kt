package com.example.pushtest

import android.app.NotificationManager
import android.app.RemoteInput
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.pushtest.FireBaseService.Companion.KEY_QUICK_REPLY_TEXT
import com.example.pushtest.FireBaseService.Companion.MESSAGE_ID
import com.example.pushtest.databinding.ActivityMainBinding
import com.example.pushtest.model.ViewModelMain
import com.example.pushtest.network.data.MessageData
import com.example.pushtest.network.data.UserData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: ViewModelMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("MyFirebaseMsgService", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            val token = task.result
            val data = UserData("bogomazov", token?: "")
            model.sendInfoUser(data)
        })

        model.status.observe(this){
            binding.textRes.text = it.status
        }

        binding.button.setOnClickListener {
            sendMessage("Сорян кому прилетело")
        }

        val results = RemoteInput.getResultsFromIntent(intent)
        if (results != null) {
            val quickReplyResult = results.getCharSequence(KEY_QUICK_REPLY_TEXT).toString()
            binding.textViewRemoveInput.text = quickReplyResult
            sendMessage(quickReplyResult)
            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.cancel(MESSAGE_ID)
        }
    }

    private fun sendMessage(message: String){
        val dataMessage = MessageData("bogomazov", message)
        model.sendMessage(dataMessage)
    }
}