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

data class RecipeDetails(
    val id: Long,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    @SerializedName("image")
    val imageUrl: String,
    val vegetarian: Boolean,
    val vegan: Boolean,
    val glutenFree: Boolean,
    val veryPopular: Boolean,
    val preparationMinutes: Int,
    val cookingMinutes: Int,
    val sourceUrl: String,
    val spoonacularSourceUri: String,
    val healthScore: Int,
    val extendedIngredients: List<Ingredient>,
    val instructions: String,
    val nutrition: Nutrition,
    val analysedInstruction: List<AnalysedInstruction>
)

data class Ingredient(
    val id: Long,
    val aisle: String?,
    @SerializedName("image")
    val imageUrl: String,
    val consistency: String?,
    val name: String,
    val amount: Int?,
    val unit: String?
)

data class Nutrition(val caloricBreakdown: CaloricBreakdown)

data class CaloricBreakdown(
    val percentProtien: Double,
    val percentFat: Double,
    val percentCarbs: Double
)

data class AnalysedInstruction(
    val name: String,
    val steps: List<Step>
)

data class Step(
    val number: Int,
    val step: String,
    val ingredients: List<Ingredient>
)