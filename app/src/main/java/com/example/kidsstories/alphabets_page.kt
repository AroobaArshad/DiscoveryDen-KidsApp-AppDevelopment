package com.example.kidsstories

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class alphabets_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alphabets_page)
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

        // Set click listeners for each ImageView
        val imageViews = arrayOf(
            findViewById<ImageView>(R.id.a),
            findViewById(R.id.b),
            findViewById(R.id.c),
            findViewById(R.id.d),
            findViewById(R.id.e),
            findViewById(R.id.f),
            findViewById(R.id.g),
            findViewById(R.id.h),
            findViewById(R.id.i),
            findViewById(R.id.j),
            findViewById(R.id.k),
            findViewById(R.id.l),
            findViewById(R.id.m),
            findViewById(R.id.n),
            findViewById(R.id.o),
            findViewById(R.id.p),
            findViewById(R.id.q),
            findViewById(R.id.r),
            findViewById(R.id.s),
            findViewById(R.id.t),
            findViewById(R.id.u),
            findViewById(R.id.v),
            findViewById(R.id.w),
            findViewById(R.id.x),
            findViewById(R.id.y),
            findViewById(R.id.z)
        )

        val rotateAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)

        for (imageView in imageViews) {
            imageView.setOnClickListener {
                it.startAnimation(rotateAnimation)
            }
        }
    }
}

