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

class jack_and_the_beanstalk : AppCompatActivity() {
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
    private lateinit var playButton: ImageButton
    private lateinit var stopButton: Button

    private var isPaused = false // Flag to track whether audio playback is paused
    private var playbackPosition = 0 // Variable to store playback position when pausing
    private var isPlaying = false // Flag to track the current state of the media player

    private val textChunks = listOf(
        "Once upon a time, there was a boy named Jack who lived with his poor widowed mother. They had sold almost everything they owned to buy food.\\n",
        "When their last cow stopped giving milk, Jack's mother sent him to town to sell it.",
        "On the way to town, Jack met a strange fellow who told him stories of magic beans.\\n",
        "'Where can I buy some of these magic beans for my mother?' asked Jack.\\n\\n'I have the last five magic beans, and I will sell them to you because you are a good boy.' The strange man smiled at Jack.\\n",
        "'Well, I have nothing but our old cow, and we need the money I would get by selling her for food.'\\n\\nThe man replied, 'Trust me, my boy. These beans will bring you food and fortune, and your mother will be proud.'",
        "\\nJack hesitated, but finally traded the cow for the beans. When Jack returned home, his mother was furious and threw the beans out of the kitchen window crying.\\n",
        "Jack went to bed that night, sad and hungry. He woke the next morning to find a huge beanstalk growing in the garden.\\n\\n'The beans really are magic', he cried.\\n",
        "Jack saw that the stalk reached the clouds. He remembered stories about the clouds containing gold and started climbing the stalk to see what he could find.\\n",
        "When he got to the top, he saw a huge castle and headed for it.\\n\\nThe door was so big that Jack could crawl beneath it. Once inside, he saw a giant man eating his dinner.\\n",
        "When the giant was finished, he called his servant to bring him his bag of gold coins.\\n\\nWhile counting his money, the giant became drowsy and fell asleep. Jack crept up to the giant and stole his bag of gold.\\n",
        "He struggled down the beanstalk with his money, and when he got to the bottom, he called for his mother.\\n\\nJack's mother was very happy because this money was the same money that the giant had stolen from Jack's father many years ago. But she was also afraid.\\n",
        "She knew how dangerous the giant was and made Jack promise he would never go back. While Jack did promise, after a while the money began to run out.\\n\\nJack began to wonder if he would find anything else in the castle.\\n",
        "Once again, Jack decided he would go back up the beanstalk and back to the castle. Once again, he reached the castle and climbed under the castle door. And once again, he found the giant eating dinner at his table.\\n",
        "When he was finished this time, however, the giant called for his magic hen.\\n",
        "Jack was amazed when he saw the hen lay an egg of pure gold. While the giant was watching the hen, he again became drowsy and fell asleep.\\n\\nJack crept silently to the table and grabbed the hen.\\n",
        "When he returned home, his mother was very angry that Jack had gone back to the castle. She grabbed Jack's axe, intent on cutting the beanstalk down.\\n",
        "Jack begged her not to and showed her how the hen could lay gold in eggs. Jack's mother put the axe down and watched with delight as the hen laid one beautiful golden egg after another.\\n",
        "After a while, Jack's curiosity got the better of him and he once again thought about what else he could find in the castle.\\n",
        "Once again, Jack decided he would go back up the beanstalk and back to the castle. Once again, he reached the castle and climbed under the castle door. And once again, he found the giant eating dinner at his table.\\n",
        "And once again, when he was finished this time, however, the giant called for his magic harp.\\n\\nJack watched as the harp began to play beautiful music all by itself. The music was so beautiful that before long, the lazy giant once again fell fast asleep.\\n",
        "Jack crept silently to the table. But as soon as Jack picked up the harp, it began playing very loudly in his strange hands. And the giant awoke!\\n\\n'Thee-fie-foe-fum', yelled the giant, and he chased after the boy and his harp.\\n",
        "Jack raced to the beanstalk and slid down. He could feel the stalk shake as the giant began climbing down. Luckily, his axe was nearby, and he began chopping down the beanstalk.\\n",
        "The beanstalk shook and cracked under the weight of the giant and Jack's chopping. Finally, the stalk snapped, and the giant fell to earth, never to be seen again.\\n",
        "Jack and his mother lived happily ever after.\\n\\n"
    )

    private val audioDurations = intArrayOf(5200, 2900, 3000, 7200, 7600, 5900, 6300, 6000, 8000, 8500, 8500, 8000, 6000, 6000, 4000, 6000, 14000, 15000, 7000, 6000, 19000, 18000, 5000, 7000)
    private val HIGHLIGHT_START_DELAY = 2500

    private var currentChunkIndex = 0
    private val handler = android.os.Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jack_and_the_beanstalk)
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
        val text = "Jack and the Beanstalk"
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
        mediaPlayer = MediaPlayer.create(this, R.raw.jack_beanstalk)
        mediaPlayer?.seekTo(playbackPosition)
        mediaPlayer?.start()

        isPlaying = true
        isPaused = false

        // Start text highlighting after the initial delay
        handler.postDelayed({
            highlightText(currentChunkIndex)
        }, HIGHLIGHT_START_DELAY.toLong())

        // Update the play button image resource
        playButton.setImageResource(R.drawable.jackpausebutton)

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
        playButton.setImageResource(R.drawable.jackplaybutton)
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
        playButton.setImageResource(R.drawable.jackpausebutton)
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

            val textColor = resources.getColor(R.color.highlightColorJack) // Highlighted text color
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
                    }
                }, (remainingDuration.toFloat() / (text.length - remainingTextIndex) * (charIndex - remainingTextIndex)).toLong())
            }
        }
    }

    private fun highlightText(index: Int, startTime: Int = 0) {
        if (index >= 0 && index < textChunks.size) {
            val text = textChunks[index]
            val duration = audioDurations[index]

            val textColor = resources.getColor(R.color.highlightColorJack) // Highlighted text color
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