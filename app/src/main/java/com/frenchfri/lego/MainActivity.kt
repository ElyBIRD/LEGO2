package com.frenchfri.lego


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Lobby : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cam_button = findViewById<Button>(R.id.cam_button)
        cam_button.setOnClickListener {
            val intent = Intent(this, brl_cam::class.java)
            startActivity(intent)
        }


        val brl_btn : ImageButton = findViewById(R.id.brl_btn)
        brl_btn.setOnClickListener {
            val intent = Intent(this, brl_btn::class.java)
            startActivity(intent)
        }

        val kr_btn : ImageButton = findViewById(R.id.kr_btn)
        kr_btn.setOnClickListener {
            val intent = Intent(this, kr_btn::class.java)
            startActivity(intent)
        }
    }
}