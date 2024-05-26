package com.frenchfri.lego

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class brl_kr : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var brl_tbtn1: ToggleButton
    private lateinit var brl_tbtn2: ToggleButton
    private lateinit var brl_tbtn3: ToggleButton
    private lateinit var brl_tbtn4: ToggleButton
    private lateinit var brl_tbtn5: ToggleButton
    private lateinit var brl_tbtn6: ToggleButton
    private lateinit var translate_result: TextView
    private lateinit var enter_btn: Button
    private lateinit var backspace_btn: Button
    private lateinit var voice_btn: Button
    private lateinit var result_kr_tv: TextView
    private lateinit var tts: TextToSpeech

    private val translatedResultBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brl_kr)

        brl_tbtn1 = findViewById(R.id.brl_tbtn1)
        brl_tbtn2 = findViewById(R.id.brl_tbtn2)
        brl_tbtn3 = findViewById(R.id.brl_tbtn3)
        brl_tbtn4 = findViewById(R.id.brl_tbtn4)
        brl_tbtn5 = findViewById(R.id.brl_tbtn5)
        brl_tbtn6 = findViewById(R.id.brl_tbtn6)
        translate_result = findViewById(R.id.translate_tv)
        enter_btn = findViewById(R.id.enter_btn)
        backspace_btn = findViewById(R.id.backspacebtn)
        voice_btn = findViewById(R.id.voice_btn)
        result_kr_tv = findViewById(R.id.result_kr_tv)

        enter_btn.setOnClickListener {
            addNewBrailleCharacter()
            resetToggleButtons()
        }

        backspace_btn.setOnClickListener {
            backspaceTranslation()
        }

        voice_btn.setOnClickListener {
            speakOut()
        }

        tts = TextToSpeech(this, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts.setLanguage(Locale.KOREAN)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            }
        } else {
        }
    }

    private fun speakOut() {
        val text = result_kr_tv.text.toString()
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    private fun addNewBrailleCharacter() {
        val dots = mutableListOf<Int>()
        if (brl_tbtn1.isChecked) dots.add(1)
        if (brl_tbtn2.isChecked) dots.add(2)
        if (brl_tbtn3.isChecked) dots.add(3)
        if (brl_tbtn4.isChecked) dots.add(4)
        if (brl_tbtn5.isChecked) dots.add(5)
        if (brl_tbtn6.isChecked) dots.add(6)

        translatedResultBuilder.append(brailleChar(dots))

        translate_result.text = translatedResultBuilder.toString()
    }

    private fun resetToggleButtons() {
        brl_tbtn1.isChecked = false
        brl_tbtn2.isChecked = false
        brl_tbtn3.isChecked = false
        brl_tbtn4.isChecked = false
        brl_tbtn5.isChecked = false
        brl_tbtn6.isChecked = false
    }

    private fun backspaceTranslation() {
        if (translatedResultBuilder.isNotEmpty()) {
            val lastIndex = translatedResultBuilder.length - 1
            translatedResultBuilder.deleteCharAt(lastIndex)
            translate_result.text = translatedResultBuilder.toString()
        }
    }

    private fun brailleChar(dots: List<Int>): Char {
        val base = 0x2800
        var offset = 0
        for (dot in dots) {
            offset += 1 shl (dot - 1)
        }
        return (base + offset).toChar()
    }

    override fun onDestroy() {

        if (tts.isSpeaking) {
            tts.stop()
        }
        tts.shutdown()
        super.onDestroy()
    }
}


