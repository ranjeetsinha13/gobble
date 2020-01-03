package com.rs.gobble.network.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val results: List<Recipe>,
    val baseUri: String
)

@Entity(tableName = "favourite_recipes")
data class Recipe(
    @PrimaryKey
    val id: Long,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    @SerializedName("image")
    val imageUrl: String,
    @Ignore
    val imageUrls: List<String>? = emptyList()
) {
    constructor(
        id: Long,
        title: String,
        readyInMinutes: Int,
        servings: Int,
        imageUrl: String
    ) : this(id, title, readyInMinutes, servings, imageUrl, null)
}