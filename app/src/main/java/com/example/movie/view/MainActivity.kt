package com.example.movie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, firstFragment).commit()
    }
}
