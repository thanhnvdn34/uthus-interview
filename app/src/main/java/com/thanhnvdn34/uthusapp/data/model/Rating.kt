package com.thanhnvdn34.uthusapp.data.model

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double,
    @SerializedName("reviews")
    val reviews: Int,
)
