package com.rs.gobble.db

import androidx.room.*
import com.rs.gobble.network.data.Recipe

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favourite_recipes")
    suspend fun allFavouriteRecipes(): List<Recipe>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)

    @Delete
    suspend fun remove(recipe: Recipe)

    @Query("DELETE FROM favourite_recipes")
    suspend fun clear()
}