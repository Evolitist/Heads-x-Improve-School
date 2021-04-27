package com.example.pushtest

import android.R
import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST


@Serializable
data class TokenRequest(
        val username: String,
        val token: String
)

@Serializable
data class sendRandom(
        val source: String,
        val message: String
)

@Serializable
data class Response(val status: String)

interface ApiService {

    @POST("registerToken")
    fun post(
            @Body item: TokenRequest
    ): Call<Response>

    @POST("sendToRandom")
    suspend fun postRand(
            @Body item: sendRandom
    ): Response

    @POST("sendAll")
    suspend fun sensAll(
    ): Response

    object Factory {
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("https://us-central1-hxi-push-test.cloudfunctions.net/")
                    .addConverterFactory(Json {
                        ignoreUnknownKeys = true
                    }.asConverterFactory(MediaType.get("application/json")))
                    .build()
        }
    }
}

class MyFirebaseMessagingService : FirebaseMessagingService() {

    val TAG = "Serviceee"

    private val notificationManager by lazy {
        getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }
    private val apiService: ApiService = ApiService.Factory.provideRetrofit().create()
    private val remoteInputReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            GlobalScope.launch(Dispatchers.IO) {
                val s = RemoteInput.getResultsFromIntent(intent).getString("Answer")
                Log.d(TAG, s)
                apiService.postRand(sendRandom("Shonchik", s!!))
                withContext(Dispatchers.Main) {
                    notificationManager.cancel(1)
                }
            }
        }
    }
    private lateinit var lastNotification: Notification

    override fun onCreate() {
        super.onCreate()
        registerReceiver(remoteInputReceiver, IntentFilter(ACTION_SEND))
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            Log.d(TAG, token)
        })
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        apiService.post(TokenRequest("Shonchik", token)).execute()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.from)
        Log.d(TAG, "Notification Message Body: " + remoteMessage.notification!!.body)
        sendMes(remoteMessage.notification!!.title, remoteMessage.notification!!.body)

    }

    fun sendMes(title: String?, body: String?) {
        val notificationChannel = "chat_notifications"

        val remoteInput = RemoteInput.Builder("Answer")
                .setLabel("Enter your reply here")
                .build()

        val resultIntent = Intent(ACTION_SEND)

        val resultPendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        val replyAction = NotificationCompat.Action.Builder(
                R.drawable.ic_dialog_info,
                "Answer", resultPendingIntent)
                .addRemoteInput(remoteInput)
                .build()

        val builder = NotificationCompat.Builder(this, notificationChannel)
                .setSmallIcon(R.drawable.ic_lock_idle_alarm)
                .setContentTitle(title)
                .setContentText(body)
                .addAction(replyAction)

        lastNotification = builder.build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                    notificationChannel,
                    this.getString(R.string.cancel), NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(mChannel)
        }
        notificationManager.notify(1, lastNotification)
    }

    companion object {
        private const val ACTION_SEND = "action.SEND";
    }
}