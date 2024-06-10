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

class snow_white : AppCompatActivity() {
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
    private lateinit var textView28: TextView
    private lateinit var textView29: TextView
    private lateinit var textView30: TextView
    private lateinit var textView31: TextView
    private lateinit var textView32: TextView
    private lateinit var textView33: TextView
    private lateinit var textView34: TextView
    private lateinit var textView35: TextView
    private lateinit var textView36: TextView
    private lateinit var textView37: TextView
    private lateinit var textView38: TextView
    private lateinit var textView39: TextView
    private lateinit var textView40: TextView
    private lateinit var textView41: TextView
    private lateinit var textView42: TextView
    private lateinit var playButton: ImageButton
    private lateinit var stopButton: Button

    private var isPaused = false // Flag to track whether audio playback is paused
    private var playbackPosition = 0 // Variable to store playback position when pausing
    private var isPlaying = false // Flag to track the current state of the media player

    private val textChunks = listOf(
        "Once upon a time, there was a lovely young princess called Snow White. She lived in a big castle at the edge of a deep, dark forest.",
        "Snow White's mother had died when she was a baby, and her father married again.\\nThe new queen, Snow White's stepmother, was very beautiful, but she was cruel and selfish, and did not love Snow White.",
        "Every morning, she stood before her magic mirror and asked,\\n\\n'Mirror, mirror on the wall, who's the fairest of us all?'\\n\\nAnd every day, the magic mirror answered, My queen, you are the fairest one of all. This made the queen very happy.\\n",
        "As time passed, Snow White grew into a beautiful young girl. And one morning, the magic mirror had a different answer for the queen.\\n",
        "'You are beautiful, queen. That is true. But Snow White is even more lovely than you.'\\n\\n'What? This cannot be.'\\n\\nIn rage, she called for her huntsman. 'Take Snow White deep into the forest and kill her. Bring her heart back to me as proof that she is dead.'",
        "The huntsman took Snow White to the forest, but she was so sweet and gentle that he could not bring himself to harm her. 'Run away, child, and don't ever come back. If you do, the queen will have you killed.'\\n",
        "On his way home, the huntsman killed a wild boar and took its heart back to the queen. Snow White was terrified. It was getting dark, and she knew there were wolves and bears in the forest.",
        "With tears in her eyes, she stumbled over stones and tree roots. Thorny branches scratched her arms and tore her clothes. As darkness fell, she came to a neat little cottage in a clearing.\\n",
        "The door was open, so she tiptoed in. She saw seven dwarves sitting at a table eating their dinner.\\n\\n'Who are you, child?' asked the oldest dwarf. 'And what has brought you here?'\\n",
        "'I am Princess Snow White. My stepmother, the queen, hates me and wants to have me killed. I am so frightened, and I have nowhere to go.'\\n",
        "'You can stay with us, said one of the dwarves. The queen will not find you here, and we will keep you safe.'\\n'Thank you', said Snow White.\\n",
        "The next morning, the seven dwarves left for work in the mines, as they did every day. 'Keep the door locked and don't let anyone in. We will be home at dinner time.'\\n",
        "Snow White spent the morning cleaning and tidying the cottage. She opened the window so she could hear the birds singing, and she sang along with them. Meanwhile, in the castle, the wicked queen stood before her magic mirror.",
        "\\n'Mirror, mirror on the wall, who's the fairest of us all?'\\n\\nAnd the mirror replied, 'You, oh queen, have beauty rare, but Princess Snow White is still more fair.'\\n\\n'What? The huntsman tricked me! Where is Snow White?'\\n",
        "The mirror, which always told the truth, replied, 'She lives in a cottage deep in the wood, with seven dwarves who are kind and good.'\\n'I will find her and kill her myself', the queen declared.\\n",
        "She quickly disguised herself as a little old woman, then filled a basket with bright silk ribbons and took it to the forest. She quickly found the dwarves' cottage and knocked on the door. Pretty ribbons for sale, she called in a croaky voice.",
        "Looking out the window, Snow White smiled when she saw the colourful ribbons. She remembered the dwarves' warning. But what harm could an old peddler woman do? Snow White let her in.\\n",
        "'Let me lace up your dress with this lovely red ribbon', said the queen, winding it around Snow White's waist. She pulled it so tight that Snow White couldn't breathe and fell to the floor in a faint. Cackling with delight, the queen rushed back to the castle.\\n",
        "That evening, when the dwarves found Snow White lying on the floor, they quickly guessed what had happened. They untied the ribbon and Snow White came back to life. When she had her breath back, she told the dwarves about the peddler woman.\\n",
        "'The queen must have sent that old woman to hurt you. Please, don't let anyone in tomorrow.' Snow White promised she wouldn't.\\n",
        "The next day, when the queen stood before her magic mirror, it told her. 'Snow White still lives happily in the wood and is still as lovely as she is good.' The queen was furious.\\n",
        "This time she went to her secret chamber hidden in the castle's highest tower. She made a poison potion and dipped a jewel comb in it, which she put in a basket with some other trinkets.\\n",
        "Then she disguised herself as another old woman and went off once again off to the cottage in the forest.\\n",
        "'Pretty trinkets to buy, pretty trinkets to buy.' She called through the window. Snow White could not resist the basket full of shiny things.\\n",
        "She let the old woman in. 'Let me put this sparkly comb in your lovely black hair', said the queen. As soon as the poison touched Snow White's head, she fell as if she were dead.\\n",
        "When the dwarves came home, they quickly took the comb out of Snow White's hair and once again she came back to life. 'Please', they begged her. 'Don't let anyone in. The queen is determined to hurt you', Snow White promised.\\n",
        "The next morning when the queen's mirror told her that Snow White was still alive and still more beautiful than she was, the queen flew into a frenzy. She rushed to her secret chamber and mixed up another magic potion, much stronger than the first.\\n",
        "She put the poison into a big rosy, red apple, disguised herself again and hurried to the dwarves' cottage. When she got there, Snow White was putting some pies on the windowsill to cool.\\n\\n'Good morning, my dear.'\\n",
        "'What tasty looking pies. They're cherry pies', said Snow White. 'I hope the dwarves will like them.'\\n",
        "'They'll love an apple pie even more. And I have some ripe juicy apples for you. I'm sorry, I must not let anyone in.'\\n",
        "'That's alright, I'll hand you an apple through the window. When you taste it, you'll want the whole basket full. Here, take a bite.'\\n",
        "She held up the poisoned apple. It looked so mouthwatering that Snow White could not resist. She took a big bite and instantly fell down as if she were dead.\\n",
        "This time, the dwarves could not bring Snow White back to life. No matter what they tried, Snow White stayed pale, cold and lifeless.\\n\\nThe dwarves could not bear to part with their beautiful princess.\\n",
        "They made a glass case to hold her and set it on a bed of wildflowers just outside their cottage. They kept watch day and night so that no one could harm their precious Snow White. \\n",
        "One morning, a prince from a nearby kingdom came riding through the forest.\\n",
        "When he saw Snow White, he was enchanted by her beauty.\\n\\n'Who is this?' he asked the dwarves. The dwarves explained who Snow White was and what had happened to her.\\n",
        "'She is the loveliest person I have ever seen', said the prince. 'Please, let me take her back to my palace.' The dwarves did not want to part with Snow White, but the prince begged and pleaded.\\n",
        "'I will love her and look after her forever', he promised. At last, they agreed. As the prince's servants lifted the case, one of them stumbled.\\n",
        "The case shook and a piece of poisoned apple that had been stuck in Snow White's throat dropped from her mouth. Instantly, she opened her eyes.\\n",
        "Snow White was alive! As soon as Snow White saw the prince, she fell in love with him.\\n",
        "They rode back to his kingdom together and soon they were married.\\n\\nOf course, all the dwarves came to the wedding and stayed to live in the palace. Snow White never saw her evil stepmother again.\\n",
        "She and the prince, along with the seven dwarves, lived happily for many, many long years.\\n\\n"
    )

    private val audioDurations = intArrayOf(5200, 5800, 10000, 5000, 10000, 6400, 7300, 6700, 6000, 4500, 4200, 6100, 8300, 8200, 8000, 7600, 6800, 8000, 6600, 6000, 6500, 7500, 3100, 4500, 6000, 7500, 6500, 8500, 4000, 5000, 4000, 6000, 4000, 5000, 7000, 6000, 19000, 18000, 5000, 7000, 8000, 5000)
    private val HIGHLIGHT_START_DELAY = 2000

    private var currentChunkIndex = 0
    private val handler = android.os.Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snow_white)
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
        val text = "Snow White and the Seven Dwarfs"
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
        textView28 = findViewById(R.id.textView28)
        textView29 = findViewById(R.id.textView29)
        textView30 = findViewById(R.id.textView30)
        textView31 = findViewById(R.id.textView31)
        textView32 = findViewById(R.id.textView32)
        textView33 = findViewById(R.id.textView33)
        textView34 = findViewById(R.id.textView34)
        textView35 = findViewById(R.id.textView35)
        textView36 = findViewById(R.id.textView36)
        textView37 = findViewById(R.id.textView37)
        textView38 = findViewById(R.id.textView38)
        textView39 = findViewById(R.id.textView39)
        textView40 = findViewById(R.id.textView40)
        textView41 = findViewById(R.id.textView41)
        textView42 = findViewById(R.id.textView42)
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
        mediaPlayer = MediaPlayer.create(this, R.raw.snowwhite)
        mediaPlayer?.seekTo(playbackPosition)
        mediaPlayer?.start()

        isPlaying = true
        isPaused = false

        // Start text highlighting after the initial delay
        handler.postDelayed({
            highlightText(currentChunkIndex)
        }, HIGHLIGHT_START_DELAY.toLong())

        // Update the play button image resource
        playButton.setImageResource(R.drawable.snowwhitepausebutton)

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
        playButton.setImageResource(R.drawable.snowwhiteplaybutton)
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
        playButton.setImageResource(R.drawable.snowwhitepausebutton)
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

            val textColor = resources.getColor(R.color.highlightColorSnow) // Highlighted text color
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
                        27 -> textView28.highlightCharacter(charIndex, textColor, normalColor)
                        28 -> textView29.highlightCharacter(charIndex, textColor, normalColor)
                        29 -> textView30.highlightCharacter(charIndex, textColor, normalColor)
                        30 -> textView31.highlightCharacter(charIndex, textColor, normalColor)
                        31 -> textView32.highlightCharacter(charIndex, textColor, normalColor)
                        32 -> textView33.highlightCharacter(charIndex, textColor, normalColor)
                        33 -> textView34.highlightCharacter(charIndex, textColor, normalColor)
                        34 -> textView35.highlightCharacter(charIndex, textColor, normalColor)
                        35 -> textView36.highlightCharacter(charIndex, textColor, normalColor)
                        36 -> textView37.highlightCharacter(charIndex, textColor, normalColor)
                        37 -> textView38.highlightCharacter(charIndex, textColor, normalColor)
                        38 -> textView39.highlightCharacter(charIndex, textColor, normalColor)
                        39 -> textView40.highlightCharacter(charIndex, textColor, normalColor)
                        40 -> textView41.highlightCharacter(charIndex, textColor, normalColor)
                        41 -> textView42.highlightCharacter(charIndex, textColor, normalColor)
                    }
                }, (remainingDuration.toFloat() / (text.length - remainingTextIndex) * (charIndex - remainingTextIndex)).toLong())
            }
        }
    }

    private fun highlightText(index: Int, startTime: Int = 0) {
        if (index >= 0 && index < textChunks.size) {
            val text = textChunks[index]
            val duration = audioDurations[index]

            val textColor = resources.getColor(R.color.highlightColorSnow) // Highlighted text color
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
                        27 -> textView28.highlightCharacter(charIndex, textColor, normalColor)
                        28 -> textView29.highlightCharacter(charIndex, textColor, normalColor)
                        29 -> textView30.highlightCharacter(charIndex, textColor, normalColor)
                        30 -> textView31.highlightCharacter(charIndex, textColor, normalColor)
                        31 -> textView32.highlightCharacter(charIndex, textColor, normalColor)
                        32 -> textView33.highlightCharacter(charIndex, textColor, normalColor)
                        33 -> textView34.highlightCharacter(charIndex, textColor, normalColor)
                        34 -> textView35.highlightCharacter(charIndex, textColor, normalColor)
                        35 -> textView36.highlightCharacter(charIndex, textColor, normalColor)
                        36 -> textView37.highlightCharacter(charIndex, textColor, normalColor)
                        37 -> textView38.highlightCharacter(charIndex, textColor, normalColor)
                        38 -> textView39.highlightCharacter(charIndex, textColor, normalColor)
                        39 -> textView40.highlightCharacter(charIndex, textColor, normalColor)
                        40 -> textView41.highlightCharacter(charIndex, textColor, normalColor)
                        41 -> textView42.highlightCharacter(charIndex, textColor, normalColor)
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