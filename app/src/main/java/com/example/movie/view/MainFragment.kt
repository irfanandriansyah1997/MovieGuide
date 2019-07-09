package com.example.movie.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.adapter.NewMovieAdapter
import com.example.movie.model.MovieModel
import com.example.movie.model.OnboardingModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_main.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val jsonReader = BufferedReader(InputStreamReader(resources.openRawResource(R.raw.list_new_movie)))
        val list = Gson().fromJson<ArrayList<MovieModel>>(jsonReader, object : TypeToken<ArrayList<MovieModel>>() {}.type)
        val movieAdapter = NewMovieAdapter(list)


        recycle_new_movie.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = movieAdapter
        }
    }

    companion object {
        fun newInstance(item: OnboardingModel): IntroFragment {
            return IntroFragment()
        }
    }
}