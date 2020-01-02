package com.rs.gobble.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rs.gobble.viewmodels.SearchViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(favoriteShowsViewModel: SearchViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: GobbleViewModelFactory): ViewModelProvider.Factory
}

@MapKey
@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)