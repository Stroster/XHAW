package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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


        logo.setOnClickListener {
            val intent = Intent(this@Firstaid, Mainscreen::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this@Firstaid, sixmonthcourses::class.java)
            startActivity(intent)
        }
        next.setOnClickListener {
            val intent = Intent(this@Firstaid, Sewing::class.java)
            startActivity(intent)
        }
    }
}