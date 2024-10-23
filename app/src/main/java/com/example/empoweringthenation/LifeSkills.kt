package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LifeSkills : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_skills)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logo = findViewById<ImageView>(R.id.imageView17)
        val back = findViewById<Button>(R.id.button9)
        val next = findViewById<Button>(R.id.button10)

        logo.setOnClickListener {
            val intent = Intent(this@LifeSkills, Mainscreen::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this@LifeSkills, sixmonthcourses::class.java)
            startActivity(intent)
        }

        next.setOnClickListener {
            val intent = Intent(this@LifeSkills, Landscaping::class.java)
            startActivity(intent)
        }
    }
}