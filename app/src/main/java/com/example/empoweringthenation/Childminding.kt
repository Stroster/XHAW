package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Childminding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_childminding)

        // Apply edge-to-edge layout adjustments
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI elements
        val logo = findViewById<ImageView>(R.id.imageView19)
        val back = findViewById<Button>(R.id.button11)
        val next = findViewById<Button>(R.id.button12)

        // Initialize the Spinner menu
        val index = arrayOf("Home", "Six month Courses", "Six week courses", "Cooking", "Garden Maintenance")
        val menu = findViewById<Spinner>(R.id.spinner7)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            private var isFirstSelection = true  // Track initial selection to avoid auto-trigger

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirstSelection) {
                    isFirstSelection = false  // Ignore first selection
                } else {
                    when (position) {
                        0 -> {
                            startActivity(Intent(this@Childminding, Mainscreen::class.java))
                        }
                        1 -> {
                            startActivity(Intent(this@Childminding, SixMonthCourses::class.java))
                        }
                        2 -> {
                            startActivity(Intent(this@Childminding, SixWeekCourses::class.java))
                        }
                        3 -> {
                            startActivity(Intent(this@Childminding, Cooking::class.java))
                        }
                        4 -> {
                            startActivity(Intent(this@Childminding, Garden_maintenance::class.java))
                        }
                    }
                    finish() // End current activity to prevent it from staying in the backstack
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: handle when no item is selected
            }
        }

        // Set up button click listeners
        logo.setOnClickListener {
            startActivity(Intent(this@Childminding, Mainscreen::class.java))
            finish()
        }

        back.setOnClickListener {
            startActivity(Intent(this@Childminding, SixWeekCourses::class.java))
            finish()
        }

        next.setOnClickListener {
            startActivity(Intent(this@Childminding, Garden_maintenance::class.java))
            finish()
        }
    }
}
