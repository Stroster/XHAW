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

class Firstaid : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_firstaid)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val back = findViewById<Button>(R.id.button3)
        val logo = findViewById<ImageView>(R.id.imageView10)
        val next = findViewById<Button>(R.id.button4)
        val menu = findViewById<Spinner>(R.id.spinner3)

        // Initialize and set up the dropdown menu (Spinner)
        val index = arrayOf("Home", "Six month Courses", "Six week courses", "Sewing", "Landscape",
            "LifeSkills")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> startActivity(Intent(this@Firstaid, Mainscreen::class.java))
                    1 -> startActivity(Intent(this@Firstaid, SixMonthCourses::class.java))
                    2 -> startActivity(Intent(this@Firstaid, SixWeekCourses::class.java))
                    3 -> startActivity(Intent(this@Firstaid, Sewing::class.java))
                    4 -> startActivity(Intent(this@Firstaid, Landscaping::class.java))
                    5 -> startActivity(Intent(this@Firstaid, LifeSkills::class.java))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }


        logo.setOnClickListener {
            val intent = Intent(this@Firstaid, Mainscreen::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this@Firstaid, SixMonthCourses::class.java)
            startActivity(intent)
        }
        next.setOnClickListener {
            val intent = Intent(this@Firstaid, Sewing::class.java)
            startActivity(intent)
        }
    }
}