package com.example.kidsstories

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class storiesDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stories_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val redRiding: ImageView = findViewById(R.id.redRiding)
        val duckling: ImageView = findViewById(R.id.duckling)
        val goldilocks: ImageView = findViewById(R.id.goldilocks)
        val jack: ImageView = findViewById(R.id.jack)
        val snowwhite: ImageView = findViewById(R.id.snowwhite)
        val elves: ImageView = findViewById(R.id.elves)
        val back: ImageButton = findViewById(R.id.goback)


        back.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            startActivity(intent)
        }

        redRiding.setOnClickListener {
            val intent = Intent(this, redridinghood::class.java)
            startActivity(intent)
        }

        duckling.setOnClickListener {
            val intent = Intent(this, uglyduckling::class.java)
            startActivity(intent)
        }

        goldilocks.setOnClickListener {
            val intent = Intent(this, goldilocks_and_three_bears::class.java)
            startActivity(intent)
        }

        jack.setOnClickListener {
            val intent = Intent(this, jack_and_the_beanstalk::class.java)
            startActivity(intent)
        }

        snowwhite.setOnClickListener {
            val intent = Intent(this, snow_white::class.java)
            startActivity(intent)
        }

        elves.setOnClickListener {
            val intent = Intent(this, elves_and_the_shoemaker::class.java)
            startActivity(intent)
        }
    }
}