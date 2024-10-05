package com.rd927.scholopia

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    private lateinit var notificationHelper: NotificationHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the button click listener
        findViewById<Button>(R.id.getStartedButton).setOnClickListener {
            // Start the LoginActivity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }


        // Example of scheduling a notification
//        scheduleSampleNotification()

//        deleteDatabase()
    }

    private fun scheduleSampleNotification() {
        // Example data for scheduling a notification
        val title = "Test Notification"
        val message = "This is a test notification."
        val triggerTime = System.currentTimeMillis() + 60000 // Schedule for 1 minute later

        // Schedule the notification
        notificationHelper.scheduleNotification(title, message, triggerTime)
    }




    private fun deleteDatabase() {
        deleteDatabase("scholopia_database")
    }
}