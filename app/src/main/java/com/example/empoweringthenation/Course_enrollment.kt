package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class CourseEnrollment : AppCompatActivity() {

    // Declare total and course prices
    private var total: Double = 0.0
    private val course1Price = 1500.00
    private val course2Price = 1500.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_course_enrollment)

        // Handle edge-to-edge window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve UI elements
        val nameInput = findViewById<TextInputEditText>(R.id.Name)
        val phoneInput = findViewById<TextInputEditText>(R.id.Number)
        val emailInput = findViewById<TextInputEditText>(R.id.Email)
        val addressInput = findViewById<TextInputEditText>(R.id.Address)

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkBox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkBox6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkBox7 = findViewById<CheckBox>(R.id.checkBox7)

        val confirm = findViewById<Button>(R.id.button17)
        val logo = findViewById<ImageView>(R.id.imageView25)
        val price: TextView = findViewById(R.id.textView42)

        // Set logo click listener to go back to the main screen
        logo.setOnClickListener {
            val intent = Intent(this@CourseEnrollment, Mainscreen::class.java)
            startActivity(intent)
        }

        // Checkbox listeners to update the total price
        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += course1Price
            } else {
                total -= course1Price
            }
            updateTotalWithVat(price)
        }

        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += course1Price
            } else {
                total -= course1Price
            }
            updateTotalWithVat(price)
        }

        checkBox3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += course1Price
            } else {
                total -= course1Price
            }
            updateTotalWithVat(price)
        }

        checkBox4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += course1Price
            } else {
                total -= course1Price
            }
            updateTotalWithVat(price)
        }

        checkBox5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += course2Price
            } else {
                total -= course2Price
            }
            updateTotalWithVat(price)
        }

        checkBox6.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += course2Price
            } else {
                total -= course2Price
            }
            updateTotalWithVat(price)
        }

        checkBox7.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += course2Price
            } else {
                total -= course2Price
            }
            updateTotalWithVat(price)
        }

        // Confirm button listener to pass data to the next activity
        confirm.setOnClickListener {
            val intent = Intent(this@CourseEnrollment, ViewDetailsActivity::class.java)

            // Retrieve user input data
            val name = nameInput.text.toString()
            val phone = phoneInput.text.toString()
            val email = emailInput.text.toString()
            val address = addressInput.text.toString()
            val totalWithVAT = total + (total * 0.15)

            // Pass data to the next activity
            intent.putExtra("name", name)
            intent.putExtra("phone", phone)
            intent.putExtra("email", email)
            intent.putExtra("address", address)
            intent.putExtra("totalPrice", totalWithVAT)

            startActivity(intent)
        }
    }

    // Method to calculate and update total price with VAT
    private fun updateTotalWithVat(priceTextView: TextView) {
        val totalWithVat = total + (total * 0.15)
        priceTextView.text = String.format("Total: R%.2f", totalWithVat)
    }
}
