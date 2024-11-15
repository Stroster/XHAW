package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class CourseEnrollment : AppCompatActivity() {

    private var total: Double = 0.0
    private val course1Price = 1500.00
    private val course2Price = 750.00
    private val selectedCourses = ArrayList<String>()
    private var isFirstSelection = true // Flag to prevent initial selection trigger

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
                if (isFirstSelection) {
                    isFirstSelection = false // Prevent action on the first selection
                } else {
                    when (position) {
                        0 -> {
                            startActivity(Intent(this@CourseEnrollment, Mainscreen::class.java))
                            finish() // Finish current activity
                        }
                        1 -> {
                            startActivity(Intent(this@CourseEnrollment, SixMonthCourses::class.java))
                            finish() // Finish current activity
                        }
                        2 -> {
                            startActivity(Intent(this@CourseEnrollment, SixWeekCourses::class.java))
                            finish() // Finish current activity
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Set logo click listener to go back to the main screen
        logo.setOnClickListener {
            startActivity(Intent(this@CourseEnrollment, Mainscreen::class.java))
            finish() // Finish current activity
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
                updateTotalWithVatAndDiscount(price)
            }
        }

        updateCheckbox(checkBox1, course1Price, "First Aid")
        updateCheckbox(checkBox2, course1Price, "Sewing")
        updateCheckbox(checkBox3, course1Price, "Landscaping")
        updateCheckbox(checkBox4, course1Price, "Life Skills")
        updateCheckbox(checkBox5, course2Price, "Childminding")
        updateCheckbox(checkBox6, course2Price, "Cooking")
        updateCheckbox(checkBox7, course2Price, "Garden Maintenance")

        // Confirm button listener to validate input and display the total with VAT and discount
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

            // Calculate total with VAT and discount
            val totalWithVAT = calculateTotalWithDiscountAndVat()

            // Display a success message using AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Application Successful")
            builder.setMessage("Your application has been successfully submitted.\nTotal with VAT and discount: R%.2f".format(totalWithVAT))
            builder.setPositiveButton("OK") { _, _ ->
                // Navigate back to the home screen
                startActivity(Intent(this@CourseEnrollment, Mainscreen::class.java))
                finish() // Finish current activity to prevent returning back to this page
            }
            builder.show()
        }
    }

    // Method to calculate and update total price with VAT and applicable discounts
    private fun updateTotalWithVatAndDiscount(priceTextView: TextView) {
        val totalWithVat = calculateTotalWithDiscountAndVat()
        priceTextView.text = String.format("Total: R%.2f", totalWithVat)
    }

    private fun calculateTotalWithDiscountAndVat(): Double {
        val discount = when (selectedCourses.size) {
            2 -> 0.05 // 5% discount for two courses
            3 -> 0.10 // 10% discount for three courses
            in 4..Int.MAX_VALUE -> 0.15
            else -> 0.0
        }

        val discountedTotal = total - (total * discount)
        return discountedTotal + (discountedTotal * 0.15) // Add VAT (15%)
    }
}
