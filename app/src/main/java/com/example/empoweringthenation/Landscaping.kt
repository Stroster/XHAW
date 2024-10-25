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

class Landscaping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landscaping)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val logo = findViewById<ImageView>(R.id.imageView15)
        val back = findViewById<Button>(R.id.button7)
        val next = findViewById<Button>(R.id.button8)
        val menu = findViewById<Spinner>(R.id.spinner5)

        // Initialize and set up the dropdown menu (Spinner)
        val index = arrayOf("Home", "Six month Courses", "Six week courses", "First Aid", "Sewing",
            "LifeSkills")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> startActivity(Intent(this@Landscaping, Mainscreen::class.java))
                    1 -> startActivity(Intent(this@Landscaping, SixMonthCourses::class.java))
                    2 -> startActivity(Intent(this@Landscaping, SixWeekCourses::class.java))
                    3 -> startActivity(Intent(this@Landscaping, Firstaid::class.java))
                    4 -> startActivity(Intent(this@Landscaping, Sewing::class.java))
                    5 -> startActivity(Intent(this@Landscaping, LifeSkills::class.java))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }

        logo.setOnClickListener {
            val intent = Intent(this@Landscaping, Mainscreen::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this@Landscaping, SixMonthCourses::class.java)
            startActivity(intent)
        }

        next.setOnClickListener {
            val intent = Intent(this@Landscaping, CourseEnrollment::class.java)
            startActivity(intent)
        }
    }
}