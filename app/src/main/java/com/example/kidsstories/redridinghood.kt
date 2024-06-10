package com.example.kidsstories

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class redridinghood : AppCompatActivity() {

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
    private lateinit var textView11: TextView
    private lateinit var textView12: TextView
    private lateinit var textView13: TextView
    private lateinit var textView14: TextView
    private lateinit var textView15: TextView
    private lateinit var textView16: TextView
    private lateinit var textView17: TextView
    private lateinit var textView18: TextView
    private lateinit var textView19: TextView
    private lateinit var textView20: TextView
    private lateinit var textView21: TextView
    private lateinit var textView22: TextView
    private lateinit var textView23: TextView
    private lateinit var textView24: TextView
    private lateinit var textView25: TextView
    private lateinit var textView26: TextView
    private lateinit var playButton: ImageButton
    private lateinit var stopButton: Button

    private var isPaused = false // Flag to track whether audio playback is paused
    private var playbackPosition = 0 // Variable to store playback position when pausing
    private var isPlaying = false // Flag to track the current state of the media player

    private val textChunks = listOf(
        "Once upon a time there lived a little girl. This girl wore a Red Riding Hood at all times. That's why everybody used to call her little Red Riding Hood.\\n'Darling'\\n'Yes, mummy.'",
        "'You know your grandmother is ill. Would you take her the cookies I baked and the fresh herbs I picked from the woods?'\\n\\n'Of course, mommy, I will.'\\n\\n The little girl with her Red Riding Hood, as always, started her journey to her grandmother's house. 'Do not leave the road in the bunny forest, sweetheart', said her mother as she was leaving. Little Red Riding Hood started walking in the forest while joyously singing songs.",
        "'I wonder why they call it the Bunny forest. I haven't seen any bunnies along the way.' Little Red Riding Hood came to a road filled with flowers. There were all kinds of coloured flowers. 'I should pick some flowers for my grandmother. She'll be very pleased.'\\nWell, little Red Riding Hood was picking the flowers. She did not realize that she was drifting away from her path.",
        "At that moment she heard a sound coming from the bushes. Suddenly a big bad wolf approached in front of her. Little Red Riding Hood was so scared that when she saw the wolf right in front of her eyes, she dropped the basket that she was carrying.",
        "The wolf jumped closer to her and collected the cookies she had dropped from the basket and gave them back to little Red Riding Hood. Little Red Riding Hood was amazed by this unexpected gesture from the wolf.",
        "'Thank you.'\\n'Where are you heading, little girl?'\\n\\n'To my grandmother's house, the yellow house at the end of this forest. She is not feeling well, so I'm bringing her cookies and healthy herb.'",
        "'Really?'\\n'By the way, you can call me little Red Riding Hood like everybody else does.'\\n'I'll head on first and let your grandmother know that you're on your way, so that you can continue picking up your beautiful flowers.'\\n\\nRight at that moment, he heard a gunshot of an approaching hunters rifle and ran away as fast as he could.",
        "Little Red Riding Hood looked around for a moment and started crying, realizing that she was lost.",
        "Hearing her crying, the hunter approached and came next to her.",
        "'What are you doing alone here, little girl? It's very dangerous around here. I'm looking for a big, bad wolf whom I've been hunting for a very long time.'\\nLittle Red Riding Hood was very ashamed because she had not listened to her mother and left the road in the bunny forest, so she could not tell the hunter that she had met the wolf.\\n'Um, well, I was bringing cookies to my ill grandmother living at the end of the forest, and I got lost.'\\n'Let me bring you to your grandma's home, then.'",
        "They started to walk together.",
        "And right then the wolf took a shortcut and quickly made it to the grandmother's house. He knocked on the door. The grandmother yelled from inside.\\n\\n'Who is it?'\\n\\nThe wolf changing his voice: 'It's me. Grandma. Little Red Riding Hood. I brought you cookies and fresh herbs from the woods.'",
        "'The door is open, my dear. You can come in.' The wolf smirked and stormed in through the open door.",
        "When a while later, a little Red Riding Hood in the Hunter arrived at the grandmother's house.",
        "'Go, little girl. Go next to your grandmother as soon as possible.'",
        "The hunter went back on his way. Little Red Riding Hood knocked on the door. Her grandmother yelled from inside.",
        "'Who is it?'\\n\\n'It's me. Grandma. Little Red Riding Hood.'\\n\\n'The door is open, my darling. You can come in.'\\n\\nLittle Red Riding Hood hesitated for a moment because the sound she heard did sound a little different than her grandmother. She then remembered that her grandmother was ill.",
        "'Grandmother probably sounds like that because she is ill.' Little Red Riding Hood opened the door and went in. The wolf, dressed in grandmother's clothing with her nightcap and her glasses, was lying in the bed. He also closed the drapes so that it became dark inside, and little Red Riding Hood could not recognize him.",
        "'I thank you, darling, for all your trouble getting all the way here to bring me food. Come next to me so I can give you a hug. Come on, darling. Come closer.'",
        "Little Red Riding Hood left the basket on the floor, but she did not get too close to the bed because her grandma looked different.",
        "'Why are your arms so long, grandma?'\\n\\n'So that I can hug you better.'\\n\\n'Hmm? Why are your ears so big?'\\n\\n'So that I can hear you better?'\\n\\n'But why are your eyes so huge?'\\n\\n'So that I can see you better?'\\n\\n'Why are your teeth so sharp, grandmother?'\\n\\n'So that I can eat you better. Hahahahahahaha!'",
        "The wolf jumped out of the bed and charged at the little Red Riding Hood. Ah! At that moment, little Red Riding Hood realized that it wasn't her grandmother lying in the bed, but instead the big bad wolf she had ran into along the way. The hunter heard little Red Riding Hood scream “Help me!” and ran straight to the house. Stormed into the open door and caught the wolf immediately.",
        "'I finally got you big bad wolf. Now you're in my hands.' The hunter cut the wolf's belly and rescued the grandmother.",
        "'Thank you for saving us, Mr. Hunter.'\\n\\nYou're welcome. But promise me, little girl, that you will never forget what your mother asks of you.'",
        "With great appetite, Grandmother ate all the cookies Little Red Riding Hood had brought for her. Boiled the healthy herbs to make a cup of tea and instantly got well.",
        "Little Red Riding Hood promised her grandmother that she will never, ever fall into the words of a bad wolf again."
    )

    private val audioDurations = intArrayOf(10200, 15000, 13000, 10000, 9000, 6300, 10300, 4000, 6000, 16500, 1500, 12000, 6000, 6000, 4000, 6000, 14000, 15000, 7000, 6000, 19000, 18000, 5000, 7000, 8000, 5000)
    private val HIGHLIGHT_START_DELAY = 5000

    private var currentChunkIndex = 0
    private val handler = android.os.Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_redridinghood)
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
        val text = "Little Red Riding Hood"
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
        textView11 = findViewById(R.id.textView11)
        textView12 = findViewById(R.id.textView12)
        textView13 = findViewById(R.id.textView13)
        textView14 = findViewById(R.id.textView14)
        textView15 = findViewById(R.id.textView15)
        textView16 = findViewById(R.id.textView16)
        textView17 = findViewById(R.id.textView17)
        textView18 = findViewById(R.id.textView18)
        textView19 = findViewById(R.id.textView19)
        textView20 = findViewById(R.id.textView20)
        textView21 = findViewById(R.id.textView21)
        textView22 = findViewById(R.id.textView22)
        textView23 = findViewById(R.id.textView23)
        textView24 = findViewById(R.id.textView24)
        textView25 = findViewById(R.id.textView25)
        textView26 = findViewById(R.id.textView26)
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
        mediaPlayer = MediaPlayer.create(this, R.raw.redriding)
        mediaPlayer?.seekTo(playbackPosition)
        mediaPlayer?.start()

        isPlaying = true
        isPaused = false

        // Start text highlighting after the initial delay
        handler.postDelayed({
            highlightText(currentChunkIndex)
        }, HIGHLIGHT_START_DELAY.toLong())

        // Update the play button image resource
        playButton.setImageResource(R.drawable.redridingpausebutton)

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
        playButton.setImageResource(R.drawable.redridingplaybutton)
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
        playButton.setImageResource(R.drawable.redridingpausebutton)
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

            val textColor = resources.getColor(R.color.highlightColor) // Highlighted text color
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
                        10 -> textView11.highlightCharacter(charIndex, textColor, normalColor)
                        11 -> textView12.highlightCharacter(charIndex, textColor, normalColor)
                        12 -> textView13.highlightCharacter(charIndex, textColor, normalColor)
                        13 -> textView14.highlightCharacter(charIndex, textColor, normalColor)
                        14 -> textView15.highlightCharacter(charIndex, textColor, normalColor)
                        15 -> textView16.highlightCharacter(charIndex, textColor, normalColor)
                        16 -> textView17.highlightCharacter(charIndex, textColor, normalColor)
                        17 -> textView18.highlightCharacter(charIndex, textColor, normalColor)
                        18 -> textView19.highlightCharacter(charIndex, textColor, normalColor)
                        19 -> textView20.highlightCharacter(charIndex, textColor, normalColor)
                        20 -> textView21.highlightCharacter(charIndex, textColor, normalColor)
                        21 -> textView22.highlightCharacter(charIndex, textColor, normalColor)
                        22 -> textView23.highlightCharacter(charIndex, textColor, normalColor)
                        23 -> textView24.highlightCharacter(charIndex, textColor, normalColor)
                        24 -> textView25.highlightCharacter(charIndex, textColor, normalColor)
                        25 -> textView26.highlightCharacter(charIndex, textColor, normalColor)
                    }
                }, (remainingDuration.toFloat() / (text.length - remainingTextIndex) * (charIndex - remainingTextIndex)).toLong())
            }
        }
    }

    private fun highlightText(index: Int, startTime: Int = 0) {
        if (index >= 0 && index < textChunks.size) {
            val text = textChunks[index]
            val duration = audioDurations[index]

            val textColor = resources.getColor(R.color.highlightColor) // Highlighted text color
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
                        10 -> textView11.highlightCharacter(charIndex, textColor, normalColor)
                        11 -> textView12.highlightCharacter(charIndex, textColor, normalColor)
                        12 -> textView13.highlightCharacter(charIndex, textColor, normalColor)
                        13 -> textView14.highlightCharacter(charIndex, textColor, normalColor)
                        14 -> textView15.highlightCharacter(charIndex, textColor, normalColor)
                        15 -> textView16.highlightCharacter(charIndex, textColor, normalColor)
                        16 -> textView17.highlightCharacter(charIndex, textColor, normalColor)
                        17 -> textView18.highlightCharacter(charIndex, textColor, normalColor)
                        18 -> textView19.highlightCharacter(charIndex, textColor, normalColor)
                        19 -> textView20.highlightCharacter(charIndex, textColor, normalColor)
                        20 -> textView21.highlightCharacter(charIndex, textColor, normalColor)
                        21 -> textView22.highlightCharacter(charIndex, textColor, normalColor)
                        22 -> textView23.highlightCharacter(charIndex, textColor, normalColor)
                        23 -> textView24.highlightCharacter(charIndex, textColor, normalColor)
                        24 -> textView25.highlightCharacter(charIndex, textColor, normalColor)
                        25 -> textView26.highlightCharacter(charIndex, textColor, normalColor)
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

fun TextView.highlightCharacter(charIndex: Int, highlightColor: Int, normalColor: Int) {
    val textLength = this.text.length
    if (charIndex < 0 || charIndex >= textLength) {
        Log.e("HighlightCharacter", "Invalid charIndex: $charIndex, text length: $textLength")
        return
    }

    val spannable = SpannableString(this.text)
    spannable.setSpan(ForegroundColorSpan(highlightColor), charIndex, charIndex + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    this.text = spannable
}