package com.example.trainingappandduels // Ваш пакет

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Находим кнопку "Настройки" по её ID из вашего XML макета
        val btnSettings = findViewById<MaterialButton>(R.id.btn_settings)

        // 2. Описываем, что делать при нажатии на неё
        btnSettings.setOnClickListener {
            // Создаем намерение (Intent) переключиться с текущего экрана на SettingsActivity
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        // 1. Находим вашу кнопку-картинку по ID из XML
        val btnMatch = findViewById<MaterialButton>(R.id.btn_fast_match)

        // 2. Описываем, что делать при нажатии на неё
        btnMatch.setOnClickListener {
            // Создаем намерение (Intent) переключиться с текущего экрана на SettingsActivity
            val intent = Intent(this, MatchActivity::class.java)
            startActivity(intent)
        }
    }
}

