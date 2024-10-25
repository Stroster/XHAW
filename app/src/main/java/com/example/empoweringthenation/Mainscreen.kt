package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Mainscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainscreen)

        val contact = findViewById<Button>(R.id.button22)
        val sixmonthcoursesbutton = findViewById<Button>(R.id.button2)

        sixmonthcoursesbutton.setOnClickListener{
            val intent = Intent(this, SixMonthCourses::class.java)
            startActivity(intent)
        }


        val sixweekcoursesbutton = findViewById<Button>(R.id.button)

        sixweekcoursesbutton.setOnClickListener{
            val intent = Intent(this, SixWeekCourses::class.java)
            startActivity(intent)
        }

        contact.setOnClickListener {
            val intent = Intent(this@Mainscreen, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}