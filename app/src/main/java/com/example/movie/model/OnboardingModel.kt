package com.example.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Irfan Andriansyah on 7/9/2019.
 */

data class OnboardingModel(
    @SerializedName("image")
    var image: String,
    @SerializedName("title_text")
    var titleText: String,
    @SerializedName("desc_text")
    var descText: String
)