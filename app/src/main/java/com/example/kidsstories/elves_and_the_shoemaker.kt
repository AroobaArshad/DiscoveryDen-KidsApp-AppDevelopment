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

class elves_and_the_shoemaker : AppCompatActivity() {

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
    private lateinit var textView27: TextView
    private lateinit var playButton: ImageButton
    private lateinit var stopButton: Button

    private var isPaused = false // Flag to track whether audio playback is paused
    private var playbackPosition = 0 // Variable to store playback position when pausing
    private var isPlaying = false // Flag to track the current state of the media player

    private val textChunks = listOf(
        "Once upon a time, there was a kind old shoemaker. He lived with his wife above his workshop. Though the shoemaker worked very hard, he was very poor.\\n\\nAt last, the day came when he had no more money to buy leather. There was only enough leather on his workbench to make one more pair of shoes.",
        "With a heavy heart, the shoemaker cut out the leather. He was very tired, so he left the leather on his workbench and went upstairs to bed.\\n",
        "'I will make the shoes in the morning' he told his wife. The next morning, when the shoemaker came downstairs, he had a big surprise.\\n",
        "There on his workbench was a brand-new pair of shoes. The most beautiful shoes he had ever seen.\\n\\nHe picked up the shoes and looked at them carefully, top to bottom and heel to toe.\\n",
        "'Look at those tiny, neat stitches. Not a single stitch out of place. These shoes are so fine, they'll fetch a very high price.' He put the shoes in his window right at the front where everyone could see them.\\n",
        "Very soon the door opened and in strode a handsome, well-dressed young man.\\n\\n'Good morning, sir. I would like to try on the shoes in the window. They are the finest I've ever seen.' The shoes fit the man perfectly and he paid a very good price for them.\\n",
        "'Thank you. I will tell all my friends what an excellent craftsman you are.'\\n\\nNow that he had some money, the shoemaker was able to buy more leather.\\n",
        "Enough to make two pairs of shoes. Once again, he cut out the leather and left it on the workbench.\\n",
        "'There will be plenty of time to make the shoes tomorrow morning', he said, as he and his wife climbed the stairs to bed.\\n",
        "Early the next morning, the shoemaker came down to his workshop, ready to start work. But once more, a surprise was waiting for him. There on his workbench were two pairs of fine, well-made shoes.\\n",
        "'I can't believe my eyes. Did I make these shoes in my sleep?' He put the shoes in his window and before even an hour had passed, he had sold both pairs for a very fine price indeed.\\n",
        "'Now I can buy enough leather to make four pairs of shoes', the shoemaker told his wife.\\n",
        "The next morning, when the shoemaker came down to his workshop, there on his workbench were four pairs of beautiful, shiny new shoes.\\n\\nJust as before, they were perfectly made, with not a stitch out of place. And just as before, the shoemaker sold all of them for a very good price.\\n",
        "He bought even more leather, cut out five pairs of shoes, and left the leather on his workbench.\\n\\nOf course, when he came down the next morning, there were five pairs of shoes, all perfectly made. The same thing happened the next day, and the day after that, and for many days after that.",
        "Before long, the shoemaker and his wife were rich. One evening, just before Christmas, the shoemaker said to his wife, 'We have been blessed with so much good fortune, but we still don't know who's been making the beautiful shoes. We must find out who's been helping us.'\\n",
        "His wife agreed. That night, the shoemaker left some leather on his workbench as usual. But instead of going up to bed, he and his wife hid behind a curtain.\\n",
        "They kept very still, and they waited, and waited.\\n\\nJust as the church clock struck midnight, the shop door flew open, and in came in two little elves, barefoot and dressed in tattered clothes. They danced across the shop and leapt up onto the workbench.\\n",
        "Picking up some needles and thread, they began to sew. Their nimble fingers moved so quickly that the shoes seemed to come together by magic.\\n\\nAs they worked, they sung, 'See our needles flash and gleam, as we sew each fine straight seam, every pair of shoes we stitch, Helps the shoemaker get rich.'",
        "Before long, they had finished their work, and the new shoes stood neatly on the workbench.\\n\\nAs quickly as they had arrived, the elves leapt from the workbench and danced out the shop door. The shoemaker and his wife looked at each other in amazement.\\n",
        "'Those little elves have been so good to us. We must find a way to thank them.'\\n\\n'Of course', his wife agreed.\\n",
        "'I have an idea. Did you see how thin and ragged their clothes were? And though they make fine shoes for us, they had none of their own. There's snow on the ground. Those poor little elves must be freezing.'\\n\\n'Yes', said the shoemaker. It's almost Christmas, so we should make some special gifts for them.\\n",
        "'You can make them some clothes, and I will make them some warm, sturdy boots. It'll be our turn to surprise them.'\\n\\nThe next day, the shoemaker used his finest leather to make two tiny pairs of boots.\\n",
        "Meanwhile, his wife knitted two warm coats, two woolly hats, and two pairs of trousers. They wrapped the clothes in tissue paper, tied with bright ribbons, and left the presents on the workbench. That night, they hid behind the curtain once again and waited for the two elves to arrive.\\n",
        "Just as before, the door opened at the stroke of midnight, and the elves danced in.\\n\\nWhen they leapt onto the workbench and saw the presents waiting for them, they danced with delight. The little elves eagerly tore open the parcels and put on their new clothes.\\n",
        "They took each other's hands and danced a little dance on the workbench, singing, 'Thank you, kind shoemaker. Thank you, good wife. May you both have a long and happy life.'\\n",
        "Then they leapt off the workbench and skipped merrily out the door. The elves never returned, but the shoemaker and his wife never forgot them.\\n",
        "They were always grateful for the help they had received when they were in need. And just as the elves had wished, they had a long and happy life together.\\n\\n"
    )

    private val audioDurations = intArrayOf(9400, 5000, 5000, 6000, 6400, 7700, 5000, 2800, 3200, 6700, 6200, 3400, 9800, 9800, 8400, 5600, 8600, 10500, 7400, 3800, 10300, 7700, 8700, 8400, 6800, 3900, 5000)
    private val HIGHLIGHT_START_DELAY = 2700

    private var currentChunkIndex = 0
    private val handler = android.os.Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_elves_and_the_shoemaker)
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

        val textView = findViewById<TextView>(R.id.textView50)
        val text = "The Elves and the Shoemaker"
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
        textView27 = findViewById(R.id.textView27)
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
        mediaPlayer = MediaPlayer.create(this, R.raw.elves_shoemaker)
        mediaPlayer?.seekTo(playbackPosition)
        mediaPlayer?.start()

        isPlaying = true
        isPaused = false

        // Start text highlighting after the initial delay
        handler.postDelayed({
            highlightText(currentChunkIndex)
        }, HIGHLIGHT_START_DELAY.toLong())

        // Update the play button image resource
        playButton.setImageResource(R.drawable.elvespausebutton)

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
        playButton.setImageResource(R.drawable.elvesplaybutton)
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
        playButton.setImageResource(R.drawable.elvespausebutton)
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

            val textColor = resources.getColor(R.color.highlightColorElves) // Highlighted text color
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
                        26 -> textView27.highlightCharacter(charIndex, textColor, normalColor)
                    }
                }, (remainingDuration.toFloat() / (text.length - remainingTextIndex) * (charIndex - remainingTextIndex)).toLong())
            }
        }
    }

    private fun highlightText(index: Int, startTime: Int = 0) {
        if (index >= 0 && index < textChunks.size) {
            val text = textChunks[index]
            val duration = audioDurations[index]

            val textColor = resources.getColor(R.color.highlightColorElves) // Highlighted text color
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
                        26 -> textView27.highlightCharacter(charIndex, textColor, normalColor)
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