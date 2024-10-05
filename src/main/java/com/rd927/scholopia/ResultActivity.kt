package com.rd927.scholopia

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ResultActivity : AppCompatActivity() {

    lateinit var resultText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        // Enable the Up button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        resultText = findViewById(R.id.resultText)

        // Get the BMI value passed from BmiActivity
        val bmi = intent.getDoubleExtra("BMI_RESULT", 0.0)

        // Display the BMI result
        resultText.text = "Your BMI is %.2f".format(bmi)


        val button = findViewById<Button>(R.id.wp)
        button.setOnClickListener {
            // Navigate to CreateSchedule activity when the FAB is clicked
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }

    }





}