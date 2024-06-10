package com.example.kidsstories

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainScreenActivity : AppCompatActivity() {

    private lateinit var profileLayout: View
    private lateinit var menuButton: ImageButton
    private lateinit var closeProfileButton: ImageButton
    private var isProfileVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        profileLayout = findViewById(R.id.profileLayout)
        menuButton = findViewById(R.id.menuButton)
        closeProfileButton = findViewById(R.id.closeProfileButton)

        val welcomeMessageTextView = findViewById<TextView>(R.id.welcomeMessage)
        val selectedAvatarImageView = findViewById<ImageView>(R.id.selectedAvatar)

        val sharedPreferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE)
        val userName = sharedPreferences.getString("USER_NAME", "User")
        val userPassword = sharedPreferences.getString("USER_PASSWORD", "Password")
        val selectedAvatarResId = sharedPreferences.getInt("SELECTED_AVATAR", R.drawable.avatarone)

        welcomeMessageTextView.text = ", $userName"
        selectedAvatarImageView.setImageResource(selectedAvatarResId)

        val userNameTextView = findViewById<TextView>(R.id.userNameTextView)
        val userAvatarImageView = findViewById<ImageView>(R.id.userAvatar)
        val userPasswordTextView = findViewById<TextView>(R.id.userPasswordTextView)

        userNameTextView.text = userName
        userAvatarImageView.setImageResource(selectedAvatarResId)
        userPasswordTextView.text = userPassword

        menuButton.setOnClickListener {
            Log.d("MainScreenActivity", "Menu button clicked")
            toggleProfileVisibility()
        }

        closeProfileButton.setOnClickListener {
            Log.d("MainScreenActivity", "Close profile button clicked")
            toggleProfileVisibility()
        }


        val storiesBtn: ImageView = findViewById(R.id.storiesPage)
        val alphabetsBtn: ImageView = findViewById(R.id.alphabetsPage)
        val numbersBtn: ImageView = findViewById(R.id.numbersPage)
        val shapesBtn: ImageView = findViewById(R.id.shapesPage)
        val seasonsBtn: ImageView = findViewById(R.id.seasonsPage)
        val animalsBtn: ImageView = findViewById(R.id.animalsPage)

        storiesBtn.setOnClickListener {
            val intent = Intent(this, storiesDisplay::class.java)
            startActivity(intent)
        }

        alphabetsBtn.setOnClickListener {
            val intent = Intent(this, alphabets_page::class.java)
            startActivity(intent)
        }

        numbersBtn.setOnClickListener {
            val intent = Intent(this, numbers_page::class.java)
            startActivity(intent)
        }

        shapesBtn.setOnClickListener {
            val intent = Intent(this, shapes_page::class.java)
            startActivity(intent)
        }

        seasonsBtn.setOnClickListener {
            val intent = Intent(this, seasons_page::class.java)
            startActivity(intent)
        }

        animalsBtn.setOnClickListener {
            val intent = Intent(this, animals_page::class.java)
            startActivity(intent)
        }
    }

    private fun toggleProfileVisibility() {
        Log.d("MainScreenActivity", "Toggling profile visibility")
        val translateAnimation: TranslateAnimation
        val displayMetrics = resources.displayMetrics
        val translationValue = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300f, displayMetrics)

        if (isProfileVisible) {
            translateAnimation = TranslateAnimation(0f, -translationValue, 0f, 0f)
            translateAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {
                    profileLayout.visibility = View.GONE
                    Log.d("MainScreenActivity", "Profile layout hidden")
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        } else {
            profileLayout.visibility = View.VISIBLE
            translateAnimation = TranslateAnimation(-translationValue, 0f, 0f, 0f)
        }
        translateAnimation.duration = 800
        profileLayout.startAnimation(translateAnimation)
        isProfileVisible = !isProfileVisible
        Log.d("MainScreenActivity", "Profile visibility toggled: $isProfileVisible")
    }

    fun showInstructionsPopup(view: View) {
        val popupView = layoutInflater.inflate(R.layout.instructions_popup, null)

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
