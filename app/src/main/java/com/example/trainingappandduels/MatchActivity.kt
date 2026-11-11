package com.example.trainingappandduels

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_choosing)
        val btnBack = findViewById<androidx.appcompat.widget.AppCompatImageButton>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
    }
}