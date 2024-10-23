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

class sixmonthcourses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixmonthcourses)

        val index = arrayOf("Home", "Six month Courses", "Six week courses")
        val first = findViewById<ImageView>(R.id.imageView5)
        val sewing = findViewById<ImageView>(R.id.imageView6)
        val life = findViewById<ImageView>(R.id.imageView7)
        val land = findViewById<ImageView>(R.id.imageView8)

        val menu = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when (position) {
                    1 -> {
                        val intent = Intent(this@sixmonthcourses, Mainscreen::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@sixmonthcourses, sixmonthcourses::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(this@sixmonthcourses, sixweekcourses::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val logo = findViewById<ImageView>(R.id.imageView3)
        logo.setOnClickListener {
            val intent = Intent(this@sixmonthcourses, Mainscreen::class.java)
            startActivity(intent)
        }

        first.setOnClickListener {
            val intent = Intent(this@sixmonthcourses, Firstaid::class.java)
            startActivity(intent)
        }

        sewing.setOnClickListener {
            val intent = Intent(this@sixmonthcourses, Sewing::class.java)
            startActivity(intent)
        }

        life.setOnClickListener {
            val intent = Intent(this@sixmonthcourses, LifeSkills::class.java)
            startActivity(intent)
        }

        land.setOnClickListener {
            val intent = Intent(this@sixmonthcourses, Landscaping::class.java)
            startActivity(intent)
        }
    }
}