package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Garden_maintenance : AppCompatActivity() {
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
        val enroll = findViewById<Button>(R.id.button16)

        logo.setOnClickListener {
            val intent = Intent(this@Garden_maintenance, Mainscreen::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this@Garden_maintenance, sixweekcourses::class.java)
            startActivity(intent)
        }

        enroll.setOnClickListener {
            val intent = Intent(this@Garden_maintenance, Course_enrollment::class.java)
            startActivity(intent)
        }
    }
}