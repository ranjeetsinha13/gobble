package com.rs.gobble.network

import com.rs.gobble.network.data.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GobbleApi {

    @GET("/recipes/search")
    suspend fun searchRecipes(
        @Query("query") query: String,
        @Query("offset") offset: Int = 0,
        @Query("number") number: Int = 50
    ): SearchResponse
}