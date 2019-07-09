package com.example.movie.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movie.model.OnboardingModel
import com.example.movie.view.IntroFragment


class OnboardingAdapter(fm: FragmentManager, list: ArrayList<OnboardingModel>): FragmentPagerAdapter(fm) {
    private var list = ArrayList<OnboardingModel>()

    init {
        this.list = list
    }

    override fun getItem(i: Int): Fragment {
        return IntroFragment.newInstance(list.get(i))
    }

    override fun getCount(): Int {
        return list.size
    }
}