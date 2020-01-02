package com.rs.gobble.network.data

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val results: List<Recipe>,
    val baseUri: String
)


data class Recipe(
    val id: Long,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    @SerializedName("image")
    val imageUrl: String,
    val imageUrls: List<String>?
)