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

class Cooking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cooking)

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve UI elements
        val logo = findViewById<ImageView>(R.id.imageView21)
        val back = findViewById<Button>(R.id.button13)
        val enroll = findViewById<Button>(R.id.button14)
        val menu = findViewById<Spinner>(R.id.spinner8)

        // Initialize and set up the dropdown menu (Spinner)
        val index = arrayOf("Home", "Six month Courses", "Six week courses", "Childminding", "Garden Maintenance")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> startActivity(Intent(this@Cooking, Mainscreen::class.java))
                    1 -> startActivity(Intent(this@Cooking, SixMonthCourses::class.java))
                    2 -> startActivity(Intent(this@Cooking, SixWeekCourses::class.java))
                    3 -> startActivity(Intent(this@Cooking, Childminding::class.java))
                    4 -> startActivity(Intent(this@Cooking, Garden_maintenance::class.java))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }

        // Logo click listener
        logo.setOnClickListener {
            startActivity(Intent(this@Cooking, Mainscreen::class.java))
        }

        // Back button click listener
        back.setOnClickListener {
            startActivity(Intent(this@Cooking, SixWeekCourses::class.java))
        }

        // Enroll button click listener
        enroll.setOnClickListener {
            startActivity(Intent(this@Cooking, CourseEnrollment::class.java))
        }
    }
}
