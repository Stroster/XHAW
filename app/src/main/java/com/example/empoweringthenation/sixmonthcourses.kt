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

class SixMonthCourses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixmonthcourses)

        val index = arrayOf("Six month Courses", "Six week courses")
        val first = findViewById<ImageView>(R.id.imageView5)
        val sewing = findViewById<ImageView>(R.id.imageView6)
        val life = findViewById<ImageView>(R.id.imageView7)
        val land = findViewById<ImageView>(R.id.imageView8)

        val menu = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    1 -> {  // Navigate to SixWeekCourses when "Six week courses" is selected
                        val intent = Intent(this@SixMonthCourses, SixWeekCourses::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }

        // Logo click to go back to the main screen
        val logo = findViewById<ImageView>(R.id.imageView3)
        logo.setOnClickListener {
            val intent = Intent(this@SixMonthCourses, Mainscreen::class.java)
            startActivity(intent)
        }

        // Course image click listeners
        first.setOnClickListener {
            val intent = Intent(this@SixMonthCourses, Firstaid::class.java)
            startActivity(intent)
        }

        sewing.setOnClickListener {
            val intent = Intent(this@SixMonthCourses, Sewing::class.java)
            startActivity(intent)
        }

        life.setOnClickListener {
            val intent = Intent(this@SixMonthCourses, LifeSkills::class.java)
            startActivity(intent)
        }

        land.setOnClickListener {
            val intent = Intent(this@SixMonthCourses, Landscaping::class.java)
            startActivity(intent)
        }
    }
}
