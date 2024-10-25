package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details)

        val logo = findViewById<ImageView>(R.id.imageView2)
        // Retrieve views
        val nameTextView = findViewById<TextView>(R.id.text_user_name)
        val phoneTextView = findViewById<TextView>(R.id.text_user_phone)
        val emailTextView = findViewById<TextView>(R.id.text_user_email)
        val addressTextView = findViewById<TextView>(R.id.text_user_address)
        val coursesTextView = findViewById<TextView>(R.id.text_courses_selected)
        val totalPriceTextView = findViewById<TextView>(R.id.text_total_price)

        // Retrieve passed data from intent
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")
        val address = intent.getStringExtra("address")
        val totalPrice = intent.getDoubleExtra("totalPrice", 0.0)
        val selectedCourses = intent.getStringArrayListExtra("selectedCourses")

        // Set the text for user details
        nameTextView.text = "Name: $name"
        phoneTextView.text = "Phone: $phone"
        emailTextView.text = "Email: $email"
        addressTextView.text = "Address: $address"

        // Set the text for courses and total price
        coursesTextView.text = selectedCourses?.joinToString("\n") ?: "No courses selected."
        totalPriceTextView.text = String.format("Total Price: R%.2f", totalPrice)

        logo.setOnClickListener {
            val intent = Intent(this@ViewDetailsActivity, Mainscreen::class.java)
            startActivity(intent)
        }
    }
}
