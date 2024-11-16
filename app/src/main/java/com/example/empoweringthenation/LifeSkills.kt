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

class LifeSkills : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_skills)

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI elements
        val logo = findViewById<ImageView>(R.id.imageView17)
        val back = findViewById<Button>(R.id.button9)
        val next = findViewById<Button>(R.id.button10)
        val menu = findViewById<Spinner>(R.id.spinner6)

        // Set up the dropdown menu (Spinner)
        val index = arrayOf("Home", "Six month Courses", "Six week courses", "First Aid", "Sewing", "Landscape", "View Details")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            private var isFirstSelection = true  // Prevent trigger on initial setup

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirstSelection) {
                    isFirstSelection = false
                } else {
                    when (position) {
                        0 -> startActivity(Intent(this@LifeSkills, Mainscreen::class.java))
                        1 -> startActivity(Intent(this@LifeSkills, SixMonthCourses::class.java))
                        2 -> startActivity(Intent(this@LifeSkills, SixWeekCourses::class.java))
                        3 -> startActivity(Intent(this@LifeSkills, Firstaid::class.java))
                        4 -> startActivity(Intent(this@LifeSkills, Sewing::class.java))
                        5 -> startActivity(Intent(this@LifeSkills, Landscaping::class.java))
                    }
                    finish()  // Close this activity after navigation
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle when no item is selected
            }
        }

        // Logo click to go back to the main screen
        logo.setOnClickListener {
            startActivity(Intent(this@LifeSkills, Mainscreen::class.java))
            finish()
        }

        // Back button to navigate to SixMonthCourses
        back.setOnClickListener {
            startActivity(Intent(this@LifeSkills, SixMonthCourses::class.java))
            finish()
        }

        // Next button to navigate to Landscaping
        next.setOnClickListener {
            startActivity(Intent(this@LifeSkills, Landscaping::class.java))
            finish()
        }
    }
}
