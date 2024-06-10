package com.example.kidsstories

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class uglyduckling : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var scrollView: ScrollView
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var textView8: TextView
    private lateinit var textView9: TextView
    private lateinit var textView10: TextView
    private lateinit var playButton: ImageButton
    private lateinit var stopButton: Button

    private var isPaused = false // Flag to track whether audio playback is paused
    private var playbackPosition = 0 // Variable to store playback position when pausing
    private var isPlaying = false // Flag to track the current state of the media player

    private val textChunks = listOf(
        "A little duckling was very sad because he thought he was the ugliest amongst all his brothers and sisters. They would not play with him and teased the poor ugly duckling.",
        "One day he saw his reflection in the water and cried, 'Nobody likes me! I am so ugly!' He decided to leave home and went far away into the woods.\\n",
        "Deep in the forest he saw a cottage in which there lived an old woman, her hen, and her cat.\\n",
        "The duckling stayed with them for some time, but he was unhappy there and soon left. When winter set in, the poor duckling almost froze to death.\\n",
        "A peasant took him home to his wife and children.\\n",
        "The poor duckling was terrified of the children and escaped. The ugly duckling spent the winter in a marshy pond.\\n",
        "Finally, spring arrived. One day the duckling saw a beautiful swan swimming in the pond and fell in love with her. \\n",
        "But then he remembered how everyone made fun of him and he bent his head down in shame.\\n",
        "When he saw his own reflection in the water, he was astonished. He was not an ugly duckling anymore, but a handsome young swan. Now he knew why he looked so different from his brothers and sisters.\\n\\n'They were ducklings, but I was a baby swan', he said to himself.\\n",
        "He married the beautiful swan and lived happily ever after.\\n\\n",
    )

    private val audioDurations = intArrayOf(8000, 8000, 4500, 6500, 2500, 4000, 5500, 6000, 9000, 6500)
    private val HIGHLIGHT_START_DELAY = 3000

    private var currentChunkIndex = 0
    private val handler = android.os.Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_uglyduckling)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val back: ImageButton = findViewById(R.id.goback)

        back.setOnClickListener {
            val intent = Intent(this, storiesDisplay::class.java)
            startActivity(intent)
        }

        val textView = findViewById<TextView>(R.id.textView43)
        val text = "The Ugly Duckling"
        val delayMillis: Long = 150 // Adjust the delay between characters if needed

        // Create a Handler to handle the delay
        val handler = Handler()

        // Start animating the text
        val characterAdder = object : Runnable {
            var index = 0
            override fun run() {
                textView.text = text.subSequence(0, index++)
                if (index <= text.length) {
                    handler.postDelayed(this, delayMillis)
                }
            }
        }

        // Start animation
        handler.postDelayed(characterAdder, delayMillis)

        // Initialize the views
        scrollView = findViewById(R.id.scrollView)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)
        textView8 = findViewById(R.id.textView8)
        textView9 = findViewById(R.id.textView9)
        textView10 = findViewById(R.id.textView10)
        playButton = findViewById(R.id.playbutton)
        stopButton = findViewById(R.id.stopbutton)

        // Set click listener for play button
        playButton.setOnClickListener {
            if (isPlaying) {
                pauseAudioPlayback() // Pause audio playback if it is playing
            } else {
                if (isPaused) {
                    resumeAudioPlayback() // Resume audio playback if it is paused
                } else {
                    startAudioPlayback() // Start audio playback if not already playing
                }
            }
        }

        // Set click listener for stop button
        stopButton.setOnClickListener {
            stopAudioPlayback() // Stop audio playback when the button is clicked
        }
    }

    private fun startAudioPlayback() {
        // Create or reset the media player
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, R.raw.uglyduckling)
        mediaPlayer?.seekTo(playbackPosition)
        mediaPlayer?.start()

        isPlaying = true
        isPaused = false

        // Start text highlighting after the initial delay
        handler.postDelayed({
            highlightText(currentChunkIndex)
        }, HIGHLIGHT_START_DELAY.toLong())

        // Update the play button image resource
        playButton.setImageResource(R.drawable.ducklingpausebutton)

        mediaPlayer?.setOnCompletionListener {
            stopAudioPlayback()
        }
    }

    private fun pauseAudioPlayback() {
        mediaPlayer?.pause() // Pause audio playback
        isPlaying = false
        isPaused = true
        // Save the current playback position
        mediaPlayer?.currentPosition?.let {
            playbackPosition = it
        }

        // Update the play button image resource
        playButton.setImageResource(R.drawable.ugluduclingplaybutton)
        // Remove any pending highlighting tasks
        handler.removeCallbacksAndMessages(null)
    }

    private fun resumeAudioPlayback() {
        mediaPlayer?.start() // Resume audio playback
        isPlaying = true
        isPaused = false
        // Restart text highlighting if needed
        if (currentChunkIndex < textChunks.size) {
            highlightRemainingText(currentChunkIndex)
            val remainingDuration = audioDurations[currentChunkIndex] - playbackPosition
            // Schedule highlighting for the next text chunk after the remaining duration
            handler.postDelayed({ highlightText(currentChunkIndex + 1) }, remainingDuration.toLong())
        }

        // Update the play button image resource
        playButton.setImageResource(R.drawable.ducklingpausebutton)
    }

    private fun stopAudioPlayback() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying = false
        isPaused = false
        playbackPosition = 0
        currentChunkIndex = 0
        // Remove any pending highlighting tasks
        handler.removeCallbacksAndMessages(null)
    }


    private fun highlightRemainingText(index: Int) {
        if (index >= 0 && index < textChunks.size) {
            val text = textChunks[index]
            val remainingDuration = audioDurations[index] - playbackPosition

            // Calculate the total duration of the text from previous paragraphs
            val totalDurationOfPreviousParagraphs = audioDurations.sliceArray(0 until index).sum()

            // Calculate the remaining text index based on the total duration of previous paragraphs
            val remainingTextIndex = ((playbackPosition - totalDurationOfPreviousParagraphs).toFloat() / audioDurations[index] * text.length).toInt()

            val textColor = resources.getColor(R.color.highlightColorDuck) // Highlighted text color
            val normalColor = resources.getColor(android.R.color.black) // Normal text color

            // Highlight remaining text with remaining duration
            for (charIndex in remainingTextIndex until text.length) {
                handler.postDelayed({
                    when (index) {
                        0 -> textView1.highlightCharacter(charIndex, textColor, normalColor)
                        1 -> textView2.highlightCharacter(charIndex, textColor, normalColor)
                        2 -> textView3.highlightCharacter(charIndex, textColor, normalColor)
                        3 -> textView4.highlightCharacter(charIndex, textColor, normalColor)
                        4 -> textView5.highlightCharacter(charIndex, textColor, normalColor)
                        5 -> textView6.highlightCharacter(charIndex, textColor, normalColor)
                        6 -> textView7.highlightCharacter(charIndex, textColor, normalColor)
                        7 -> textView8.highlightCharacter(charIndex, textColor, normalColor)
                        8 -> textView9.highlightCharacter(charIndex, textColor, normalColor)
                        9 -> textView10.highlightCharacter(charIndex, textColor, normalColor)
                    }
                }, (remainingDuration.toFloat() / (text.length - remainingTextIndex) * (charIndex - remainingTextIndex)).toLong())
            }
        }
    }

    private fun highlightText(index: Int, startTime: Int = 0) {
        if (index >= 0 && index < textChunks.size) {
            val text = textChunks[index]
            val duration = audioDurations[index]

            val textColor = resources.getColor(R.color.highlightColorDuck) // Highlighted text color
            val normalColor = resources.getColor(android.R.color.black) // Normal text color

            var elapsedDuration = startTime // Variable to track the elapsed duration

            // Highlight each character sequentially with a delay
            text.forEachIndexed { charIndex, _ ->
                handler.postDelayed({
                    when (index) {
                        0 -> textView1.highlightCharacter(charIndex, textColor, normalColor)
                        1 -> textView2.highlightCharacter(charIndex, textColor, normalColor)
                        2 -> textView3.highlightCharacter(charIndex, textColor, normalColor)
                        3 -> textView4.highlightCharacter(charIndex, textColor, normalColor)
                        4 -> textView5.highlightCharacter(charIndex, textColor, normalColor)
                        5 -> textView6.highlightCharacter(charIndex, textColor, normalColor)
                        6 -> textView7.highlightCharacter(charIndex, textColor, normalColor)
                        7 -> textView8.highlightCharacter(charIndex, textColor, normalColor)
                        8 -> textView9.highlightCharacter(charIndex, textColor, normalColor)
                        9 -> textView10.highlightCharacter(charIndex, textColor, normalColor)
                    }
                }, elapsedDuration.toLong())

                // Update the elapsed duration
                elapsedDuration += (duration.toFloat() / text.length).toInt()
            }

            // Check if audio is paused before scheduling highlighting for the next text chunk
            if (!isPaused) {
                // Schedule highlighting for the next text chunk after the corresponding audio duration
                val nextStartTime = startTime + duration
                handler.postDelayed({ highlightText(index + 1, nextStartTime) }, duration.toLong())
            }
        }
    }

    override fun onStop() {
        super.onStop()
        stopAudioPlayback()
    }
}