package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val items: List<ActivityMainBinding>, private val onItemClick: (ActivityMainBinding) -> Unit) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    // ViewHolder class to hold references to the views in each list item
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.titleTextView)
    }

    // Creating new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating the item layout and create a ViewHolder
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Getting the item at the current position

        val item = items[position]
        println(item)
        // Binding the item's text to the TextView in the ViewHolder
        holder.textView.text = item.title
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    // Returns the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        // Returns the number of items in the dataset
        return items.size
    }
}


