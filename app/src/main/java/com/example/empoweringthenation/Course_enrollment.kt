package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class CourseEnrollment : AppCompatActivity() {

    private var total: Double = 0.0
    private val course1Price = 1500.00
    private val course2Price = 750.00
    private val selectedCourses = ArrayList<String>()

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
        val confirm = findViewById<Button>(R.id.button17)
        val logo = findViewById<ImageView>(R.id.imageView25)
        val price: TextView = findViewById(R.id.textView42)

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkBox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkBox6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkBox7 = findViewById<CheckBox>(R.id.checkBox7)

        val menu = findViewById<Spinner>(R.id.spinner10)

        // Initialize and set up the dropdown menu (Spinner)
        val index = arrayOf("Home", "Six month Courses", "Six week courses")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, index)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menu.adapter = adapter

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> startActivity(Intent(this@CourseEnrollment, Mainscreen::class.java))
                    1 -> startActivity(Intent(this@CourseEnrollment, SixMonthCourses::class.java))
                    2 -> startActivity(Intent(this@CourseEnrollment, SixWeekCourses::class.java))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Set logo click listener to go back to the main screen
        logo.setOnClickListener {
            val intent = Intent(this@CourseEnrollment, Mainscreen::class.java)
            startActivity(intent)
        }

        // Checkbox listeners to update the total price and selected courses
        fun updateCheckbox(checkBox: CheckBox, coursePrice: Double, courseName: String) {
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    total += coursePrice
                    selectedCourses.add(courseName)
                } else {
                    total -= coursePrice
                    selectedCourses.remove(courseName)
                }
                updateTotalWithVat(price)
            }
        }

        updateCheckbox(checkBox1, course1Price, "First Aid")
        updateCheckbox(checkBox2, course1Price, "Sewing")
        updateCheckbox(checkBox3, course1Price, "Landscaping")
        updateCheckbox(checkBox4, course1Price, "Life Skills")
        updateCheckbox(checkBox5, course2Price, "Childminding")
        updateCheckbox(checkBox6, course2Price, "Cooking")
        updateCheckbox(checkBox7, course2Price, "Garden Maintenance")

        // Confirm button listener to pass data to the next activity
        confirm.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val address = addressInput.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.PHONE.matcher(phone).matches()) {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (total == 0.0) {
                Toast.makeText(this, "Please select at least one course", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculate total with VAT
            val totalWithVAT = total + (total * 0.15)

            // Pass data to the next activity
            val intent = Intent(this@CourseEnrollment, ViewDetailsActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("phone", phone)
            intent.putExtra("email", email)
            intent.putExtra("address", address)
            intent.putExtra("totalPrice", totalWithVAT)
            intent.putStringArrayListExtra("selectedCourses", selectedCourses)

            startActivity(intent)
        }
    }

    // Method to calculate and update total price with VAT
    private fun updateTotalWithVat(priceTextView: TextView) {
        val totalWithVat = total + (total * 0.15)
        priceTextView.text = String.format("Total: R%.2f", totalWithVat)
    }
}
