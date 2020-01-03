package com.rs.gobble.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import com.rs.gobble.R
import com.rs.gobble.di.Injectable
import com.rs.gobble.extensions.observeData
import com.rs.gobble.network.Loading
import com.rs.gobble.network.NetworkError
import com.rs.gobble.network.ResponseState
import com.rs.gobble.network.Success
import com.rs.gobble.ui.widgets.searchForm
import com.rs.gobble.viewmodels.SearchViewModel
import javax.inject.Inject

class SearchFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[SearchViewModel::class.java]
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.view_fragment, container, false)
        (fragmentView as ViewGroup).setContent {
            discoverTab()
        }
        return fragmentView
    }

    @Composable
    private fun discoverTab() {
        FlexColumn {
            inflexible {
                searchForm("") { query ->
                    if (query.isEmpty()) {
                        return@searchForm
                    }
                    viewModel.getSearchResponse(query)
                }
            }
            flexible(1.0f) {
                val responseState = +viewModel.searchResponseLiveData.observeData()
                setViewState(responseState)
            }
        }
    }

    @Composable
    private fun <T> setViewState(responseState: ResponseState<T>?) {

        when (responseState) {
            is Loading -> {
                Text("Loading")
            }
            is Success -> {
                Text("Success")
            }
            is NetworkError -> {
                Text("Error")
            }
        }
    }

    @Composable
    private fun SingleRecipeView(recipe: String) {
        Ripple(bounded = true) {
            Clickable(onClick = {
                // navigateTo(Screen.Article(post.id))
            }) {
                Row(modifier = Spacing(16.dp)) {
                    Text(recipe)
                }
            }
        }
    }
}