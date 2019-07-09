package com.example.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Irfan Andriansyah on 7/9/2019.
 */

data class MovieModel(
    @SerializedName("title")
    var title: String,

    @SerializedName("length")
    var length: String,

    @SerializedName("category")
    var category: ArrayList<String>,

    @SerializedName("available")
    var available: ArrayList<String>
)