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
        val index = arrayOf("Home", "Six month Courses", "Six week courses", "Cooking",
            "Garden Maintenance")
        val menu = findViewById<Spinner>(R.id.spinner7)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter  // Set adapter to the spinner

        // Set listener for item selection on Spinner
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Navigate based on selected item
                when (position) {
                    0 -> {
                        val intent = Intent(this@Childminding, Mainscreen::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(this@Childminding, SixMonthCourses::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@Childminding, SixWeekCourses::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(this@Childminding, Cooking::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(this@Childminding, Garden_maintenance::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: handle when no item is selected
            }
        }

        // Set up button click listeners
        logo.setOnClickListener {
            val intent = Intent(this@Childminding, Mainscreen::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this@Childminding, SixWeekCourses::class.java)
            startActivity(intent)
        }

        next.setOnClickListener {
            val intent = Intent(this@Childminding, Garden_maintenance::class.java)
            startActivity(intent)
        }
    }
}
