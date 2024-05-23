package com.frenchfri.lego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton

class brl_kr : AppCompatActivity() {

    private lateinit var brl_tbtn1: ToggleButton
    private lateinit var brl_tbtn2: ToggleButton
    private lateinit var brl_tbtn3: ToggleButton
    private lateinit var brl_tbtn4: ToggleButton
    private lateinit var brl_tbtn5: ToggleButton
    private lateinit var brl_tbtn6: ToggleButton
    private lateinit var translate_result: TextView
    private lateinit var enter_btn: Button

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
        translate_result = findViewById(R.id.translate_result)
        enter_btn = findViewById(R.id.enter_btn)

        enter_btn.setOnClickListener {

            addNewBrailleCharacter()
            resetToggleButtons()
        }
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

    private fun brailleChar(dots: List<Int>): Char {
        val base = 0x2800
        var offset = 0
        for (dot in dots) {
            offset += 1 shl (dot - 1)
        }
        return (base + offset).toChar()
    }
}

