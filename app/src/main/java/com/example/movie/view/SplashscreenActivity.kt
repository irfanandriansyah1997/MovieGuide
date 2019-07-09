package com.example.movie.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.schedule
import com.example.movie.R
import java.util.*

class SplashscreenActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        sharedPreferences = getSharedPreferences("com.example.movie.SHARED_PREFERENCES", Context.MODE_PRIVATE)
        Timer("SplashScreen", false).schedule(1000) {
            var i : Intent

//            if (sharedPreferences.getBoolean("intro_seen", false)) {
//                i = Intent(this@SplashScreenActivity, MainActivity::class.java)
//            } else
//                i = Intent(this@SplashscreenActivity, IntroActivity::class.java)

            i = Intent(this@SplashscreenActivity, IntroActivity::class.java)
            startActivity(i)
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}