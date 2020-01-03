package com.rs.gobble.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rs.gobble.network.data.Recipe

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class GobbleDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao

    companion object {
        const val DATABASE_NAME = "gobble.db"
    }
}