package com.example.bmi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// skladnik
data class Ingredient(val name: String, var isBought: Boolean = false)

// recyclerview
class IngredientAdapter(private val ingredients: List<Ingredient>) :
    RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {

    // containber na widoki
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val checkBox: CheckBox = view.findViewById(R.id.cbBought)
        val textView: TextView = view.findViewById(R.id.tvIngredientName)
    }

    // nowy wiersz
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredient, parent, false)
        return ViewHolder(view)
    }

    // entry dane do wiersza
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ingredients[position]

        holder.textView.text = item.name
        holder.checkBox.setOnCheckedChangeListener(null)
        holder.checkBox.isChecked = item.isBought

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isBought = isChecked
        }
    }

    // rozmiar listy
    override fun getItemCount(): Int {
        return ingredients.size
    }
}