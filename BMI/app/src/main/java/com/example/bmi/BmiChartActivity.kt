package com.example.bmi

import android.os.Bundle
import android.graphics.Color
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class BmiChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi_chart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lineChart = findViewById<LineChart>(R.id.lineChartBmi)

        //Zamockowane dane
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 26.5f))
        entries.add(Entry(2f, 25.8f))
        entries.add(Entry(3f, 25.0f))
        entries.add(Entry(4f, 24.2f))
        entries.add(Entry(5f, 23.5f))

        //konfiguracja
        val dataSet = LineDataSet(entries, "Historia Twojego BMI")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 12f
        dataSet.lineWidth = 3f
        dataSet.circleRadius = 5f
        dataSet.setCircleColor(Color.RED)

        // robimy wykres
        val lineData = LineData(dataSet)
        lineChart.data = lineData

        // animujemy to jakoś
        lineChart.description.text = "Zmiany BMI w ostatnich 5 miesiącach"
        lineChart.animateX(1000)
        lineChart.invalidate()
    }
}