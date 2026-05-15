package com.example.bmi

import org.junit.Assert.assertEquals
import org.junit.Test

class BmiCalculatorTest {

    @Test
    fun `GIVEN weight 70 AND height 175 WHEN obliczymy THEN bmi jest ok 22_85`() {
        // Given
        val weight = 70.0
        val height = 175.0

        // When
        val result = BmiCalculator.calculate(weight, height)

        // Then
        assertEquals(22.85, result, 0.01)
    }
}