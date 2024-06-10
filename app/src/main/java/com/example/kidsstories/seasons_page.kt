package com.example.kidsstories

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class seasons_page : AppCompatActivity() {

    private lateinit var flashcard1: FrameLayout
    private lateinit var flashcard2: FrameLayout
    private lateinit var flashcard3: FrameLayout
    private lateinit var flashcard4: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seasons_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val back: ImageButton = findViewById(R.id.goback)

        back.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            startActivity(intent)
        }

        flashcard1 = findViewById(R.id.flashcard1)
        flashcard2 = findViewById(R.id.flashcard2)
        flashcard3 = findViewById(R.id.flashcard3)
        flashcard4 = findViewById(R.id.flashcard4)

        setupCardFlip(findViewById(R.id.flashcard1), R.drawable.spring, "Spring", R.drawable.springstuff)
        setupCardFlip(findViewById(R.id.flashcard2), R.drawable.summer, "Summer", R.drawable.summerstuff)
        setupCardFlip(findViewById(R.id.flashcard3), R.drawable.autumn, "Autumn", R.drawable.autumnstuff)
        setupCardFlip(findViewById(R.id.flashcard4), R.drawable.winter, "Winter", R.drawable.winterstuff)
    }

    private fun setupCardFlip(flashcard: FrameLayout, frontImageRes: Int, frontText: String, backImageRes: Int) {
        val front = flashcard.findViewById<View>(R.id.front)
        val back = flashcard.findViewById<View>(R.id.back)

        val frontImageView = front.findViewById<ImageView>(R.id.frontImage)
        val backImageView = back.findViewById<ImageView>(R.id.backImage)

        frontImageView.setImageResource(frontImageRes)
        backImageView.setImageResource(backImageRes)

        val scale = applicationContext.resources.displayMetrics.density
        front.cameraDistance = 8000 * scale
        back.cameraDistance = 8000 * scale

        val flipOutAnimator = AnimatorInflater.loadAnimator(applicationContext, R.animator.flip_out) as AnimatorSet
        val flipInAnimator = AnimatorInflater.loadAnimator(applicationContext, R.animator.flip_in) as AnimatorSet

        flashcard.setOnClickListener {
            if (front.visibility == View.VISIBLE) {
                flipOutAnimator.setTarget(front)
                flipInAnimator.setTarget(back)
                flipOutAnimator.start()
                flipInAnimator.start()
                front.visibility = View.GONE
                back.visibility = View.VISIBLE
            } else {
                flipOutAnimator.setTarget(back)
                flipInAnimator.setTarget(front)
                flipOutAnimator.start()
                flipInAnimator.start()
                back.visibility = View.GONE
                front.visibility = View.VISIBLE
            }
        }
    }
}