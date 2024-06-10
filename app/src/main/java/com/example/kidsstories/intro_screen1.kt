package com.example.kidsstories

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class intro_screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro_screen1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextButton: ImageButton = findViewById(R.id.nextBtn)
        nextButton.setOnClickListener {
            val intent = Intent(this, intro_screen2::class.java)
            startActivity(intent)
        }

        val skipButton: ImageButton = findViewById(R.id.skipBtn)
        skipButton.setOnClickListener {
            val intent = Intent(this, loginPage::class.java)
            startActivity(intent)
        }
    }
}