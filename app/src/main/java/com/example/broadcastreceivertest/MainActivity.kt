package com.example.broadcastreceivertest

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastreceivertest.AirplaneModeChangeReceiver
import com.example.broadcastreceivertest.R

class MainActivity : AppCompatActivity() {
    lateinit var receiver : AirplaneModeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AirplaneModeChangeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}