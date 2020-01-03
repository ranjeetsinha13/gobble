package com.rs.gobble.viewmodels

import androidx.lifecycle.ViewModel
import com.rs.gobble.repository.GobbleRepository
import javax.inject.Inject

class FavoriteRecipesViewModel @Inject
constructor(private val gobbleRepository: GobbleRepository) : ViewModel()