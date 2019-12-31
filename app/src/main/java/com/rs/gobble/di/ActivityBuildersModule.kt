package com.rs.gobble.di

import com.rs.gobble.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}