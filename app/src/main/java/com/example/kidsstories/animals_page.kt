package com.example.kidsstories

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class animals_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animals_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val animalImages = arrayOf(
            R.id.lion, R.id.penguin, R.id.rabbit, R.id.cat, R.id.dog, R.id.turtle, R.id.monkey, R.id.elephant
        )

        var isLeft = true
        for (imageId in animalImages) {
            val imageView = findViewById<ImageView>(imageId)
            animateImage(imageView, isLeft)
            isLeft = !isLeft
        }

        val back: ImageButton = findViewById(R.id.goback)

        back.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            startActivity(intent)
        }

        val lionImage = findViewById<ImageView>(R.id.lion)
        lionImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.lion_info)
        }

        val penguinImage = findViewById<ImageView>(R.id.penguin)
        penguinImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.penguin_info)
        }

        val rabbitImage = findViewById<ImageView>(R.id.rabbit)
        rabbitImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.rabbit_info)
        }

        val catImage = findViewById<ImageView>(R.id.cat)
        catImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.cat_info)
        }

        val dogImage = findViewById<ImageView>(R.id.dog)
        dogImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.dog_info)
        }

        val turtleImage = findViewById<ImageView>(R.id.turtle)
        turtleImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.turtle_info)
        }

        val monkeyImage = findViewById<ImageView>(R.id.monkey)
        monkeyImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.monkey_info)
        }

        val elephantImage = findViewById<ImageView>(R.id.elephant)
        elephantImage.setOnClickListener {
            showAnimalPopup(it, R.drawable.elephant_info)
        }
    }

    private fun animateImage(imageView: ImageView, isLeft: Boolean) {
        val screenWidth = resources.displayMetrics.widthPixels
        val animation = TranslateAnimation(
            if (isLeft) -screenWidth.toFloat() else screenWidth.toFloat(), 0f, 0f, 0f
        ).apply {
            duration = 1000
        }
        imageView.startAnimation(animation)
    }

    fun showAnimalPopup(view: View, animalImageResId: Int) {
        val popupView = layoutInflater.inflate(R.layout.animal_popup_layout, null)
        val popupImage = popupView.findViewById<ImageView>(R.id.popupImage)
        popupImage.setImageResource(animalImageResId)

        // Define the width and height of the popup window programmatically
        val width = 850 // in pixels
        val height = 1500 // in pixels

        val popupWindow = PopupWindow(
            popupView,
            width,
            height,
            true
        )

        // Prevent the popup from closing when the user taps outside
        popupWindow.isOutsideTouchable = false

        val closeButton = popupView.findViewById<ImageButton>(R.id.closeButton)
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }
}