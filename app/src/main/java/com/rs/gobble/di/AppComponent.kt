package com.rs.gobble.di

import android.app.Application
import com.rs.gobble.GobbleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        NetworkModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBuildersModule::class]
)
interface AppComponent {
    fun inject(application: GobbleApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}