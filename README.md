# Empowering the Nation Android App – README

## Project Overview
The **Empowering the Nation** Android app is designed as a resourceful platform to facilitate domestic workers and gardeners in accessing and enrolling in skill-enhancing courses. This application provides an intuitive and user-friendly experience, ensuring individuals can learn and develop valuable skills for career advancement. The app integrates multiple features, such as course selection, fee calculation, and contact information for further assistance.

## Features
### 1. **Main Features:**
- **Home Screen**: A landing page that serves as the starting point for users to navigate the application.
- **Course Listings**: A comprehensive catalog of both six-month and six-week courses, including detailed descriptions and pricing.
- **Contact Page**: Lists the app's contact information with office locations across Bloemfontein, Cape Town, and Durban.
- **Enrollment Form**: Collects user details (name, phone number, email, address) for registration purposes.
- **Price Calculator**: Computes total fees with applicable VAT and discounts.

### 2. **Navigation:**
- **Dropdown Menu (Spinner)**: Users can easily navigate between main sections, including "Home," "Six Month Courses," and "Six Week Courses."
- **Navigation Buttons**: Quick access back to the main screen or course pages.

## Tech Stack
### **Front-End:**
- **Programming Language**: Kotlin
- **XML**: Used for designing user interfaces.

### **Back-End:**
- Kotlin code handles logic for navigating between screens, setting up UI components, and processing user input.

### **Design:**
- **Material Design Principles**: Ensures a clean, modern, and user-friendly experience.
- **Fonts**: `Poppins` for consistency and readability.
- **Colors**: A dark theme with primary colors that ensure high visibility and comfort during app usage.

## Directory Structure
```plaintext
EmpoweringTheNation/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/empoweringthenation/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── ContactDetails.kt
│   │   │   │   ├── SixMonthCourses.kt
│   │   │   │   └── SixWeekCourses.kt
│   │   │   │
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       │   ├── activity_contact_details.xml
│   │   │       │   ├── activity_main.xml
│   │   │       │   ├── activity_six_month_courses.xml
│   │   │       │   └── activity_six_week_courses.xml
│   │   │       │
│   │   │       ├── drawable/
│   │   │       │   └── your_logo.png
│   │   │       │
│   │   │       ├── values/
│   │   │       │   ├── strings.xml
│   │   │       │   └── colors.xml
│   │   │       └── font/
│   │   │           └── poppins_medium.ttf
│   │   │
│   │   └── AndroidManifest.xml
│   └── build.gradle
└── README.md
```

## User Guide
### **1. Home Screen:**
The main entry point of the app provides quick navigation options and access to essential features like course listings and the contact page.

### **2. Course Details:**
Users can browse through the six-month and six-week courses, each with:
- **Descriptions**
- **Pricing details**
- **Enrollment capabilities**

### **3. Contact Page:**
Displays the following office addresses:
- **Bloemfontein**: 61 Second Avenue, Westdene, Bloemfontein 9301, South Africa.
- **Cape Town**: 5 Silo Square, V&A Waterfront, Cape Town 8002, South Africa.
- **Durban**: 34 Richefond Circle, Ridgeside Office Park, Umhlanga Ridge, Durban 4319, South Africa.

### **4. Enrollment Form:**
Allows users to fill in their contact details for registration. The form passes user input to the next activity where the fee is displayed, inclusive of VAT and discounts.

## Code Snippets
### **ContactDetails Activity Code Example**
```kotlin
// Kotlin snippet for handling navigation in ContactDetails.kt
menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> startActivity(Intent(this@ContactDetails, Mainscreen::class.java))
            1 -> startActivity(Intent(this@ContactDetails, SixMonthCourses::class.java))
            2 -> startActivity(Intent(this@ContactDetails, SixWeekCourses::class.java))
        }
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {}
}
```

### **activity_contact_details.xml Snippet**
```xml
<TextView
    android:id="@+id/textViewBloemfontein"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:text="Bloemfontein: 61 Second Avenue, Westdene, Bloemfontein 9301, South Africa"
    android:textColor="@color/white"
/>
```

## Installation and Setup
1. **Clone the repository**:
   ```bash
   git clone https://github.com/username/EmpoweringTheNation.git
   ```
2. **Open the project in Android Studio**.
3. **Build and run** the project on an emulator or a physical device.

## Future Enhancements
- **Multilingual Support**: To cater to a broader audience.
- **Push Notifications**: For course updates and enrollment reminders.
- **Payment Integration**: Direct online payment for course registration.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

This README file provides comprehensive details on the application structure, features, and usage to guide contributors and users effectively.
