package com.rd927.scholopia

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing)

        val reminder = findViewById<ImageView>(R.id.reminder)
        reminder.setOnClickListener {
            // Navigate to CreateSchedule activity when the back is clicked
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}