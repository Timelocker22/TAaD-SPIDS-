package com.example.trainingappandduels // Убедитесь, что тут написан ваш пакет

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        val btnBack = findViewById<androidx.appcompat.widget.AppCompatImageButton>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }


        // 1. Получаем доступ к системному менеджеру звука Android
        val audioManager = getSystemService(android.content.Context.AUDIO_SERVICE) as android.media.AudioManager

// 2. Находим наш Slider и картинку Mute по их ID из XML
        val sliderVolume = findViewById<com.google.android.material.slider.Slider>(R.id.slider_volume)
        val imgMute = findViewById<android.widget.ImageView>(R.id.btn_mute) // Укажите ID вашей картинки звука

// 3. Узнаем максимальную громкость медиа на данном телефоне (обычно это 15 уровней)
        val maxVolume = audioManager.getStreamMaxVolume(android.media.AudioManager.STREAM_MUSIC)
// Узнаем текущую громкость, которая установлена сейчас
        val currentVolume = audioManager.getStreamVolume(android.media.AudioManager.STREAM_MUSIC)

// 4. Настраиваем Slider под параметры телефона
        sliderVolume.valueFrom = 0f
        sliderVolume.valueTo = maxVolume.toFloat()
        sliderVolume.value = currentVolume.toFloat()

// 5. Отслеживаем перемещение ползунка пользователем
        sliderVolume.addOnChangeListener { _, value, _ ->
            // Устанавливаем системную громкость музыки в соответствии с ползунком
            audioManager.setStreamVolume(
                android.media.AudioManager.STREAM_MUSIC,
                value.toInt(),
                android.media.AudioManager.FLAG_SHOW_UI // Этот флаг покажет стандартную системную плашку громкости сверху
            )
        }

// 6. Дополнительно: делаем кнопку Mute рабочей при клике (сброс в 0)
        imgMute.setOnClickListener {
            sliderVolume.value = 0f
            audioManager.setStreamVolume(android.media.AudioManager.STREAM_MUSIC, 0, android.media.AudioManager.FLAG_SHOW_UI)
        }


        // 1. Находим наши кнопки "Светлая" и "Тёмная" по их ID из XML
        val btnThemeLight = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btn_theme_light)
        val btnThemeDark = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btn_theme_dark)

// 2. Логика для кнопки "Светлая"
        btnThemeLight.setOnClickListener {
            // Принудительно включаем светлую тему внутри приложения
            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(
                androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
            )
        }

// 3. Логика для кнопки "Тёмная"
        btnThemeDark.setOnClickListener {
            // Принудительно включаем тёмную тему внутри приложения
            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(
                androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
            )
        }

    }
}
