package com.rs.gobble

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.*
import com.rs.gobble.ui.GobbleApp
import com.rs.gobble.viewmodels.SearchViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GobbleApp(resources)
        }

        val vm = ViewModelProviders.of(this, viewModelFactory)[SearchViewModel::class.java]
        vm.getSearchResponse("fat")
    }
}