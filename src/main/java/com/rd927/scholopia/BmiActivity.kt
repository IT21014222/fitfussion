package com.rd927.scholopia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BmiActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var cal: Button
    lateinit var clear: Button
    lateinit var height: EditText
    lateinit var weight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi)

        cal = findViewById(R.id.cal)
        clear = findViewById(R.id.clear)  // New clear button
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)

        cal.setOnClickListener(this)
        clear.setOnClickListener(this)  // Set listener for clear button
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cal -> calculateBmi()
            R.id.clear -> clearFields()  // Handle the clear button click
        }
    }

    private fun calculateBmi() {
        // Validate input
        val h = height.text.toString()
        val w = weight.text.toString()

        if (h.isEmpty() || w.isEmpty()) {
            Toast.makeText(this, "Please enter both height and weight", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val heightValue = h.toDouble()
            val weightValue = w.toDouble()

            if (heightValue <= 0 || weightValue <= 0) {
                Toast.makeText(this, "Height and weight must be greater than zero", Toast.LENGTH_SHORT).show()
                return
            }

            // Calculate BMI
            val bmi = weightValue / ((heightValue / 100) * (heightValue / 100))

            // Start the ResultActivity and pass the BMI value
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("BMI_RESULT", bmi)
            startActivity(intent)

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearFields() {
        // Clear input fields
        height.text.clear()
        weight.text.clear()
    }
}