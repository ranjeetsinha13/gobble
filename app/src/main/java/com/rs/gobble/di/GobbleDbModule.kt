package com.rs.gobble.di

import android.content.Context
import androidx.room.Room
import com.rs.gobble.db.FavoritesDao
import com.rs.gobble.db.GobbleDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object GobbleDbModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideGobbleDatabase(context: Context): GobbleDatabase {
        return Room.databaseBuilder(
            context,
            GobbleDatabase::class.java, GobbleDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideShowDao(tvMazeDatabase: GobbleDatabase): FavoritesDao {
        return tvMazeDatabase.favoritesDao()
    }
}