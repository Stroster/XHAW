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

class Garden_maintenance : AppCompatActivity() {

    private var isFirstTimeSelection = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_garden_maintenance)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logo = findViewById<ImageView>(R.id.imageView23)
        val back = findViewById<Button>(R.id.button15)
        val next = findViewById<Button>(R.id.button16)
        val menu = findViewById<Spinner>(R.id.spinner9)

        // Initialize and set up the dropdown menu (Spinner)
        val index = arrayOf("Home", "Six month Courses", "Six week courses", "Childminding", "Cooking")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirstTimeSelection) {
                    isFirstTimeSelection = false  // Prevent initial auto-navigation
                } else {
                    // Handle navigation based on selection
                    when (position) {
                        0 -> startActivity(Intent(this@Garden_maintenance, Mainscreen::class.java))
                        1 -> startActivity(Intent(this@Garden_maintenance, SixMonthCourses::class.java))
                        2 -> startActivity(Intent(this@Garden_maintenance, SixWeekCourses::class.java))
                        3 -> startActivity(Intent(this@Garden_maintenance, Childminding::class.java))
                        4 -> startActivity(Intent(this@Garden_maintenance, Cooking::class.java))
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }

        // Logo click to go back to the main screen
        logo.setOnClickListener {
            startActivity(Intent(this@Garden_maintenance, Mainscreen::class.java))
        }

        // Back and Next button click listeners
        back.setOnClickListener {
            startActivity(Intent(this@Garden_maintenance, SixWeekCourses::class.java))
        }

        next.setOnClickListener {
            startActivity(Intent(this@Garden_maintenance, Cooking::class.java))
        }
    }
}
