package com.example.movie.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movie.R
import com.example.movie.model.OnboardingModel
import kotlinx.android.synthetic.main.fragment_intro.*

class IntroFragment: Fragment() {
    private lateinit var item: OnboardingModel

    fun setItem(item: OnboardingModel) {
        this.item = item
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgResId = context!!.resources.getIdentifier(item.image, "drawable", context!!.packageName)
        imgTutorialImage.setImageResource(imgResId)
        txtTutorialTitle.text = item.titleText
        txtTutorialDesc.text = item.descText
    }

    companion object {

        fun newInstance(item: OnboardingModel): IntroFragment {
            val fragment = IntroFragment()
            fragment.setItem(item)
            return fragment
        }
    }
}