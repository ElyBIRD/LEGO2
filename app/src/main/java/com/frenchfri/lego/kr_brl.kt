package com.frenchfri.lego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.content.Intent

class kr_brl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_brl)

        val settingsButton = findViewById<ImageButton>(R.id.settings_button)
        settingsButton.setOnClickListener {
            val intent = Intent(this, user_setting::class.java)
            startActivity(intent)
        }
    }
}
