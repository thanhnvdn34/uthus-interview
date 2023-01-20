package com.thanhnvdn34.uthusapp.data.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: List<Beer>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("loadMore")
    val loadMore: Boolean
) {
    companion object {
        fun empty(): Data = Data("", emptyList(), 0, "", "", false)
    }
}