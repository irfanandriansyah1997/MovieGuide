package com.example.movie.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.movie.R
import com.example.movie.adapter.OnboardingAdapter
import com.example.movie.model.OnboardingModel
import kotlinx.android.synthetic.main.activity_intro.*
import org.jetbrains.anko.startActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class IntroActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        sharedPreferences = getSharedPreferences("edu.unikom.dontbealone.SHARED_PREFERENCES", Context.MODE_PRIVATE)

        val jsonReader = BufferedReader(InputStreamReader(resources.openRawResource(R.raw.list_onboarding)))
        val list = Gson().fromJson<ArrayList<OnboardingModel>>(jsonReader, object : TypeToken<ArrayList<OnboardingModel>>() {}.type)
        val tutorialPagerAdapter = OnboardingAdapter(supportFragmentManager, list)

        vpgTutorialViewPager.adapter = tutorialPagerAdapter
        bGetStarted.setOnClickListener(View.OnClickListener {
            sharedPreferences.edit().putBoolean("intro_seen", true).apply()
            startActivity<MainActivity>()
            finish()
        })
    }
}
