package com.example.bmi

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BmiActivityEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(BmiActivity::class.java)

    @Test
    fun calculateBmi_displaysCorrectResult() {
        onView(withId(R.id.etWeightCal))
            .perform(typeText("70"), closeSoftKeyboard())

        onView(withId(R.id.etHeightCal))
            .perform(typeText("175"), closeSoftKeyboard())

        onView(withId(R.id.btnCalcCalories))
            .perform(click())

        onView(withId(R.id.tvCalorieResult))
            .check(matches(withText(org.hamcrest.Matchers.containsString("Waga OK"))))
    }
}