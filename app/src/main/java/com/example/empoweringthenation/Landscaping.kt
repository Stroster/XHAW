package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        logo.setOnClickListener {
            val intent = Intent(this@Landscaping, Mainscreen::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this@Landscaping, sixmonthcourses::class.java)
            startActivity(intent)
        }

        next.setOnClickListener {
            val intent = Intent(this@Landscaping, Course_enrollment::class.java)
            startActivity(intent)
        }
    }
}