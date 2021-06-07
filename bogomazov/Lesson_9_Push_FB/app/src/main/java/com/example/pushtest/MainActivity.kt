package com.example.pushtest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.pushtest.BroadcastReceiverNotification.Companion.FILTER_RECEIVER_MAIN
import com.example.pushtest.BroadcastReceiverNotification.Companion.NOTIFICATION_MESSAGE
import com.example.pushtest.BroadcastReceiverNotification.Companion.REMOVE_INPUT_BROADCAST_RECEIVER_MESSAGE
import com.example.pushtest.FireBaseService.Companion.TOKEN
import com.example.pushtest.FireBaseService.Companion.FILTER_TOKEN_ACTIVITY
import com.example.pushtest.databinding.ActivityMainBinding
import com.example.pushtest.model.ViewModelMain
import com.example.pushtest.network.data.MessageData
import com.example.pushtest.network.data.UserData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: ViewModelMain by viewModels()
    private lateinit var broadcastReceiverNotification: BroadcastReceiver
    private lateinit var broadcastReceiverToken: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }
            val token = task.result
            val data = UserData("bogomazov", token?: "")
            model.sendInfoUser(data)
            Log.d("FM", "Token $token")
        })

        model.status.observe(this) {
            binding.textRes.text = it.status
        }

        binding.button.setOnClickListener {
            sendMessage("Сорян кому прилетело")
        }

        broadcastReceiverNotification = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.getStringExtra(REMOVE_INPUT_BROADCAST_RECEIVER_MESSAGE)?.let {
                    sendMessage(it)
                }
                intent?.getStringExtra(NOTIFICATION_MESSAGE)?.let {
                    binding.textViewRemoveInput.text = it
                }
            }
        }

        broadcastReceiverToken = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.getStringExtra(TOKEN)?.let {
                    val data = UserData("bogomazov", it)
                    model.sendInfoUser(data)
                }
            }

        }
        registerReceiver(broadcastReceiverNotification, IntentFilter(FILTER_RECEIVER_MAIN))
        registerReceiver(broadcastReceiverToken, IntentFilter(FILTER_TOKEN_ACTIVITY))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiverNotification)
        unregisterReceiver(broadcastReceiverToken)
    }

    private fun sendMessage(message: String) {
        val dataMessage = MessageData("bogomazov", message)
        model.sendMessage(dataMessage)
    }
}