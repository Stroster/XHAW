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
        val logo = findViewById<ImageView>(R.id.imageView3)

        // Initialize and set up the Spinner
        val menu = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        val back = findViewById<Button>(R.id.button21)
        val enroll = findViewById<Button>(R.id.button23)

        // Spinner listener with initial selection check
        var isFirstSelection = true
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirstSelection) {
                    isFirstSelection = false
                } else {
                    when (position) {
                        1 -> {  // Navigate to SixWeekCourses when "Six week courses" is selected
                            val intent = Intent(this@SixMonthCourses, SixWeekCourses::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }

        // Logo click to go back to the main screen
        logo.setOnClickListener {
            val intent = Intent(this@SixMonthCourses, Mainscreen::class.java)
            startActivity(intent)
            finish()
        }

        // Course image click listeners
        first.setOnClickListener {
            startActivity(Intent(this@SixMonthCourses, Firstaid::class.java))
            finish()
        }

        sewing.setOnClickListener {
            startActivity(Intent(this@SixMonthCourses, Sewing::class.java))
            finish()
        }

        life.setOnClickListener {
            startActivity(Intent(this@SixMonthCourses, LifeSkills::class.java))
            finish()
        }

        land.setOnClickListener {
            startActivity(Intent(this@SixMonthCourses, Landscaping::class.java))
            finish()
        }

        back.setOnClickListener {
            startActivity(Intent(this@SixMonthCourses, Mainscreen::class.java))
            finish()
        }

        enroll.setOnClickListener {
            startActivity(Intent(this@SixMonthCourses, CourseEnrollment::class.java))
            finish()
        }
    }
}
