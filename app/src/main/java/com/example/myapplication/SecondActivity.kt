package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price", 0.00)

        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        val priceTextView = findViewById<TextView>(R.id.priceTextView)

        descriptionTextView.text = description
        priceTextView.text = "Limited Time Price: $$price"

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.buttonBuy)
        button.setOnClickListener {
            Toast.makeText(this, "Congratulations You got this flower", Toast.LENGTH_SHORT).show();
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Handle the up button click (e.g., navigate to the previous activity)
                onBackPressedDispatcher.onBackPressed()
                return true
            }

            R.id.action_settings -> {
                // Handle the settings action
                return true
            }
            // Add more cases for other menu items if needed
        }
        return super.onOptionsItemSelected(item)
    }
}

