package com.rs.gobble.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Padding
import androidx.ui.layout.Row
import androidx.ui.material.Typography
import com.rs.gobble.R
import com.rs.gobble.di.Injectable
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
        Column {
            searchForm("") { query ->

                if (query.isEmpty()) {
                    return@searchForm
                }
                // TODO send the query to viewModel and update the UI
            }
            VerticalScroller(modifier = Flexible(1f)) {
                Column {
                    arrayListOf<String>("1", "2", "3").map {
                        Row {
                            Padding(10.dp, 2.dp, 2.dp, 10.dp) {
                                Text(it, style = Typography().body1)
                            }
                        }
                    }
                }
            }
        }
    }
}