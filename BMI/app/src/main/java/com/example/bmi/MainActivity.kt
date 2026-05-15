package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBmi = findViewById<Button>(R.id.btnBmi)
        val btnCal = findViewById<Button>(R.id.btnCalories)
        val btnGra = findViewById<Button>(R.id.btnGraph)
        val btnLis = findViewById<Button>(R.id.btnList)

        btnBmi.setOnClickListener {
            val intent = Intent(this, BmiActivity::class.java)
            startActivity(intent)
        }

        btnCal.setOnClickListener {
            val intent = Intent(this, CalorieActivity::class.java)
            startActivity(intent)
        }

        btnGra.setOnClickListener {
            val intent = Intent(this, BmiChartActivity::class.java)
            startActivity(intent)
        }

        btnLis.setOnClickListener {
            val intent = Intent(this, ShoppingListActivity::class.java)
            startActivity(intent)
        }
    }
}