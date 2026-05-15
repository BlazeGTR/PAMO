package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val weightIn = findViewById<EditText>(R.id.etWeightCal)
        val heightIn = findViewById<EditText>(R.id.etHeightCal)
        val btn = findViewById<Button>(R.id.btnCalcCalories)
        val result = findViewById<TextView>(R.id.tvCalorieResult)

        btn.setOnClickListener {
            val w = weightIn.text.toString().toDoubleOrNull()
            val h = heightIn.text.toString().toDoubleOrNull()

            if (w != null && h != null) {
                val bmi = BmiCalculator.calculate(w, h)

                val category = when {
                    bmi < 18.5 -> "Niedowaga"
                    bmi < 25 -> "Waga OK"
                    else -> "Nadwaga"
                }
                result.text = "Twoje BMI: %.2f\nStatus: %s".format(bmi, category)
            } else {
                result.text = "Proszę uzupełnić dane!"
            }
        }
    }
}