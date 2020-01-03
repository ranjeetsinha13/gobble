package com.rs.gobble.repository

import com.rs.gobble.db.FavoritesDao
import com.rs.gobble.network.GobbleApi
import com.rs.gobble.network.data.Recipe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GobbleRepository @Inject
constructor(private val favoritesDao: FavoritesDao, private val gobbleApi: GobbleApi) {

    suspend fun allFavoriteRecipes(): List<Recipe> {
        return favoritesDao.allFavouriteRecipes()
    }

    suspend fun searchRecipes(query: String) = gobbleApi.searchRecipes(query)
}