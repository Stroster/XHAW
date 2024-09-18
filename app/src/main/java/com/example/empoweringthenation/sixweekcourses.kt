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

class sixweekcourses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixweekcourses)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val index = arrayOf("Home", "Six month Courses", "Six week courses")

        val menu = findViewById<Spinner>(R.id.spinner2)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    1 -> {
                        val intent = Intent(this@sixweekcourses, Mainscreen::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@sixweekcourses, sixmonthcourses::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(this@sixweekcourses, sixweekcourses::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val logo = findViewById<ImageView>(R.id.imageView2)
        logo.setOnClickListener {
            val intent = Intent(this@sixweekcourses, Mainscreen::class.java)
            startActivity(intent)
        }
    }
}