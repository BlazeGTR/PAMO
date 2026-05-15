package com.example.bmi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewIngredients)

        // Mówimy, że lista ma być pionowa
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Tworzymy naszą przykładową listę składników (wymagania przepisu)
        val recipeIngredients = listOf(
            Ingredient("Płatki owsiane (100g)"),
            Ingredient("Mleko (250ml)"),
            Ingredient("Banan (1 sztuka)"),
            Ingredient("Masło orzechowe (1 łyżka)"),
            Ingredient("Garść borówek")
        )

        // Podpinamy Adapter do RecyclerView
        val adapter = IngredientAdapter(recipeIngredients)
        recyclerView.adapter = adapter

    }
}