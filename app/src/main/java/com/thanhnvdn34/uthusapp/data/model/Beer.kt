package com.thanhnvdn34.uthusapp.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "beers")
data class Beer(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
    @Ignore
    @SerializedName("rating")
    val rating: Rating?,
    @SerializedName("price")
    val price: String,
    var description: String?,
    var isSave: Boolean? = false,
) {
    constructor(id: Int, name: String, image: String, price: String, description: String?): this(
        id, name, image, null, price, description)
}