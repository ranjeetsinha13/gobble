package com.rs.gobble.di

import com.rs.gobble.ui.fragments.FavoritesFragment
import com.rs.gobble.ui.fragments.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module

abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun bindFavoriteFragment(): FavoritesFragment
}