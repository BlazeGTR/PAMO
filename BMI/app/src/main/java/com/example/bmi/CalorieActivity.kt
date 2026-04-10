package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalorieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calorie)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Połączenie widoku z kodem (findViewById)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etWeight = findViewById<EditText>(R.id.etWeightCal)
        val etHeight = findViewById<EditText>(R.id.etHeightCal)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnCalc = findViewById<Button>(R.id.btnCalcCalories)
        val tvResult = findViewById<TextView>(R.id.tvCalorieResult)

        btnCalc.setOnClickListener {
            // Pobranie wartości i zamiana na liczby
            val age = etAge.text.toString().toIntOrNull()
            val weight = etWeight.text.toString().toDoubleOrNull()
            val height = etHeight.text.toString().toDoubleOrNull()

            if (age != null && weight != null && height != null) {
                val isMale = rgGender.checkedRadioButtonId == R.id.rbMale

                // 1. Obliczanie BMR wzorem Benedicta-Harrisa
                val bmr = if (isMale) {
                    66.47 + (13.75 * weight) + (5.003 * height) - (6.75 * age)
                } else {
                    655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age)
                }

                // 2. Uwzględnienie aktywności (PAL)
                // Na start przyjmijmy średni mnożnik 1.55 (możesz to rozbudować)
                val totalCalories = bmr * 1.55

                // 3. Wyświetlenie wyniku (zaokrąglonego)
                tvResult.text = "Twoje dzienne zapotrzebowanie: ${totalCalories.toInt()} kcal"
            } else {
                tvResult.text = "Proszę uzupełnić wszystkie pola!"
            }
        }
    }
}