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

class ContactDetails : AppCompatActivity() {
    private var isFirstSelection = true // Flag to prevent initial selection trigger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logo = findViewById<ImageView>(R.id.imageViewLogo)
        val back = findViewById<Button>(R.id.buttonBack)
        val menu = findViewById<Spinner>(R.id.spinnerMenu)

        // Initialize and set up the dropdown menu (Spinner)
        val index = arrayOf("Home", "Six month Courses", "Six week courses")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirstSelection) {
                    isFirstSelection = false // Prevent action on the first selection
                } else {
                    when (position) {
                        0 -> {
                            startActivity(Intent(this@ContactDetails, Mainscreen::class.java))
                            finish() // Finish current activity
                        }
                        1 -> {
                            startActivity(Intent(this@ContactDetails, SixMonthCourses::class.java))
                            finish() // Finish current activity
                        }
                        2 -> {
                            startActivity(Intent(this@ContactDetails, SixWeekCourses::class.java))
                            finish() // Finish current activity
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: Handle case where no item is selected
            }
        }

        logo.setOnClickListener {
            startActivity(Intent(this@ContactDetails, Mainscreen::class.java))
            finish() // Finish current activity
        }

        back.setOnClickListener {
            startActivity(Intent(this@ContactDetails, Mainscreen::class.java))
            finish() // Finish current activity
        }
    }
}
