package com.frenchfri.lego

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class Lobby : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cam_button = findViewById<ImageButton>(R.id.cam_button)
        cam_button.setOnClickListener {
            val intent = Intent(this, brl_cam::class.java)
            startActivity(intent)
        }

        val brl_btn = findViewById<ImageButton>(R.id.brl_btn)
        brl_btn.setOnClickListener {
            val intent = Intent(this, brl_kr::class.java)
            startActivity(intent)
        }

        val kr_btn = findViewById<ImageButton>(R.id.kr_btn)
        kr_btn.setOnClickListener {
            val intent = Intent(this, kr_brl::class.java)
            startActivity(intent)
        }
    }
}