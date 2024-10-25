package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SixWeekCourses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixweekcourses)

        // Handle edge-to-edge window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve UI elements
        val child = findViewById<ImageView>(R.id.childmindingImage)
        val garden = findViewById<ImageView>(R.id.gardeningImage)
        val cook = findViewById<ImageView>(R.id.cookingImage)

        // Setup for Spinner menu
        val index = arrayOf("Six month Courses", "Six week courses")
        val menu = findViewById<Spinner>(R.id.spinner2)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Listener for Spinner menu item selection
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            private var isFirstSelection = true  // Avoid triggering on initial setup

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirstSelection) {
                    isFirstSelection = false
                } else {
                    when (position) {
                        0 -> startActivity(Intent(this@SixWeekCourses, SixMonthCourses::class.java))
                        1 -> return // Already on SixWeekCourses, so no action needed
                    }
                    finish() // Close current activity after navigation
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }

        // Logo click to go back to the main screen
        val logo = findViewById<ImageView>(R.id.logo)
        logo.setOnClickListener {
            startActivity(Intent(this@SixWeekCourses, Mainscreen::class.java))
            finish()
        }

        // Course image click listeners
        child.setOnClickListener {
            startActivity(Intent(this@SixWeekCourses, Childminding::class.java))
            finish()
        }

        garden.setOnClickListener {
            startActivity(Intent(this@SixWeekCourses, Garden_maintenance::class.java))
            finish()
        }

        cook.setOnClickListener {
            startActivity(Intent(this@SixWeekCourses, Cooking::class.java))
            finish()
        }
    }
}
