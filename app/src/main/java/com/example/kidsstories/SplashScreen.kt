package com.example.kidsstories

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 8000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Delay for SPLASH_TIME_OUT milliseconds and then start the main activity
        Handler().postDelayed({
            startActivity(Intent(this, intro_screen1::class.java))
            finish()
        }, SPLASH_TIME_OUT)

        val videoView: VideoView = findViewById(R.id.videoView)
        val videoUri: Uri = Uri.parse("https://i.imgur.com/ughSYiQ.mp4")

        videoView.setVideoURI(videoUri)
        videoView.setOnPreparedListener { mediaPlayer: MediaPlayer ->
            videoView.background = null // Remove the placeholder background
            videoView.start()
        }
        videoView.setOnErrorListener { mp, what, extra ->
            // Handle error
            true
        }
        videoView.requestFocus()
    }
}