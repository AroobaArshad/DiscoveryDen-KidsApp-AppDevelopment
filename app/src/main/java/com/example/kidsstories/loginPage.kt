package com.example.kidsstories

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val nextButton = findViewById<ImageButton>(R.id.nextButton)

        nextButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if either of the fields is empty
            if (name.isEmpty() || password.isEmpty()) {
                // Show toast message if any of the fields is empty
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("USER_NAME", name)
                editor.putString("USER_PASSWORD", password)
                editor.apply()
                val intent = Intent(this, AvatarSelectionActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            }
        }
    }
}
