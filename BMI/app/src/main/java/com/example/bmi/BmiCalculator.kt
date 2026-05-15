package com.example.bmi

object BmiCalculator {
    fun calculate(weight: Double, heightCm: Double): Double {
            if (weight <= 0 || heightCm <= 0) return 0.0
            val heightM = heightCm / 100
            return weight / (heightM * heightM)
    }
}